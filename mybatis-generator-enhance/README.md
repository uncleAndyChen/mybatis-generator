# MyBatis Generator（MBG），写扩展类，以适应 MySQL 大小写敏感配置的各种情况、适应分表时动态替换表名
## MySQL 数据库驱动版本与数据库版本问题
用高版本的数据库驱动`mysql-connector-java 8.0.13`连接低版本数据库`MySQL 5.7.23`，会有以下问题：
1. 报错
    ```
    Cannot obtain primary key information from the database, generated objects may be incomplete
    ...
    ```
1. 生成的 mapper 缺少以下接口：
    ```
    deleteByPrimaryKey
    selectByPrimaryKey
    updateByPrimaryKeySelective
    updateByPrimaryKey
    ```

### 解决
数据库驱动与数据库版本匹配即可，作者在以下两个版本（5.x与8.x）测试通过：
1. 数据库驱动`mysql-connector-java 8.0.13`连接数据库`MySQL 8.0.11`，对应`driverClassName: com.mysql.cj.jdbc.Driver`
1. 数据库驱动`mysql-connector-java 5.1.29`连接数据库`MySQL 5.7.23`，对应`driverClassName: com.mysql.jdbc.Driver`

本项目的MBG扩展类工程，数据库驱动版本，使用的是当前最新的`mysql-connector-java 8.0.13`，仅支持连接高版本MySQL 8.x。

如果要在`MySQL 5.7.x`下运行，只需要修改以下两个地方（注意是5.7.x，其它5.x版本没测试）：
1. 修改pom.xml中`mysql-connector.version`，改为低版本`5.1.39`。
1. 本项目的执行，依赖根目录下的`generatorConfig.xml`文件，将其中`driverClass`，由`com.mysql.cj.jdbc.Driver`改为`com.mysql.jdbc.Driver`。

## 本扩展的作用
1. 生成的*Mapper.xml文件中的脚本，表名取MBG所需配置文件中配置的值（工程中的配置文件是：generatorConfig.xml），而不是从数据库读取到的值。
1. 给表名添加MySQL“边界”，用 \`（左上角数字键1左边、Tab键上边、Esc键下边的键）引起来。

## 解决两个问题
1. 适应lower_case_table_names的三种配置值。
1. 利用MyBatis插件，根据业务规则，对表名进行动态替换。

注：项目根目录下有更详细的介绍，点击以下链接查看：
- github: https://github.com/uncleAndyChen/mybatis-generator
- gitee:  https://gitee.com/uncleAndyChen/mybatis-generator

## 自己扩展的好处
1. 比起直接修改MBG源代码，这种方式对MBG无代码侵入，方便将来升级MBG。
1. 符合面向对象设计的【开闭原则】，即通过增加代码来为软件添加新功能，而不是直接修改原有代码。这一点，MBG做得非常好，除了可以非常方便的扩展之外，还可以写各种插件以实现自己的业务需要。

## 使用自己的扩展类
在配置文件generatorConfig.xml的context节点，配置runtime值，指向自己的扩展类，需要带包名，如本例：
```xml
<context id="Mysql" targetRuntime="mybatis.generator.enhance.IntrospectedTableEnhanceImpl" defaultModelType="flat">
```

扩展类的代码很简单，只有十几行
```java
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;

public class IntrospectedTableEnhanceImpl extends IntrospectedTableMyBatis3Impl {
    @Override
    public String getFullyQualifiedTableNameAtRuntime() {
        return getTableNameFromConfigFile();
    }

    @Override
    public String getAliasedFullyQualifiedTableNameAtRuntime() {
        return getTableNameFromConfigFile();
    }

    private String getTableNameFromConfigFile() {
        String tableName = this.getTableConfiguration().getTableName();
        return "`" + tableName + "`";
    }
}
```

## 两种运行方式
### 以程序方式运行
仿照官方的`org.mybatis.generator.api.ShellRunner`，写一段代码，以程序的方式运行。本工程的代码如下：
```java
public class GeneratorEnhanceRun {
    public static void main(String[] args) {
        try {
            List<String> warnings = new ArrayList<String>();
            /**
             * 初始化配置解析器
             */
            ConfigurationParser cp = new ConfigurationParser(warnings);

            /**
             * 获取配置文件信息
             */
            FileInputStream fileInputStream = new FileInputStream(ConfigProperties.getValue("configFile"));

            /**
             * 调用配置解析器创建配置对象
             */
            Configuration config = cp.parseConfiguration(fileInputStream);
            /**
             * shellcallback接口主要用来处理文件的创建和合并，传入overwrite参数；默认的shellcallback是不支持文件合并的；
             */
            DefaultShellCallback callback = new DefaultShellCallback(true);
            /**
             * 创建一个MyBatisGenerator对象。MyBatisGenerator类是真正用来执行生成动作的类
             */
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            /**
             * 用System.out打印执行过程
             */
            ProgressCallback progressCallback = new VerboseProgressCallback();

            /**
             *  执行生成操作
             */
            myBatisGenerator.generate(progressCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

本工程，直接运行`GeneratorEnhanceRun`下的`main`方法，在运行之前需要先修改`resources`目录下的配置文件`application.properties`，将MBG运行需要的配置文件路径配置对。
```
configFile=C:/workspace/mbg/mybatis-generator/generatorConfig.xml
```

### cmd窗口运行jar文件
- 下MBG的jar包，[传送门](https://github.com/mybatis/generator/releases)，解压，找到`mybatis-generator-1.3.7.jar`备用。
- 将本模块生成jar文件，生成的jar文件名`mybatis-generator-enhance.jar`。
- 将两个jar文件以及配置文件放到model与dal项目所在的目录下，在 cmd 窗口执行：
```
java -Dfile.encoding=UTF-8 -cp mybatis-generator-1.3.7.jar;mybatis-generator-enhance.jar org.mybatis.generator.api.ShellRunner -configfile generatorConfig.xml -overwrite
```
> 这里通过 -cp 指定需要用到的所有jar包，用分号隔开，这样在运行的时候才能找到相应的类。

## 原理
简单的说，就是自己的实现类`IntrospectedTableEnhanceImpl`继承自MBG的一个具体实现类，重写获取表名的方法。

IntrospectedTable是MBG提供的一个比较基础的扩展类，相当于可以重新定义一个runtime。如果要通过继承IntrospectedTable完成扩展，需要自己来实现生成XML和Java代码的所有代码，也可以直接继承IntrospectedTableMyBatis3Impl，重写自己需要的业务逻辑，本模块就是直接继承自该类。

要扩展自己的业务逻辑，建议先仔细阅读IntrospectedTableMyBatis3Impl和IntrospectedTableMyBatis3SimpleImpl，这两个类用得多一些。

在MBG中，提供了几种默认的IntrospectedTable的实现，其实在context上设置的runtime对应的就是不同的IntrospectedTable的实现，下面是几种runtime和对应的实现类：
- MyBatis3 (default)：org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl
- MyBatis3Simple：org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3SimpleImpl
- Ibatis2Java2：org.mybatis.generator.codegen.ibatis2.IntrospectedTableIbatis2Java2Impl
- Ibatis2Java5：org.mybatis.generator.codegen.ibatis2.IntrospectedTableIbatis2Java5Impl
