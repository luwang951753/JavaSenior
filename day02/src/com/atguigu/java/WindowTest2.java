package com.atguigu.java;

/**
 * @Author lw
 * @Create2020-03-08 13:17
 */
/**
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 * 例子:创建三个窗口卖标，总票数为100张，使用继承Thread类的方式
 *
 * 说明: 在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 *
 */
class window2 extends Thread{
    private static int ticket =100;
    static Object obj = new Object();
    @Override
    public void run() {
        while(true){
            //正确的
//            synchronized (obj) {
            synchronized (window2.class) { //Class clazz = window2.class 只会加载一次
              //错误的方式: this代表着t1,t2,t3三个对象
//            synchronized (this) {

                if (ticket > 0) {

                    try {
                        Thread.sleep(500);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ":卖票，票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }

        }
    }
}

public class WindowTest2{

    public static void main(String[] args) {
        window2 t1 = new window2();
        window2 t2 = new window2();
        window2 t3 = new window2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}


