package com.pengshuai.school.sync;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 不使用锁，实现一个线程安全的单例
 * Created by YangPeng on 2019/3/11.
 */
public class SingletonWithoutLock {
    private static final AtomicReference<SingletonWithoutLock> instance = new AtomicReference<SingletonWithoutLock>();

    private SingletonWithoutLock(){}

    public static SingletonWithoutLock getSingleton(){
        for(;;){
            SingletonWithoutLock singleton = instance.get();
            if(null != singleton){
                return singleton;
            }
            singleton = new SingletonWithoutLock();
            if(instance.compareAndSet(null,singleton)){
                return singleton;
            }
        }
    }
}
