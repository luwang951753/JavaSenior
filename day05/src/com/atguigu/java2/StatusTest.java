package com.atguigu.java2;

/**
 * @Author lw
 * @Create2020-03-11 15:50
 */
public class StatusTest {
    public static void main(String[] args) {
        System.out.println(Status.BUSY);
    }
}

enum Status{
    FREE,BUSY,VOCATION;
}
