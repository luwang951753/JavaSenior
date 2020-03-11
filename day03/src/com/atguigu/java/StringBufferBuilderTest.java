package com.atguigu.java;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 *
 * @Author lw
 * @Create2020-03-10 13:16
 */
public class StringBufferBuilderTest {




    /**
     *
     * StringBuffer的常用方法:
     * StringBuffer append(xxxx): 提供了很多的append()方法，用于进行字符串拼接
     * StringBuffer delete(int string, int end): 删除指定位置的内容
     * StringBuffer replace(int start, int end, String str): 把[start,end]位置替换为str
     * StringBuffer insert(int offset,xxx):在指定位置插入xxx
     * StringBuffer reverse(): 把当前字符序列逆转
     * public int indexOf(String str)
     * public String substring(int start, int end)
     * public int length()
     * public char charAt(int n)
     * public void setharAt(int n, char ch)
     *
     * 总结:
     * 增 append
     * 删 delete
     * 改 setCharAt replace
     * 查charAt
     * 长度 length
     * 遍历 for + chat() / toString
     */

    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);
        s1.delete(2,4);
        System.out.println(s1);
        s1.replace(2,4,"ssss");
    }

    /**
     * String、StringBuffer、StringBuilder三者的异同?
     * String: 不可变的字符序列 底层使用char[]存储
     * StringBuffer: 可变的字符序列: 线程安全的，效率低; 底层使用char[]存储
     * StringBuilder: 可变的字符序列; jdk5.0新增的，线程不安全的,效率高; 底层使用char[]存储
     *
     * 源码分析:
     * String str = new String();//char[] value = new char[0];
     * String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};
     *
     * StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建了一个长度
     * sb1.append('a');//value[0]='a';
     * sb1.append('b');//value[1]='b';
     *
     * StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length()+16]
     *
     * //问题1. System.out.println(sb2.Length());//3
     * //问题2. 扩容问题:如果要添加的数据底层数组盛不下了,那就需要扩容底层的数组.
     *          默认情况下，扩容为原来容量的2倍+2，同时将原有数组中的元素复制到新的数组中
     *
     *
     *          指导意义:开发中建议大家使用:StringBuffer
     *
     *
     */

    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);
    }

}
