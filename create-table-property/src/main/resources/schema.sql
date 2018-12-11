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
