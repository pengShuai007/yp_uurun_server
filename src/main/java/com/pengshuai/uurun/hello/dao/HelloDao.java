package com.pengshuai.uurun.hello.dao;

import com.pengshuai.uurun.hello.entity.HelloEntity;
import com.pengshuai.uurun.hello.entity.Orders;
import com.pengshuai.uurun.hello.entity.Person;

import java.util.List;

/**
 * Created by YangPeng on 2018/11/27.
 */

public interface HelloDao {
    List<HelloEntity> queryHello();

    HelloEntity queryHelloById(int id);

    int insertHello(HelloEntity hello);

    int updateHello(HelloEntity hello);

    int deleteHello(int id);

    List<Person> selectPersons();

    List<Orders> selectOrders();
}
