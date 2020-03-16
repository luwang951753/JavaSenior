package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 实现TCP的网络编程
 * @Author lw
 * @Create2020-03-14 13:45
 */
public class TCPTest3 {
    @Test
    public void client() throws IOException {

        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;

            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("images.jpeg"));
            byte[] bytes = new byte[5];
            int len;
            while((len =fis.read(bytes)) != -1){
                os.write(bytes,0,len);
            }
            //关闭数据的输出
            socket.shutdownOutput();

            //接收来自于服务器端的数据，并显示在控制台上
            InputStream is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[20];
            int len2;
            while((len2 = is.read(buffer)) != -1){
                baos.write(buffer,0,len2);
            }
            System.out.println(baos.toString());

            baos.close();
            fis.close();
            os.close();
            socket.close();


    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("images2.jpeg"));
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        //服务器端给予客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好，美女，照片我己收到，非常漂亮！".getBytes());


        fos.close();
        is.close();
        ss.close();
        os.close();
    }
}
