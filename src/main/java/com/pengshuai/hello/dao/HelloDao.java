package com.pengshuai.hello.dao;

import com.pengshuai.hello.entity.HelloEntity;

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
}
