package com.atguigu.java;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 其他流的使用
 * 1.标准的输入、输出流
 * 2.打印流
 * 3.数据流
 *
 *
 * @Author lw
 * @Create2020-03-12 16:34
 */
public class OtherStreamTest {

    /**
     * 1.标准的输入、输出流
     * 1.1
     * System.in:标准的输入流，默认从键盘输入
     * System.out:标准的输出流，默认从控制台输出
     * 1.2
     * System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出的
     *
     * 1.3练习:
     * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作，
     * 直至当输入"e"或者"exit"时，退出程序
     *
     * 方式一: 使用scanner实现，调用next()返回一个字符串
     * 方式二: 使用System.in实现. System.in ---> 转换流 --> BufferedReader的readLine
     */
//    @Test
//    public void test() throws IOException {
//
//
//
//
//    }
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while(true){
            System.out.println("请输入字符串:");
            String data = br.readLine();
            if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                System.out.println("程序结束");
                break;
            }
            String upperCase = data.toUpperCase();
            System.out.println(upperCase);
        }
    }
}
