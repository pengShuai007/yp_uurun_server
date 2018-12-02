package com.pengshuai.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YangPeng on 2018/11/29.
 * 统一异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    //可指定具体的异常类，也可不指定，会自动映射；
    // 一般会根据业务抛出异常不同，写多个异常处理类分别处理
    @ResponseBody
    private Map<String,Object> handleException(HttpServletRequest request,Exception e){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success","false");
        modelMap.put("message",e.getMessage());
        return modelMap;
    }
}
