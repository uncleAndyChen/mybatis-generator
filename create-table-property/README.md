# 连接MySQL生成MBG需要的表配置信息
**运行本工程生成表配置内容，一定要连接参数`lower_case_table_names`配置为0或者2的数据库服务器**，并且是配置为0或者2之后才创建的数据表，否则，生成的表配置内容的表名，是以全部小写为基准的，并非驼峰式命名法。表配置内容生成好之后，重新生成 mapper 时连接的数据库服务器的`lower_case_table_names`配置值，对生成结果没有影响。

## 数据库版本
当前配置在`MySQL 8.0.11`下测试通过，不支持`MySQL 5.x`。

如果要在`MySQL 5.7.x`下运行，只需要修改以下两个地方（注意是5.7.x，其它版本没测试）：
1. 修改pom.xml中`mysql-connector.version`，改为低版本`5.1.39`。
1. 修改`application.yml`中`driverClassName`，由`com.mysql.cj.jdbc.Driver`改为`com.mysql.jdbc.Driver`。

## 示例数据库建表脚本
可以直接导入`resources/schema.sql`运行本示例进行测试。数据库表没有任何业务逻辑，仅作为示例。
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

drop table if exists erpTradeJsonFormat;
create table erpTradeJsonFormat
(
   tradeJFID            int not null auto_increment  comment '',
   tid                  bigint  comment '交易编号 (父订单的交易编号)',
   shopID               int  comment '',
   syncTradeType        int  comment '订单同步方式: 1.rds 2.api',
   sellerID             bigint  comment '店铺用户，主旺旺 ID',
   sellerNickname       varchar(150)  comment '商家昵称',
   tradeBody            MEDIUMTEXT  comment '订单Json格式',
   created              int  comment '',
   modified             int  comment '',
   primary key (tradeJFID)
);

drop table if exists crmOrderNotGoodRate;
create table crmOrderNotGoodRate
(
   orderNGRID           int not null auto_increment  comment '',
   shopID               int  comment '',
   sellerID             bigint  comment '店铺用户，平台ID，在淘宝是 主旺旺 ID',
   memberID             bigint  comment '会员ID',
   tid                  bigint(20) not null  comment '交易编号 (父订单的交易编号)',
   oid                  bigint(20) not null default 0  comment '子订单编号',
   numIid               bigint(20) default 0  comment '商品数字ID',
   buyerRateContent     national varchar(500)  comment '评价内容,最大长度:500个汉字',
   buyerRateResult      int(11) default 1  comment '评价结果,1.good(好评), 2.neutral(中评), 3.bad(差评)',
   buyerRateCreated     int(11) default 0  comment '评价创建时间',
   created              int(11) default 0  comment '记录创建时间',
   primary key (orderNGRID)
);
```

## 数据库配置信息
数据库信息配置在`resources/application.yml`，运行前请修改成自己的数据库配置。
```
database:
  driverClassName: com.mysql.cj.jdbc.Driver
  databaseUrl: jdbc:mysql://localhost:3306/${database.schemaName}?serverTimezone=GMT&useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&autoReconnect=true&failOverReadOnly=false&socketTimeout=20000
  schemaName: mbg
  username: root
  password: RoOtPaSs
  # 要保留的表名前缀
  keepPrefix: crm
  # 表名前缀长度，后面生成的配置会将前缀去掉，根据自己的业务适当修改即可。
  tableNamePrefixCount: 3
  # 需要保留表前缀的表名列表，这里仅仅是示例，并没有任何业务逻辑。
  keepPrefixTableList:
    - erpTrade
    - erpShopConfig
  # 是否使用原始字段名
  flagUseActualColumnNames: true
```

## 运行
两种方式
1. 本工程采用 spring boot v2.1.1 创建，可直接运行，使用 tomcat 的默认端口8080，运行之后，访问：http://localhost:8080/getTableProperties
1. 运行测试`WithApplicationContextTest.getTablePropertiesTest`，从控制台查看。

## 生成的表配置信息，长什么样？
象下面这样
```xml
<table tableName="crmOrderNotGoodRate" domainObjectName="CrmOrderNotGoodRate"><property name="useActualColumnNames" value="true"/><generatedKey identity="true" type="post" column="orderNGRID" sqlStatement="Mysql"/></table>
<table tableName="erpEnterpriseMember" domainObjectName="EnterpriseMember"><property name="useActualColumnNames" value="true"/><generatedKey identity="true" type="post" column="memberID" sqlStatement="Mysql"/></table>
<table tableName="erpShopConfig" domainObjectName="ErpShopConfig"><property name="useActualColumnNames" value="true"/><generatedKey identity="true" type="post" column="ID" sqlStatement="Mysql"/></table>
<table tableName="erpTrade" domainObjectName="ErpTrade"><property name="useActualColumnNames" value="true"/><generatedKey identity="true" type="post" column="tradeID" sqlStatement="Mysql"/></table>
<table tableName="erpTradeJsonFormat" domainObjectName="TradeJsonFormat"><property name="useActualColumnNames" value="true"/><generatedKey identity="true" type="post" column="tradeJFID" sqlStatement="Mysql"/></table>
```

## 知识点
1. 可以通过本模块（IDEA的概念是module，Eclipse的概念是Project），学习 spring boot 2.1.1 获取 application.yml 配置信息。
1. 学习如何直接连数据库并读取数据库的所有表名，以及每张表的主键。
1. 带 spring boot 引导的单元测试，可以加载配置信息。
1. 多模块管理、将业务按功能拆分，比如业务无关的、可共用的工具类直接放到`common.lib`模块。