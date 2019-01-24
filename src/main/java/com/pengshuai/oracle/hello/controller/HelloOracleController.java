package com.pengshuai.oracle.hello.controller;

import com.pengshuai.oracle.hello.service.HelloOracleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YangPeng on 2019/1/23.
 */
@RequestMapping("/oracle")
@RestController
public class HelloOracleController {
    @Autowired
    private HelloOracleService helloOracleService;

    @RequestMapping("/list")
    public Map<String,Object> listOracle(){
        Map map = new HashMap();
        List<Map> listMap = helloOracleService.listOracle();
        map.put("data",listMap);
        return map;
    }

    @RequestMapping("/update")
    public String updateHello(int id,String name){
        String result = "";
        int num = helloOracleService.updateHello(id,name);
        result = "本次更新数据" + num + "条!";
        return result;
    }
}
