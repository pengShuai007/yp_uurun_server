package com.pengshuai.school.redis;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * Created by YangPeng on 2019/3/12.
 * redis实现分布式锁
 * 未考虑redis主从情况，如果redis为主从配置，则需要使用redLock策略，目前暂未使用
 */
public class DistributedLockByRedis {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 尝试获取分布式锁
     * @param jedis redis客户端
     * @param lockKey  锁
     * @param requestId 客户端ID（请求标识）可以使用UUID生成
     * @param expireTime 超时时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis,String lockKey,String requestId,int expireTime){
        //nx是指不存在时插入key值；px指过期时间单位为毫秒，ex是秒，默认为秒
        String result = jedis.set(lockKey,requestId,SET_IF_NOT_EXIST,SET_WITH_EXPIRE_TIME,expireTime);
        if(LOCK_SUCCESS.equals(result)){
            return true;
        }
        return false;
    }

    /**
     *
     * @param jedis redis客户端
     * @param lockKey 锁
     * @param requestId 客户端ID
     * @return
     */
    public static boolean releaseDistributedLock(Jedis jedis,String lockKey,String requestId){
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey),Collections.singletonList(requestId));
        if(RELEASE_SUCCESS.equals(result)){
            return true;
        }
        return false;
    }
}
