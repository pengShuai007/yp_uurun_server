package com.pengshuai.sqlite.demo.service;

import com.pengshuai.sqlite.demo.dao.DemoSqliteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by YangPeng on 2019/6/6.
 */
@Service
public class DemoSqliteService {
    @Autowired
    private DemoSqliteDao demoSqliteDao;

    public List<Map> getList(){
        List<Map> result = demoSqliteDao.getList();
        return result;
    }
}
