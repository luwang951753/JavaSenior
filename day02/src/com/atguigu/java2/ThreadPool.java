package com.atguigu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * 创建线程的方式四:使用线程池
 *
 * 1.好处:提高响应速度(减少了创建新线程的时间)
 * 2.降低资消耗(重复利用线程池中线程，不需要每次都创建)
 * 3.便于线程管理
 *      corePoolSize: 核心池的大小
 *      maximumPoolSize: 最大线程数
 *      keepAliveTime: 线程没有任务时最多保持多长时间后终止
 *
 * 面试题: 创建线程有几种方式？ 四种！
 * 1.继承 Thread类
 * 2.实现Runnable 接口
 * 3.实现Callable 接口
 * 4.线程池(响应速度提高了,提高了资源的重用率,便于管理)
 *
 * @Author lw
 * @Create2020-03-09 12:45
 */

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();
        //设置线程池的属性
        System.out.println(service.getClass());

        //2.执行指定的线程的操作 需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());//适合适用于Runnable
        service.execute(new NumberThread1());//适合适用于Runnable
//        service.submit();//适合适用于Collable
        //3.关闭连接池
        service.shutdown();

    }
}
