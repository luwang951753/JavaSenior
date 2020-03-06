package com.atguigu.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) throws IOException {

        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis); //加载流对应的文件

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name="+name+",password="+password);

        fis.close();
    }
}
