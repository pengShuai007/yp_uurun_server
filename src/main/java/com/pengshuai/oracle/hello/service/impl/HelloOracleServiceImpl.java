package com.pengshuai.oracle.hello.service.impl;

import com.pengshuai.oracle.hello.dao.HelloOracleDao;
import com.pengshuai.oracle.hello.service.HelloOracleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by YangPeng on 2019/1/23.
 */
@Service

public class HelloOracleServiceImpl implements HelloOracleService {

    @Autowired
    private HelloOracleDao helloOracleDao;

    @Override
    @Transactional(value = "localOracle")
    public List<Map> listOracle() {
        return helloOracleDao.listHello();
    }

    @Override
    public int updateHello(int id, String name) {
        return helloOracleDao.updateHello(id,name);
    }

}
