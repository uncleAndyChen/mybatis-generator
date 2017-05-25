### 需求场景
1. 首先，我项目的 Java 代码规范是变量命名应用驼峰式命名法（Camel-Case）。数据库表名及字段名，则用下划线命名法（即用下划线分隔不同单词）。
1. 我用 MBG 生成的代码，通过配置可以将下划线去掉，同时将下划线后的第一个字母转为大写，这样是符合驼峰式命名法的。
1. 但是，问题来了。我们项目前后端分离，前端调用 Restful Api，在传递的参数中难免需要以表名来定义对象，而以字段名作为对象的属性来传递参数，而 Java 写的 Api 在接收参数时，是用 Pojo 来跟前端传的参数匹配的。
1. 这样有两个问题，前端在传参数的时候需要将表名和字段名由下划线命名法转为驼峰式命名法，Java 代码也以同样的方式定义对应的类名以及属性字段，在这个过程中，容易出错，相对直接 copy 表名及字段名，需要做额外的工作，而且前后端都有。
1. 如果数据库表名和字段名本身就是驼峰式命名法的话，写代码的时候直接 copy 表名或字段名，这样既不容易出错，还能节省时间。说干就干，改！表名及字段名遵循驼峰式命名法。
1. 这样做的目的无非是让大家能偷偷懒，还减少出错的概率，同时也轻松的达到了统一代码范围的目的。
1. 但是，再一次，问题来了。windows 下的 MySQL 默认不区分大小写，这样表名和字段名都全部变成小写的了。这个好办，修改配置可达到目的。
1. 第二个问题是，MBG 生成的代码也将表名全部改成了小写的了...
1. 最后，需求场景出来了，我需要保持数据库表名大小写来生成对应的类和 mapper 文件。

### 解决办法
1. 怎么破？查了很多资料，也看了官方文档，都没有找到相应的配置，也就是说，保持数据库表名大小写来生成对应的类和 mapper 文件，是不能通过配置来解决的。
1. 只能看源码了。思路是：一步步跟踪，找到了真正取数据库表名的地方。
1. 虽然过程比较痛苦，但是达到目的之后，还是小有成就感的。
1. 其实改动很少，只是找到要改的地方才是关键。就象平时改 Bug 一样，修改可能很小，但是找到要修改的地方才是最花时间和精力的，每每这个时候，就非常渴求得力的测试人才。
1. 废话少说，下面切入正题。

### 关于 MBG (MyBatis Generator)
截至到笔者写这篇文章，最后的 Release 版本是1.3.5。
1. 下载地址：[MyBatis Generator Release 1.3.5](https://github.com/mybatis/generator/releases/tag/mybatis-generator-1.3.5)
1. [官方文档](http://www.mybatis.org/generator/)
1. [热心网友翻译的中文版本](http://mbg.cndocs.tk/)，不过是基于 1.3.3 版本的，也还是很有参考价值的。

关于 MBG 的介绍，看官网或者看热心网友汉化的版本，足够了，本文的重点是修改源代码，让 MGB 在生成的代码里，对应的类和 mapper 文件保持与对应的表名大小写不变。

### 修改源码
一共需要修改 org.mybatis.generator.api.IntrospectedTable 这个类的两个方法。需要修改的第一个方法在1522行，第二个方法，紧随其后。

```java
    /**
     * Gets the fully qualified table name at runtime.
     *
     * @return the fully qualified table name at runtime
     */
    public String getFullyQualifiedTableNameAtRuntime() {
//        return internalAttributes
//                .get(InternalAttribute.ATTR_FULLY_QUALIFIED_TABLE_NAME_AT_RUNTIME);
        return this.getTableConfiguration().getTableName();
    }

    /**
     * Gets the aliased fully qualified table name at runtime.
     *
     * @return the aliased fully qualified table name at runtime
     */
    public String getAliasedFullyQualifiedTableNameAtRuntime() {
//        return internalAttributes
//                .get(InternalAttribute.ATTR_ALIASED_FULLY_QUALIFIED_TABLE_NAME_AT_RUNTIME);
        return this.getTableConfiguration().getTableName();
    }
```

这两个方法里面的前两行注释了的代码是官方的，最后那行代码是我修改之后的。

### 生成对应的类和 mapper 文件
#### 对应的测试数据库脚本
```sql
create schema if not exists mbg default character set utf8;

use mbg;
set names utf8;

drop table if exists erpTrade;
create table erpTrade
(
   tradeID              int not null auto_increment,
   tid                  bigint comment '订单号',
   shopID               int,
   memberID             bigint comment '针对的会员ID，同步会员时反写',
   buyerNick            national varchar(50),
   sellerID             bigint comment '店铺用户，主旺旺 ID',
   primary key (tradeID)
);

drop table if exists erpEnterpriseMember;
create table erpEnterpriseMember
(
   memberID             bigint not null auto_increment,
   shopID               int,
   nickname             varchar(50) comment '会员昵称',
   realName             varchar(50) comment '真实姓名',
   sex                  int comment '性别 1.男 2.女 3.未知',
   created              int,
   modified             int,
   primary key (memberID)
);

drop table if exists erpShopConfig;
create table erpShopConfig
(
   ID                   int not null auto_increment,
   shopID               int,
   mobile               varchar(200) comment '接收短信手机号，多个以逗号隔开',
   email                varchar(200) comment '邮箱地址，多个以逗号隔开',
   isNotifyBalanceLess  int comment '当短信账户余额为X条时，系统免费发送短信提醒您及时充值。',
   balanceLessValue     int comment '余额不足提醒值',
   isNotifyBeforeExpire int comment '是否发送软件快到期提醒',
   beforeDaysExpire     int comment '软件快到期提醒时间，提前天数',
   created              int,
   modified             int,
   primary key (ID)
);
```

#### 生成表配置信息的 Java 工具类
MBG 基于一个 xml 配置文件，在这个配置文件里，有跟表相关的配置，为了达到我的需求，需要一张表对应一行配置信息，所以，我写了一个类来自动生成，这样，在增减表，或者别的项目里面，可以简单的运行这个类来生成，减少手工劳动。
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成所有 MBG 配置文件里，与表相关的代码
 * 需要配置数据表名，见 main 函数里的变量 schemaName
 */
public class GetSchemaTables
{
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) throws Exception
    {
        String schemaName = "mbg";
        String getPrimaryKeySqlFormat = "select column_name from information_schema.key_column_usage where table_schema='" + schemaName + "' and table_name='%s';";
        String getPrimaryKeySql;
        String primaryKey;
        ResultSet rs;

        initConnection("com.mysql.jdbc.Driver", "jdbc:mysql://192.168.0.130:3306/" + schemaName + "?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&autoReconnect=true&failOverReadOnly=false&socketTimeout=20000", "root", "root");
        ResultSet resultSet = getMetaDataTables();
        List<String> tableNames = new ArrayList();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbMapperXml = new StringBuilder();

        while (resultSet.next())
        {
            tableNames.add(resultSet.getString("Tables_in_" + schemaName + ""));
        }

        for (String tableName : tableNames)
        {
            getPrimaryKeySql = String.format(getPrimaryKeySqlFormat, tableName);
            rs = statement.executeQuery(getPrimaryKeySql);
            primaryKey = "";

            while (rs.next()) //这里没有深究，应该有更好的方式。
            {
                primaryKey = rs.getString("column_name");
                break;
            }

            sb.append("<table tableName=\"");
            sb.append(tableName);
            sb.append("\"");
            sb.append(" domainObjectName=\"");

            //如果有某些表不希望去掉前缀，则特别处理
            if (tableName.equals("erpTrade"))
            {
                sb.append("erpTrade");
            }
            //下面的代码是去掉表名前缀，这里是去掉前面三个字母，如果没有前缀或者希望保留前缀，则请注释掉下面的代码。
            else
            {
                sb.append(tableName.substring(3));
            }

            sb.append("\"><property name=\"useActualColumnNames\" value=\"true\"/>");
            sb.append("<generatedKey identity=\"true\" type=\"post\" column=\"" + primaryKey + "\" sqlStatement=\"Mysql\"/>");
            sb.append("</table>\r\n");
        }

        sb.append("\r\n\r\n");
        sb.append(sbMapperXml.toString());
        System.out.println(sb.toString());
    }

    private static void initConnection(String driverClass, String dbUrl, String username, String password) throws Exception
    {
        Class.forName(driverClass);//指定连接类型
        connection = DriverManager.getConnection(dbUrl, username, password);//获取连接
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    private static ResultSet getMetaDataTables() throws Exception
    {
        String sql = "show tables;";
        ResultSet rs = statement.executeQuery(sql);
        return rs;
    }
}
```

#### 运行该工具类
![运行生成表配置信息的 Java 工具类](http://elsafly.oschina.io/img/MBGGeneratorTableConfig.jpg)
直接运行，会报错。
```
Exception in thread "main" java.lang.ClassNotFoundException: com.mysql.jdbc.Driver
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:264)
	at GetSchemaTables.initConnection(GetSchemaTables.java:77)
	at GetSchemaTables.main(GetSchemaTables.java:22)
```

修改 pom.xml 文件，添加依赖即可。
```xml
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.39</version>
            <scope>runtime</scope>
        </dependency>
```

如果你运行的时候依然报错，象下面这样的错
```xml
Exception in thread "main" com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at com.mysql.jdbc.Util.handleNewInstance(Util.java:404)
	at com.mysql.jdbc.SQLError.createCommunicationsException(SQLError.java:988)
	at com.mysql.jdbc.MysqlIO.<init>(MysqlIO.java:341)
	at com.mysql.jdbc.ConnectionImpl.coreConnect(ConnectionImpl.java:2251)
	at com.mysql.jdbc.ConnectionImpl.connectOneTryOnly(ConnectionImpl.java:2284)
	at com.mysql.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:2083)
	at com.mysql.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:806)
	at com.mysql.jdbc.JDBC4Connection.<init>(JDBC4Connection.java:47)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at com.mysql.jdbc.Util.handleNewInstance(Util.java:404)
	at com.mysql.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:410)
	at com.mysql.jdbc.NonRegisteringDriver.connect(NonRegisteringDriver.java:328)
	at java.sql.DriverManager.getConnection(DriverManager.java:664)
	at java.sql.DriverManager.getConnection(DriverManager.java:247)
	at GetSchemaTables.initConnection(GetSchemaTables.java:78)
	at GetSchemaTables.main(GetSchemaTables.java:22)
Caused by: java.net.ConnectException: Connection timed out: connect
	at java.net.DualStackPlainSocketImpl.connect0(Native Method)
	at java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)
	at java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)
	at java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)
	at java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)
	at java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)
	at java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)
	at java.net.Socket.connect(Socket.java:589)
	at com.mysql.jdbc.StandardSocketFactory.connect(StandardSocketFactory.java:211)
	at com.mysql.jdbc.MysqlIO.<init>(MysqlIO.java:300)
	... 16 more
```

开发数据库经常 Connection timed out。
终极武器来了！修改连接参数。
```java
initConnection("com.mysql.jdbc.Driver", "jdbc:mysql://192.168.0.130:3306/" + schemaName + "?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&autoReconnect=true&failOverReadOnly=false&socketTimeout=20000", "root", "root");
```
导致上面的错误，应该是网络不太稳定的原因。修改成上面的连接参数之后，会至少尝试三次，一般很少尝试三次还连接不上的。
最终，生成的代码如下：
```xml
<table tableName="erpEnterpriseMember" domainObjectName="EnterpriseMember"><property name="useActualColumnNames" value="true"/><generatedKey identity="true" type="post" column="memberID" sqlStatement="Mysql"/></table>
<table tableName="erpShopConfig" domainObjectName="ShopConfig"><property name="useActualColumnNames" value="true"/><generatedKey identity="true" type="post" column="ID" sqlStatement="Mysql"/></table>
<table tableName="erpTrade" domainObjectName="erpTrade"><property name="useActualColumnNames" value="true"/><generatedKey identity="true" type="post" column="tradeID" sqlStatement="Mysql"/></table>
```

将生成的代码放到配置文件 generatorConfig.xml 下面这行代码的上面
```xml
</context>
```

最终的 generatorConfig.xml，如下：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <!--数据库驱动-->
    <classPathEntry location="mysql-connector-java-5.1.31.jar"/>
    <!--<context id="DB2Tables" targetRuntime="MyBatis3">-->
    <!--如果你希望不生成和Example查询有关的内容，那么可以按照如下进行配置:-->
    <!--<context id="DB2Tables" targetRuntime="MyBatis3Impl">-->
    <context id="Mysql" targetRuntime="MyBatis3" defaultModelType="flat">
    <!--<context id="Mysql" targetRuntime="MyBatis3Simple" defaultModelType="flat">-->
        <commentGenerator>
            <property name="suppressDate" value="true"/>
            <property name="suppressAllComments" value="true"/>
        </commentGenerator>
        <!--数据库链接地址账号密码-->
        <jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql://192.168.0.130:3306/mbg?useUnivalue=true&amp;characterEncoding=utf8&amp;autoReconnect=true&amp;failOverReadOnly=false"
                        userId="root" password="root">
        </jdbcConnection>
        <javaTypeResolver>
            <property name="forceBigDecimals" value="false"/>
        </javaTypeResolver>
        <!--生成Model类存放位置-->
        <javaModelGenerator targetPackage="mybatis.generator.model.entity" targetProject="mybatis.generator.model/src/main/java/">
            <property name="enableSubPackages" value="true"/>
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>
        <!--生成映射文件存放位置-->
        <sqlMapGenerator targetPackage="mappers\original" targetProject="mybatis.generator.dal\src\main\resources">
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>
        <!--生成Dao类存放位置
        当type=XMLMAPPER时，会生成一个XXX.xml文件内有各种sql语句，是mapper的实现。
        当type=ANNOTATEDMAPPER时，会直接在mapper接口上添加注释。
        -->
        <!--
        http://blog.csdn.net/qq_27376871/article/details/51360638
        MyBatis3:
        ANNOTATEDMAPPER:基于注解的Mapper接口，不会有对应的XML映射文件
        MIXEDMAPPER:XML和注解的混合形式，(上面这种情况中的)SqlProvider注解方法会被XML替代。
        XMLMAPPER:所有的方法都在XML中，接口调用依赖XML文件。
        MyBatis3Simple:
        ANNOTATEDMAPPER:基于注解的Mapper接口，不会有对应的XML映射文件
        XMLMAPPER:所有的方法都在XML中，接口调用依赖XML文件。
        -->
        <javaClientGenerator type="XMLMAPPER" targetPackage="mybatis.generator.dal.mapper"
                             targetProject="mybatis.generator.dal/src/main/java/">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>
        <!--生成对应表及类名-->
        <table tableName="erpEnterpriseMember" domainObjectName="EnterpriseMember"><property name="useActualColumnNames" value="true"/><generatedKey identity="true" type="post" column="memberID" sqlStatement="Mysql"/></table>
        <table tableName="erpShopConfig" domainObjectName="ShopConfig"><property name="useActualColumnNames" value="true"/><generatedKey identity="true" type="post" column="ID" sqlStatement="Mysql"/></table>
        <table tableName="erpTrade" domainObjectName="erpTrade"><property name="useActualColumnNames" value="true"/><generatedKey identity="true" type="post" column="tradeID" sqlStatement="Mysql"/></table>
    </context>
</generatorConfiguration>
```

#### 运行 MBG
1. 以 [IntelliJ IDEA](http://www.jetbrains.com/idea/) 为例
为了测试，除了从官网下载的 MBG 源码外，另外添加了两个模块。
先创建一个空项目，然后导入 MBG，添加两个测试模块，或者直接从码云下载我的代码。注意模块的包路径要与配置文件里的一致，否则会提示路径找不到。
创建一个空项目
![创建一个空项目](http://elsafly.oschina.io/img/MBGDemoStepOne.jpg)
导入模块
![导入模块](http://elsafly.oschina.io/img/MBGDemoStepTwo.jpg)

##### 直接运行源码。
新建一个启动应用，选 MGB 下的 ShellRunner 作为启动入口
![](http://elsafly.oschina.io/img/MBGRunFromSourceCode.jpg)
按下图所示，在参数一栏写：-configfile generatorConfig.xml -overwrite，选 mybatis-generator-1.3.5 模块
![](http://elsafly.oschina.io/img/MBGRunFromSourceCodeConfig.jpg)
接下来，应该知道如何运行或者调试了吧。

##### 生成 jar 包，一次生成，随处运行
1. 将 MBG 打包成 jar 包，把该 jar 包和 mysql-connector-java-5.1.31.jar、generatorConfig.xml 一起放到项目的根目录下，在 dos 窗口，或者 IDEA 的 Terminal 窗口直接运行下面的命令。
```
java -Dfile.encoding=UTF-8 -cp mybatis-generator-1.3.5.jar org.mybatis.generator.api.ShellRunner -configfile generatorConfig.xml -overwrite
```
1. 推荐用这种方式。这样不需要将 MBG 项目添加到公司的具体项目，而且通常这项工作由某一个人做就行了，其它项目组成员，可以不知道该工具的存在。

##### 下面是生成 MBG jar 包的步骤
按 Ctrl+Alt+Shift+s，进入项目设置界面

生成 MBG jar 包第一步，配置
![](http://elsafly.oschina.io/img/MBGToJar.jpg)
生成 MBG jar 包第二步，Build Artifacts...
![](http://elsafly.oschina.io/img/MBGToJarStepTwo.jpg)