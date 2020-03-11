package com.atguigu.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @Author lw
 * @Create2020-03-10 11:34
 */
public class StringTest1 {

    /**
     * String 与byte[]之间的转换
     * 编码:String --> byte[]:调用String的getBytes()
     * 解码:byte[] --> String:调用String的构造器
     *
     * 编码: 字符串 --> 字节
     * 转码: 字节 --> 字符串
     *
     * 说明:解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码
     */
    @Test
    public void tes3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");//使用gbk进行编码
        System.out.println(Arrays.toString(gbks));

        System.out.println("********************");
        String str2 = new String(bytes);
        System.out.println(str2);

        String str3 = new String(gbks);
        System.out.println(str3);//出现乱码，原因:编码集和解码集不一致

        String str4 = new String(gbks,"gbk");
        System.out.println(str4);
    }

    /**
     * String 与 char[] 之间的转换
     * String --> char[]:调用String的toCharArray()
     * char[] --> String:调用String的构造器
     */
    @Test
    public void test2(){
        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        for (char c : charArray) {
            System.out.println(c);
        }

        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr);
        System.out.println(str2);

    }

    /**
     * 复习:
     * String 与基本数据类型、包装类之间的转换
     * String --> 基本数据类型、包装类: 调用包装类的静态方法: parseXxx(str)
     * 基本数据类型、包装类 --> String: 调用String重载的valueOf(xxx)
     */
    @Test
    public void test1(){
        String str1 = "123";
//        int num = (int)str1; //错误的
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);
        String str3 = num+"";
        System.out.println(str1 == str3);
    }

}
