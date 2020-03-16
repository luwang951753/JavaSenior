package com.atguigu.java;

import org.junit.Test;

/**
 * 了解类的加载器
 * @Author lw
 * @Create2020-03-14 18:18
 */
public class ClassLoaderTest {

    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent() 获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        //调用扩展类加载器的getParent() 无法获取引导类加载器
        //引导类加载器，主要负责加载java的核心类库，无法加载自定义类
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

    }
}
