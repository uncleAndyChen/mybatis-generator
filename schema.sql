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
