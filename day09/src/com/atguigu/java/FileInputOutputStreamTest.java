package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 *
 * 测试FileInputStream和FileOutputStram的使用
 * 结论:
 * 1. 对于文本文件(.txt, .java, .c, .cpp),使用字符流处理
 * 2. 对于非文本文件(.jpg, .mp3, .mp4, .avi, .doc, .ppt,...),使用字节流处理
 *
 * @Author lw
 * @Create2020-03-12 11:28
 */
public class FileInputOutputStreamTest {
    //使用字节流FileInputStream处理文本文件，可能出现乱码
    @Test
    public void testFileInputStream(){
        FileInputStream fr = null;
        try{
            //1.文件
            //2.操作对象
            fr = new FileInputStream("hello.txt");
            //3.操作
//            char[] cbuf = new char[5];
            byte[] cbuf = new byte[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            //关闭
            try {
                if(fr != null) fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 实现对图片的复制操作
     */
    @Test
    public void testFileInputOutputStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            File srcFile = new File("images.jpeg");
            File destFile = new File("images2.jpeg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer= new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0, len);
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(fis != null)fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null)fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
