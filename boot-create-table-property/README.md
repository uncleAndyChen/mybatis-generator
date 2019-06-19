# 连接MySQL生成MBG需要的表配置信息
**运行本工程生成表配置内容，一定要连接参数`lower_case_table_names`配置为0或者2的数据库服务器**，并且是配置为0或者2之后才创建的数据表，否则，生成的表配置内容的表名，是以全部小写为基准的，并非驼峰式命名法。表配置内容生成好之后，重新生成 mapper 时连接的数据库服务器的`lower_case_table_names`配置值，对生成结果没有影响。

## 运行
两种方式
1. 本工程采用 spring boot v2.1.5 创建，可直接运行，使用 tomcat 的默认端口90，运行之后，访问：`http://localhost:90/getTableProperties`
    ![](./mbg-demo.png)
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

## 数据库版本
数据库驱动`mysql-connector-java 8.0.13`连接`MySQL 8.0.11`和`5.7.23`均测试通过。

## 示例数据库建表脚本
可以直接导入`resources/schema.sql`运行本示例进行测试。数据库表没有任何业务逻辑，仅作为示例。
```sql
drop schema if exists mbg;
create schema mbg default character set utf8mb4;
use mbg;
set names utf8mb4;

/*==============================================================*/
/* Table: sys_dept                                              */
/*==============================================================*/
create table sys_dept
(
   dept_id              int unsigned not null auto_increment  comment '部门id',
   name                 varchar(20) not null  comment '部门名称',
   parent_id            int unsigned not null default 0  comment '上级部门id',
   level                varchar(200) not null  comment '部门层级',
   sequence             int unsigned not null default 0  comment '部门在当前层级下的顺序，由小到大',
   status               tinyint unsigned not null default 1  comment '状态，1：正常，0：冻结',
   remark               varchar(200)  comment '备注',
   operate_ip           varchar(20) not null  comment '最后一次更新操作者的ip地址',
   operator             int unsigned not null  comment '操作者 id',
   created_at           datetime not null default CURRENT_TIMESTAMP  comment '创建时间',
   modified_at          datetime not null default CURRENT_TIMESTAMP  comment '最后一次更新时间',
   primary key (dept_id)
);

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu
(
   menu_id              int unsigned not null auto_increment  comment '',
   name                 varchar(50)  comment '菜单名',
   parent_id            varchar(36)  comment '菜单父id',
   icon                 varchar(255)  comment '图标，参考 ant design icon',
   router               varchar(255)  comment '路由值',
   parent_path          varchar(518)  comment '菜单层级',
   sequence             int unsigned  comment '排序值',
   status               tinyint unsigned not null default 1  comment '状态，1：正常，0：冻结',
   remark               varchar(200)  comment '备注',
   operate_ip           varchar(20) not null  comment '最后一次更新者的ip地址',
   operator             int unsigned not null  comment '操作者 id',
   created_at           datetime not null default CURRENT_TIMESTAMP  comment '创建时间',
   modified_at          datetime not null default CURRENT_TIMESTAMP  comment '最后一次更新时间',
   primary key (menu_id)
);

/*==============================================================*/
/* Table: sys_menu_action                                       */
/*==============================================================*/
create table sys_menu_action
(
   id                   int unsigned not null auto_increment  comment '',
   menu_id              int unsigned  comment '',
   code                 varchar(50)  comment '动作编号',
   name                 varchar(50)  comment '动作名称',
   status               tinyint unsigned not null default 1  comment '状态，1：正常，0：冻结',
   operate_ip           varchar(20) not null  comment '最后一个更新者的ip地址',
   operator             int unsigned not null  comment '操作者 id',
   created_at           datetime not null default CURRENT_TIMESTAMP  comment '创建时间',
   modified_at          datetime not null default CURRENT_TIMESTAMP  comment '最后一次更新时间',
   primary key (id)
);

/*==============================================================*/
/* Table: sys_menu_resource                                     */
/*==============================================================*/
create table sys_menu_resource
(
   id                   int unsigned not null auto_increment  comment '',
   menu_id              int unsigned  comment '菜单id',
   code                 varchar(50)  comment '资源代码',
   name                 varchar(50)  comment '资源名称',
   method               varchar(50)  comment '请求方式:GET,POST,DELETE 等',
   path                 varchar(255)  comment '请求路径',
   status               tinyint unsigned not null default 1  comment '状态，1：正常，0：冻结',
   operate_ip           varchar(20) not null  comment '最后一个更新者的ip地址',
   operator             int unsigned not null  comment '操作者 id',
   created_at           datetime not null default CURRENT_TIMESTAMP  comment '创建时间',
   modified_at          datetime not null default CURRENT_TIMESTAMP  comment '最后一次更新时间',
   primary key (id)
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   role_id              int unsigned not null auto_increment  comment '角色id',
   name                 varchar(20) not null  comment '角色名称',
   sequence             int unsigned not null default 0  comment '排序值',
   status               int unsigned not null default 1  comment '状态，1：可用，0：冻结',
   remark               varchar(200)  comment '备注',
   operate_ip           varchar(20) not null  comment '最后一次更新者的ip地址',
   operator             int unsigned not null  comment '操作者 id',
   created_at           datetime not null default CURRENT_TIMESTAMP  comment '创建时间',
   modified_at          datetime not null default CURRENT_TIMESTAMP  comment '最后一次更新时间',
   primary key (role_id)
);

/*==============================================================*/
/* Table: sys_role_menu                                         */
/*==============================================================*/
create table sys_role_menu
(
   id                   int unsigned not null auto_increment  comment '',
   role_id              int unsigned  comment '角色id',
   menu_id              int unsigned  comment '菜单id',
   action               varchar(2048)  comment '动作权限',
   resource             varchar(2048)  comment '资源权限',
   operate_ip           varchar(20) not null  comment '最后一个更新者的ip地址',
   operator             int unsigned not null  comment '操作者 id',
   created_at           datetime not null default CURRENT_TIMESTAMP  comment '创建时间',
   primary key (id)
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   user_id              int unsigned not null auto_increment  comment '用户id',
   username             varchar(20) not null  comment '用户名称（登录名）',
   real_name            varchar(64)  comment '真实姓名',
   mobile_number        varchar(11) not null  comment '手机号',
   email                varchar(20) not null  comment '邮箱',
   password             varchar(40) not null  comment '加密后的密码',
   dept_id              int unsigned not null default 0  comment '用户所在部门的id',
   status               tinyint unsigned not null default 1  comment '状态，1：正常，0：冻结状态，2：删除',
   remark               varchar(200)  comment '备注',
   operate_ip           varchar(20) not null  comment '最后一次更新者的ip地址',
   operator             int unsigned not null  comment '操作者 id',
   created_at           datetime not null default CURRENT_TIMESTAMP  comment '创建时间',
   modified_at          datetime not null default CURRENT_TIMESTAMP  comment '最后一次更新时间',
   primary key (user_id)
);

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   id                   int unsigned not null auto_increment  comment '',
   user_id              int unsigned not null  comment '用户id',
   role_id              int unsigned not null  comment '角色id',
   operate_ip           varchar(20) not null  comment '最后一次更新者的ip地址',
   operator             int unsigned not null  comment '操作者 id',
   created_at           datetime not null default CURRENT_TIMESTAMP  comment '创建时间',
   primary key (id)
);

-- 初台化部分数据
-- 用户表
INSERT INTO `sys_user` (`user_id`, `username`, `real_name`, `mobile_number`, `email`, `password`, `dept_id`, `status`, `remark`, `operate_ip`, `operator`, `created_at`, `modified_at`) VALUES ('1', 'administrator', '超级管理员', '13800138000', 'andy@lovesofttech.com', '123', '1', '1', '请勿删除', '', '0', '2019-06-19', '2019-06-19');

-- 部门表
INSERT INTO `sys_dept` (`dept_id`, `name`, `parent_id`, `level`, `sequence`, `status`, `remark`, `operate_ip`, `operator`, `created_at`, `modified_at`) VALUES
('1', '技术部', '0', '1', '100', '1', '技术', '', '1', '2019-06-19', '2019-06-19'),
('2', '研发后端', '1', '2', '110', '1', '后端', '', '1', '2019-06-19', '2019-06-19'),
('3', '研发前端', '1', '2', '120', '1', '前端', '', '1', '2019-06-19', '2019-06-19'),
('4', '产品', '1', '2', '130', '1', '产品', '', '1', '2019-06-19', '2019-06-19'),
('5', '设计', '1', '2', '140', '1', 'UI/UE', '', '1', '2019-06-19', '2019-06-19'),
('6', '测试', '1', '2', '150', '1', '测试', '', '1', '2019-06-19', '2019-06-19'),
('7', '运营部', '0', '1', '200', '1', '运营', '', '1', '2019-06-19', '2019-06-19'),
('8', '市场部', '0', '1', '300', '1', '市场', '', '1', '2019-06-19', '2019-06-19'),
('9', '人事部', '0', '1', '400', '1', '人事', '', '1', '2019-06-19', '2019-06-19'),
('10', '财务部', '0', '1', '500', '1', '财务', '', '1', '2019-06-19', '2019-06-19');

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

## 知识点
1. 可以通过本模块（IDEA的概念是module，Eclipse的概念是Project），学习 spring boot 2.1.1 获取 application.yml 配置信息。
1. 学习如何直接连数据库并读取数据库的所有表名，以及每张表的主键。
1. 带 spring boot 引导的单元测试，可以加载配置信息。
1. 多模块管理、将业务按功能拆分，比如业务无关的、可共用的工具类直接放到`common.lib`模块。