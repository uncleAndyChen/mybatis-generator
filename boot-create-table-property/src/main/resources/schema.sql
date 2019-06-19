drop schema if exists mbg;
create schema mbg default character set utf8mb4;
use mbg;
set names utf8mb4;

/*==============================================================*/
/* Table: sys_dept                                              */
/*==============================================================*/
create table sys_dept
(
   id                   int unsigned not null auto_increment  comment '部门 id',
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
   primary key (id)
);

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu
(
   id                   int unsigned not null auto_increment  comment '',
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
   primary key (id)
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
   id                   int unsigned not null auto_increment  comment '角色 id',
   name                 varchar(20) not null  comment '角色名称',
   sequence             int unsigned not null default 0  comment '排序值',
   status               int unsigned not null default 1  comment '状态，1：可用，0：冻结',
   remark               varchar(200)  comment '备注',
   operate_ip           varchar(20) not null  comment '最后一次更新者的ip地址',
   operator             int unsigned not null  comment '操作者 id',
   created_at           datetime not null default CURRENT_TIMESTAMP  comment '创建时间',
   modified_at          datetime not null default CURRENT_TIMESTAMP  comment '最后一次更新时间',
   primary key (id)
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
   id                   int unsigned not null auto_increment  comment '用户 id',
   username             varchar(20) not null  comment '用户名称（登录名）',
   password             varchar(40) not null  comment '加密后的密码',
   password_salt        varchar(32) default '-1'  comment '用于加密用的“盐”',
   real_name            varchar(64)  comment '真实姓名',
   mobile_number        varchar(11) not null  comment '手机号',
   email                varchar(100) not null  comment '邮箱',
   dept_id              int unsigned not null default 0  comment '用户所在部门的id',
   status               tinyint unsigned not null default 1  comment '状态，1：正常，0：冻结状态，2：删除',
   remark               varchar(200)  comment '备注',
   operate_ip           varchar(20) not null  comment '最后一次更新者的ip地址',
   operator             int unsigned not null  comment '操作者 id',
   created_at           datetime not null default CURRENT_TIMESTAMP  comment '创建时间',
   modified_at          datetime not null default CURRENT_TIMESTAMP  comment '最后一次更新时间',
   primary key (id)
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
INSERT INTO `sys_user` (`id`, `username`, `real_name`, `mobile_number`, `email`, `password`, `password_salt`, `dept_id`, `status`, `remark`, `operate_ip`, `operator`, `created_at`, `modified_at`) VALUES
('1', 'administrator', '超级管理员', '13800138000', 'andy@lovesofttech.com', '123', '1', '1', '1', '请勿删除', '', '0', '2019-06-19', '2019-06-19');

-- 部门表
INSERT INTO `sys_dept` (`id`, `name`, `parent_id`, `level`, `sequence`, `status`, `remark`, `operate_ip`, `operator`, `created_at`, `modified_at`) VALUES
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
