package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一: 缓冲流的使用
 * BufferedFileInputStream
 * BufferedFileOutputStream
 * BufferedFileReader
 * BufferedFileWriter
 *
 * 2.作用: 提供流的读取、写入的速度
 *    提高读写速度的原因:内部提供了一个缓冲区
 *
 *
 * @Author lw
 * @Create2020-03-12 13:03
 */
public class BufferedTest {

    @Test
    public void BufferedStreamTest(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try{
            //造文件
            File srcFile = new File("images.jpeg");
            File destFile = new File("image3.jpeg");
            //造流
            //2.1 造字节流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //复制的细节: 读取、写入
            byte[] buffer = new byte[5];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
//                bos.flush(); //刷新缓冲区
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            //4.资源关闭
            //要求:先关闭外层的流，再关闭内层的流
            try {
                if(bos != null)bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bis != null)bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明:关闭外层流的同时,内层流也会自动的进行关闭. 关于内存流的关闭,我们可以省略
//            fos.close();
//            fis.close();
        }

    }
    //实现文件复制的方法
    public void copyFileWithBufferd(String srcPath, String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try{
            //造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //造流
            //2.1 造字节流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //复制的细节: 读取、写入
            byte[] buffer = new byte[5];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            //4.资源关闭
            //要求:先关闭外层的流，再关闭内层的流
            try {
                if(bos != null)bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bis != null)bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明:关闭外层流的同时,内层流也会自动的进行关闭. 关于内存流的关闭,我们可以省略
//            fos.close();
//            fis.close();
        }
    }


    /**
     * 使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello6.txt")));

            //读写操作
            //方式一:使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//            }

            //方式二: 使用String
            String data;
            while((data = br.readLine()) != null){
                //方式一:
//                bw.write(data+"\n");//data中不包含换行符
                //方式二:
                bw.write(data);
                bw.newLine();

            }


        }catch(IOException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
