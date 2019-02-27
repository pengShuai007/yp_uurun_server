package com.pengshuai.school.sync;

/**
 * Created by YangPeng on 2019/2/1.
 * 对象锁 - 普通方法锁形式
 */
public class SyncObjectMethod implements Runnable{
    static SyncObjectMethod instance = new SyncObjectMethod();
    @Override
    public void run() {
        method();
    }

    public synchronized void method() {
        System.out.println("开始执行线程：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000); //线程睡眠3秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完成！");
    }

    public static void main(String args[]){
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()){

        }
        System.out.println("执行完成");
    }
}
