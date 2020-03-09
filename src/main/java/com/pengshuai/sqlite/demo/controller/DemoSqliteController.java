package com.pengshuai.sqlite.demo.controller;

import com.pengshuai.sqlite.demo.service.DemoSqliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by YangPeng on 2019/6/6.
 */
@RequestMapping("/sqliteDemo")
@RestController
public class DemoSqliteController {

    @Autowired
    private DemoSqliteService demoSqliteService;

    @RequestMapping("/getList")
    public List<Map> getList(){
        List<Map> result = demoSqliteService.getList();
        return result;
    }
}
