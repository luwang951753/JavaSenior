package com.atguigu.java;

import com.sun.tools.corba.se.idl.constExpr.Or;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest1 {

    @Test
    public void test1(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求:如果定义了类是带泛型的，建议在实例化时指明类的泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        //建议:实例化时指明类的泛型
        Order<String> order1 = new Order<>("orderAA", 1001, "Testtesttet");

        order1.setOrderT("AA:hello");

    }

    @Test
    public void test2(){
        SubOrder sub1 = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象，不再需要指明泛型
        sub1.setOrderT(1122);

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("order2...");
    }

    @Test
    public void test3(){
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
        //泛型不同的引用不能相互赋值
//        list1 = list2;

        Person p1 = null;
        Person p2 = null;

        p1 = p2;
    }

    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = {1, 2, 3, 4};
        List<Integer> list = order.comFromArrayToList(arr);
        System.out.println(list);
    }

}
