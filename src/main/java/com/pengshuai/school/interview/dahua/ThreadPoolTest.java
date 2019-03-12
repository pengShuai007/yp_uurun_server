package com.pengshuai.school.interview.dahua;

import java.util.concurrent.*;

/**
 * 判断线程池中的线程是否已经执行完毕
 * Created by YangPeng on 2019/3/12.
 */
public class ThreadPoolTest {

    public static void main(String[] args){
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        threadPoolTest.methodThree();
    }

    public void methodOne(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        final long start = System.currentTimeMillis();
        for(int i = 0;i < 100 ;i++ ){
            final int num = i;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.submit(task);
        }
        executorService.shutdown();
        System.out.println("所有线程均已开始执行！");
        while (true){
            if(executorService.isTerminated()){
                System.out.println("所有线程执行结束！");
                break;
            }
        }
        final long end = System.currentTimeMillis();
        System.out.println("共耗时" + (end-start)/1000 + "s");
    }

    /**
     * 这种写法可能存在效率问题
     */
    public void methodTwo(){
        final long start = System.currentTimeMillis();
        final int nThread = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(nThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < nThread;i++){
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                    }
                }
            };
            executorService.submit(task);
        }
        executorService.shutdown();
        System.out.println("所有线程均已开始执行！");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final long end = System.currentTimeMillis();
        System.out.println("所有线程执行完毕，共耗时" + (end-start)/1000 + "s");
    }

    /**
     * 执行时间与Semaphore值有关，值越大，执行越快
     * Semaphore 也可以不用，Semaphore作用：
     * semaphore一般用来限制访问资源的线程数量
     */
    public void methodThree(){
        final Semaphore semaphore = new Semaphore(100);
        final long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 1000;i++){
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName());
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.submit(task);
        }
        executorService.shutdown();
        System.out.println("所有线程均已开始执行！");
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final long end = System.currentTimeMillis();
        System.out.println("所有线程执行完毕，共耗时" + (end-start)/1000 + "s");
    }
}
