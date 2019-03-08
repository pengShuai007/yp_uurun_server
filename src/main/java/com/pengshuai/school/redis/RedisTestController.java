package com.pengshuai.school.redis;

import com.pengshuai.utils.RedisByJedisUtil;
import com.pengshuai.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.*;
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

    @Autowired
    RedisByJedisUtil redisByJedisUtil;

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

    @RequestMapping("/testJedis")
    @ResponseBody
    public String testJedis(){
        redisByJedisUtil.set("yang","1",0);
        String value = redisByJedisUtil.get("yang",0);
        return value;
    }

    @RequestMapping("/syncAddRedisValue")
    public void syncAddRedisValue(){
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,20,200, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
        ExecutorService pool = Executors.newFixedThreadPool(100);
        for(int i = 0 ; i < 100; i++){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.currentThread().sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    redisByJedisUtil.incr("yang");
                    System.out.println(Thread.currentThread().getName() + "  执行结束!");
                }
            });
        }
        pool.shutdown();
    }
}