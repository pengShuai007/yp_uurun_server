package com.pengshuai.school.sync;

/**
 * Created by YangPeng on 2019/2/1.
 * 类锁 - 同步代码块形式
 * 类锁只能在同一时刻被一个对象拥有
 */
public class SyncClassCodeBlock implements Runnable {
    static SyncClassCodeBlock instance1 = new SyncClassCodeBlock();
    static SyncClassCodeBlock instance2 = new SyncClassCodeBlock();

    @Override
    public void run() {
        synchronized (SyncClassCodeBlock.class) {
            System.out.println("开始执行线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000); //线程睡眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完成！");
        }
    }

    public static void main(String args[]) {
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {

        }
        System.out.println("执行完成");
    }
}
