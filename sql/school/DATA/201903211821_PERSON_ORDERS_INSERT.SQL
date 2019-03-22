prompt MYSQL Developer import file
prompt Created on 2019-03-21 by yangpeng
prompt Audited on 2019-03-21 by fengze

prompt 201903211821_PERSON_ORDERS_INSERT.SQL Start!

INSERT INTO Person (p_name, p_age, p_sex, p_address, p_tel , p_comment, create_time) VALUES ('阿里', 21, 1, '阿里地址', '15239288384' , '备注1', now());

INSERT INTO Orders (p_id, order_name, pay_way, order_price, order_describe , create_time) VALUES (1, '这是第一个订单', 0, 10.21, '订单描述1' , NOW());
INSERT INTO Orders (p_id, order_name, pay_way, order_price, order_describe , create_time) VALUES (1, '这是第二个订单', 1, 16.56, '订单描述2' , NOW());


prompt 201903211821_PERSON_ORDERS_INSERT.SQL End!