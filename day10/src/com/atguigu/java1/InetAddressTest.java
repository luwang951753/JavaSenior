package com.atguigu.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.net.InetAddress.getByName;

/**
 *
 * 一.网络编程中有两个主要的问题:
 * 1.如何准确地定位网络上一台或多台主机:定位主机上的特定的应用
 * 2.找到主机后，如何可靠高效地进行数据传输
 *
 * 二.网络编程中的两个要素:
 * 1.对应问题一:IP和端口号
 * 2.对应问题二:提供网络通信协议:TCP/IP参考模型(应用层、传输层、物理+数据链路)
 *
 * 三.通信要素一:IP和端口号
 * 1.IP:唯一的标识Internet上的计算机(通信实体)
 * 2.在Java中使用InetAddress类代表IP
 * 3.IP分类:IPv4和IPv6; 万维网和局域网
 * 4.域名: www.google.com
 * 5.本地回路 127.0.0.1 localhost
 * 6.如何实例化InetAddress:两个方法:getByName(String host),getLocalHost
 *          两个常用方法: getHostName() / getHostAddress()
 * @Author lw
 * @Create2020-03-14 11:30
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet2 = InetAddress.getByName("www.google.com");
            System.out.println(inet2);
            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);
        } catch (UnknownHostException e) {
            e.printStackTrace();

        }

    }
}
