package com.atguigu.java;

import org.junit.Test;

import java.util.Random;

/**
 * 体会反射的动态性
 * @Author lw
 * @Create2020-03-14 18:47
 */
public class NewInstanceTest {
    @Test
    public void test2() {
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch(num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.atguigu.java.Person";
                    break;
            }

            Object obj = null;
            try {
                obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 创建一个指定类的对象
     * @return
     */
    public Object getInstance(String classPath) throws Exception{
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}


