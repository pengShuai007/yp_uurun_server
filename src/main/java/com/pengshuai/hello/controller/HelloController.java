package com.pengshuai.hello.controller;

import com.pengshuai.hello.entity.HelloEntity;
import com.pengshuai.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YangPeng on 2018/11/27.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/sayHello")
    public String hello(){
        return "hello,my first spring boot project";
    }

    @RequestMapping(value = "listHello", method = RequestMethod.GET)
    public Map<String,Object> listHello(){
        Map map = new HashMap();
        List<HelloEntity> helloEntityList = helloService.queryHello();
        map.put("helloList",helloEntityList);
        return map;
    }

    @RequestMapping(value = "listHelloById", method = RequestMethod.GET)
    public Map<String,Object> listHelloById(int id){
        Map map = new HashMap();
        HelloEntity helloEntity = helloService.queryHelloById(id);
        map.put("hello",helloEntity);
        return map;
    }

    @RequestMapping(value = "insertHello", method = RequestMethod.POST)
    public Map<String,Object> insertHello(@RequestBody HelloEntity helloEntity){
        Map map = new HashMap();
        boolean result = helloService.insertHello(helloEntity);
        map.put("success",result);
        return map;
    }

    @RequestMapping(value = "updateHello", method = RequestMethod.POST)
    public Map<String,Object> updateHello(@RequestBody HelloEntity helloEntity){
        Map map = new HashMap();
        boolean result = helloService.updateHello(helloEntity);
        map.put("success",result);
        return map;
    }

    @RequestMapping(value = "deleteHello", method = RequestMethod.GET)
    public Map<String,Object> deleteHello(Integer id){
        Map map = new HashMap();
        boolean result = helloService.deleteHello(id);
        map.put("success",result);
        return map;
    }
}
