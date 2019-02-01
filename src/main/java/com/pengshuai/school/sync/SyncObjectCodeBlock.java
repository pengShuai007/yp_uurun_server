package com.pengshuai.school.sync;

/**
 * Created by YangPeng on 2019/2/1.
 * 对象锁-同步代码块形式
 * 定义lock1和lock2，synchronized分别锁住这两个不同的对象，
 * 则两块代码可以异步执行，但每一块又是同步执行
 */
public class SyncObjectCodeBlock implements Runnable{
    static SyncObjectCodeBlock instance = new SyncObjectCodeBlock();
    Object lock1 = new Object();  //充当锁对象
    Object lock2 = new Object();
    @Override
    public void run() {
        synchronized (lock1){
            System.out.println("lock1开始执行线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000); //线程睡眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock1 " + Thread.currentThread().getName() + "执行完成！");
        }
        synchronized (lock2){
            System.out.println("lock2开始执行线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000); //线程睡眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock2 " + Thread.currentThread().getName() + "执行完成！");
        }
    }

    public static void main(String[] args){
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        try {
            //等待t1、t2执行完成
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("执行结束");
    }
}
