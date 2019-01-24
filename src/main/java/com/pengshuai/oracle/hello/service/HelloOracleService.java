package com.pengshuai.oracle.hello.service;

import java.util.List;
import java.util.Map;

/**
 * Created by YangPeng on 2019/1/23.
 */
public interface HelloOracleService {

    List<Map> listOracle();

    int updateHello(int id,String name);
}
