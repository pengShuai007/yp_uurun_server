package com.pengshuai.school.redis;

import com.pengshuai.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * @ClassName: RedisTestController
 * @Auther: zhangyingqi
 * @Date: 2018/8/28 17:24
 * @Description:
 */
@Controller
@RequestMapping("/redis")
public class RedisTestController{

    @Autowired
    RedisUtil redisUtil;

    private static final Logger logger = Logger.getLogger("RedisTestController");

    @RequestMapping(value="/test")
    @ResponseBody
    public String test(){
        try {
            redisUtil.set("redisTemplate","这是一条测试数据", 2);
            String value = redisUtil.get("redisTemplate",2).toString();
            logger.info("redisValue="+value);
            logger.info("读取redis成功");
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

}