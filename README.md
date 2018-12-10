# MyBatis Generator (MBG)，修改源码以适应 MySQL 大小写敏感配置的各种情况
## 本文对应的项目
- github:[https://github.com/uncleAndyChen/mybatis-generator](https://github.com/uncleAndyChen/mybatis-generator)
- giteee:[https://gitee.com/uncleAndyChen/mybatis-generator](https://gitee.com/uncleAndyChen/mybatis-generator)

### 通过本项目，可以学到的知识点
1. 可以理解使用MBG的大致流程。
1. 本文中用到的MBG配置可以作为一个标准配置的参考。
1. spring boot 2.1.1 获取 application.yml 配置信息，项目【create-table-property】是一个很好的参考。
1. 通过MBG如何生成dal与model项目。
    - 生成的代码，绝大部分可直接使用，比如简单的增、删、改、查。
    - 对应数据库表的实体类，一张表一个实体类，可用于在各层传递基于表数据的业务数据。
1. 通过 IDEA 管理多项目。
    - 获取项目源码，用 IDEA 导入的时候，指向根目录的 pom.xml 即可。

### 更新记录
- 2018-12-09
    - 将 MBG 版本由 1.3.5 升级至当前最新版 1.3.7。
    - 将 mybatis 由 3.4.1 升级至 3.4.6。
    - 修改和完善本说明文档。
    - 重构生成表配置的类：`CreateTablePropertyService`，优化完善了相关代码、添加数据库的各种配置信息，更易于使用和维护。
    - 将生成表配置的类`CreateTablePropertyService`单独提取至一个独立的项目，以尽可能少的修改官方项目`mybatis-generator-core`源码。
    - 重命名model与dal模块名，更易于理解。
    - 在根目录添加 pom.xml，方便 IDEA 通过该文件直接导入。

## 先科普一下 lower_case_table_names 参数 
官方文档：[Identifier Case Sensitivity](https://dev.mysql.com/doc/refman/5.7/en/identifier-case-sensitivity.html)

1. lower_case_table_names是mysql一个大小写敏感设置的属性，此参数不可以动态修改，必须重启数据库。
1. unix,linux下lower_case_table_names默认值为 0 .Windows下默认值是 1 .Mac OS X下默认值是 2。

参数说明
1. `lower_case_table_names=0` 表名存储为给定的大小写。比较时：区分大小写。大小写敏感（Unix，Linux默认）。
>　创建的库表将原样保存在磁盘上。如create database TeSt;将会创建一个TeSt的目录，create table AbCCC ...将会原样生成AbCCC.frm。SQL语句也会原样解析。

1. `lower_case_table_names=1` 表名存储为小写。比较时：不区分大小写。大小写不敏感（Windows默认）。
> 创建的库表时，MySQL将所有的库表名转换成小写存储在磁盘上。SQL语句同样会将库表名转换成小写。如需要查询以前创建的Test_table（生成Test_table.frm文件），即便执行select * from Test_table，也会被转换成select * from test_table，致使报错表不存在。

1. `lower_case_table_names=2` 表名存储为给定的大小写。比较时：小写。
> 创建的库表将原样保存在磁盘上。但SQL语句将库表名转换成小写。

## 不适用场景
如果开发环境、生产环境均配置成1或者2，则本文中有关大小写敏感的修改都是无意义的。

但是如果分库时依赖表名替换，则又是适用的，见以下【适用场景】中的场景二。

## 适用场景
最终目标：MBG 生成的mapper类名、xml文件名、以及xml文件中的sql脚本的表名，保持与对应表名在建表时的大小写一致。也就是，MBG生成的代码，保持大小写敏感，这样可以适应以上lower_case_table_names的三种配置值。

### 场景一
1. 其中有数据库服务器被设置成大小写不敏感（比如阿里云的云数据库，截至目前2018年12月9号，还不支持配置成大小写敏感），即 `lower_case_table_names=1`，且该参数不能修改。
1. 为了统一命名规范使用驼峰式命名法，包括：数据库名、数据库表名、数据库字段名、编程语言。这样的话，可以控制`lower_case_table_names`的linux服务器，就可以将该参数设置为0，即大小写敏感。
1. 用 MGB 生成的 Mapper 类名，以及 xml 文件中的表名，需要与创建表名时的原始大小写一致，以适应在`lower_case_table_names=0`（linux）或者`lower_case_table_names=2`（windows）的情况。

当然，读到这里，你可能会觉得奇怪，数据库的库名、表名、字段名，业界都是用下划线分开的，其余字母全是小写，所以，该参数被配置成什么都不需要关心。

如果你也这么认为，那么，本文对你是没有价值的。

本文要解决的问题是，数据库的库名、表名、字段名，需要保持跟 Java 的编码规范一致的场景。如果都统一成一种编码规则，比如统一用驼峰式命名法，那么，不用在两种编码习惯上切换，可以提高编码效率和减少不必要的麻烦，且继续往下看。

### 场景二
- 分库时依赖表名替换，需要将表名用`\``（1左边的键）引起来。
> 等工作不那么忙的时候，会分享我的基于MyBatis 插件分库分表项目
