package com.pengshuai.school.sync;

/**
 * Created by YangPeng on 2019/2/1.
 * 类锁 - 在静态方法添加synchronized关键字
 * method 方法必须为静态的，否则不同的类对象启动线程是不能同步的
 */
public class SyncClassStaticMethod implements Runnable {
    static SyncClassStaticMethod instance1 = new SyncClassStaticMethod();
    static SyncClassStaticMethod instance2 = new SyncClassStaticMethod();

    @Override
    public void run() {
        method();
    }
    public static synchronized void method(){
        System.out.println("开始执行线程：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000); //线程睡眠3秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完成！");
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
