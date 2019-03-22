prompt MYSQL Developer import file
prompt Created on 2019-03-21 by yangpeng
prompt Audited on 2019-03-21 by fengze

prompt 201903211811_PERSON_CREATE.SQL Start!

CREATE TABLE IF NOT EXISTS Person (
  id INT PRIMARY KEY AUTO_INCREMENT,
  p_name VARCHAR (20) COMMENT '姓名',
  p_age INT,
  p_sex INT COMMENT '0:男；1:女',
  p_address VARCHAR (100) COMMENT '地址',
  p_tel VARCHAR (11) COMMENT '手机号',
  p_comment VARCHAR (100) COMMENT '备注',
  create_time DATETIME COMMENT '创建时间'
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '用户表' ;


CREATE TABLE IF NOT EXISTS Orders (
  id INT PRIMARY KEY AUTO_INCREMENT,
  p_id INT COMMENT '用户ID',
  order_name VARCHAR (100) COMMENT '订单名称',
  pay_way INT COMMENT '支付方式，0：现金1：支付宝2：微信',
  order_price DECIMAL (10, 2) COMMENT '订单金额',
  order_describe VARCHAR (100) COMMENT '订单描述',
  create_time DATETIME COMMENT '创建时间'
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '订单表' ;

prompt 201903211811_PERSON_CREATE.SQL End!