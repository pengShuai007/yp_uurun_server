package com.pengshuai.uurun.hello.service;

import com.pengshuai.uurun.hello.entity.HelloEntity;
import com.pengshuai.uurun.hello.entity.Orders;
import com.pengshuai.uurun.hello.entity.Person;

import java.util.List;

/**
 * Created by YangPeng on 2018/11/28.
 */
public interface HelloService {

    List<HelloEntity> queryHello();

    HelloEntity queryHelloById(int id);

    boolean insertHello(HelloEntity hello);

    boolean updateHello(HelloEntity hello);

    boolean deleteHello(int id);

    List<Person> selectPersons();

    List<Orders> selectOrders();
}
