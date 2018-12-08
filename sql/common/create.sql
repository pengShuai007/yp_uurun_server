create database uu_server;
CREATE TABLE IF NOT EXISTS hello (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR (50),
  usersex VARCHAR (2),
  userage INT (3),
  address VARCHAR (100),
  job VARCHAR (50)
) ENGINE = INNODB CHARSET = utf8 ;


create table if not exists sys_parameter (
  ID int primary key auto_increment,
  PARAM_CATEGORY varchar (2) comment '参数类别，0:文理跑腿业务',
  PARAM_NAME varchar (50) comment '参数名',
  PARAM_VALUE varchar (100) comment '参数值',
  SUBJECTS varchar (10) comment '主题:用于分组',
  COMMENTS VARCHAR (50) comment '备注',
  DESCRIPTION VARCHAR (50) comment '描述',
  CREATE_TIME timestamp not null default current_timestamp
) engine = innodb charset = utf8 comment '系统参数表' ;

create table if not exists sys_dict (
  ID int primary key auto_increment,
  DICT_CATEGORY varchar (10) default 0 comment '字典类别，0：文理跑腿业务；',
  DICT_CODE varchar (20) comment '字典编码',
  DICT_KEY varchar (20) comment 'key',
  DICT_VALUE varchar (50) comment '值',
  PARENT_KEY varchar (20) comment '父级key',
  CREATE_TIME TIMESTAMP not null default current_timestamp
) engine = innodb charset = utf8 comment '系统字典表' ;

create table if not exists drun_orders (
  ORDER_ID int primary key auto_increment,
  USER_KEY varchar (30) not null,
  ORDER_CONTENT varchar (50) comment '订单内容',
  ORDER_TYPE varchar (20) comment '订单类型，字典编码：01',
  ORDER_COST decimal (10, 2) comment '订单总金额',
  AMOUNT decimal (10, 2) comment '订单商品金额',
  COMMISSION decimal (10, 2) comment '订单佣金',
  SERVICE_CHARGE decimal (10, 2) comment '平台服务费',
  ORDER_POSITION varchar (50) comment '订单位置',
  TELPHONE varchar (20) comment '联系电话',
  ORDER_STATUS varchar (2) not null default '0' comment '订单状态；-1：取消；0：初始化；1：已付款待接单；2：已接单；3：待确认；4：完成',
  CREATE_TMIME datetime not null,
  UPDATE_TIME datetime not null
) engine = innodb charset = utf8 comment '订单表' ;

create table if not exists drun_users (
  ID int primary key auto_increment,
  USER_KEY varchar (30) not null comment '用户微信号',
  PHONE varchar (20) not null comment '电话',
  ADDRESS varchar (100) comment '地址',
  ACCOUNT varchar (20) COMMENT '收/付款账号',
  CREATE_TIME datetime not null,
  UPDATE_TIME datetime not null
) engine = innodb charset = utf8 comment '用户表' ;

create table if not exists drun_accept_orders
(
   ID                   int                          primary key auto_increment,
   USER_KEY             varchar(30)                   not null comment '接单人key',
   ORDER_ID             varchar(10)                    comment '订单ID',
   TEL_PHONE            varchar(20)                    comment '接单人电话',
   IS_CANCEL            char(10)                      not null default '0' comment '是否取消接单；0：未取消；1：取消',
   START_TIME           datetime                     not  null comment '接单时间',
   END_TIEM             datetime                       null comment '订单完成时间'
)ENGINE = INNODB CHARSET = utf8 COMMENT '接单表';

create table if not exists drun_settlement_mid
(
   ID                   int                         primary key auto_increment,
   ORDER_ID             varchar(10)                   not null comment '订单ID',
   COST                 decimal(9,2)                   comment '结算金额',
   C_ACCOUNT            varchar(20)                   NOT null comment '收款账号',
   PAY_ACCOUNT          varchar(20)                  NOT  null comment '付款账号',
   IS_CANCEL            varchar(2)                    NOT null default '0' comment '取消结算；0：未取消；1：取消',
   CREATE_TIME          datetime                   not    null,
   UPDATE_TIME          datetime                  not     null
) engine = innodb charset = utf8 comment '结算中间表' ;

create table if not exists drun_settlement (
  ID int primary key auto_increment,
  ORDER_ID varchar (10) not null comment '订单ID',
  COST decimal (9, 2) not null comment '支付金额',
  C_ACCOUNT varchar (20) not null comment '收款账号',
  PAY_ACCOUNT varchar (20) not null comment '付款账号',
  CREATE_TIME datetime not null,
  UPDATE_TIME datetime not null
) engine = innodb charset = utf8 comment '结算表' ;