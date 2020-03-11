package com.atguigu.java1;

/**
 * 注解的使用
 *
 * 1.理解Annotation
 *  1)jdk5.0新增的功能
 *  2)Annotation 其实就是代码里的特殊标记
 *
 * 2.Annotation的使用示例
 * @override: 限定重写父类方法，该注解只能用于方法
 * @Deprecated: 用于表示所修饰的元素(类、方法等己过时
 * @SuppressWarnings:抑制编译器警告
 *
 * 3.如何自定义注解: 参照@SuppressWarnings
 *
 *
 * 4.jdk中的4种元注解
 *
 * @Author lw
 * @Create2020-03-11 16:00
 */
public class AnnotationTest {

    public static void main(String[] args) {

        int num =10;


    }

}
@MyAnnotation(value="hello")
class Person{

}
