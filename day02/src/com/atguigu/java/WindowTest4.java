package com.atguigu.java;

/**
 *
 *
 *
 * @Author lw
 * @Create2020-03-08 15:43
 */
class window4 extends Thread{
    private static int ticket =100;

    @Override
    public void run() {
        while(true){
            show();
        }
    }
    private static synchronized void show(){//同步监视器:Window4.class
//    private synchronized void show(){//同步监视器:t1,t2,t3,此种解决方式是错误的
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":卖票，票号为:" + ticket);
            ticket--;
        }
    }
}

public class WindowTest4{

    public static void main(String[] args) {
        window4 t1 = new window4();
        window4 t2 = new window4();
        window4 t3 = new window4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
