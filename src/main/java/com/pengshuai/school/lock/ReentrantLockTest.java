package com.pengshuai.school.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YangPeng on 2020/1/9.
 * ReentrantLock 构造函数入参传入true，则创建公平锁,
 * 传入false则创建非公平锁，默认为公平锁（不传参的情况下）
 */
public class ReentrantLockTest extends Thread{
    ReentrantLock lock = new ReentrantLock(false);
    public void fairLock(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "持有锁");
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            lock.unlock();
        }
    }

    public static void main(String args[]){
        ReentrantLockTest test = new ReentrantLockTest();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "启动");
                test.fairLock();
           }
        };
        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10 ; i++){
            threads[i] = new Thread(runnable);
        }
        for(int i = 0; i < 10 ; i++){
            threads[i].start();
        }
    }
}
