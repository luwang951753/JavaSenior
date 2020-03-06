package com.atguigu.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 其他常用类的使用
 * 1.System
 * 2.Math
 * 3.BigInteger 和 BigDecimal
 */
public class OtherClassTest {

    @Test
    public void test1(){
        String javaSersion = System.getProperty("java.version");
        System.out.println("java的version:"+javaSersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:"+javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("os的name:"+osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:"+osVersion);

        String userName = System.getProperty("user.name");
        System.out.println("user的name:"+userName);

        String userHome = System.getProperty("user.home");
        System.out.println("user的home:"+userHome);

        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:"+userDir);
    }

    @Test
    public void test2(){
        BigInteger bi = new BigInteger("124332411235732543700553928753753147329017432980174329847329108");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");

        System.out.println(bi);
        System.out.println(bd.divide(bd2,BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2,15,BigDecimal.ROUND_HALF_UP));

    }




}