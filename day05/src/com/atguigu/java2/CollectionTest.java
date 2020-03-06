package com.atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 一. 集合框架的概述
 *
 * 1.集合、数组都是对多个数组进行存储操作的结构，简称Java容器
 *  说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储(.txt,.jpg,.avi,数据库中)
 *
 * 2.1 数组在存储多个数据方面的特点:
 *      > 一旦初始化以后，其长度就确定了
 *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了
 *        比如：String[] arr; int[] arr1; Object[] arr2;
 *
 * 2.2 数组在存储多个数据方面的缺点:
 *     > 一旦初始化以后，其长度就不可修改
 *     > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高
 *     > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *     > 数组存储数据的特点:有序、可重复、对于无序、不可重复的需求，不能满足
 *二、集合框架
 *      |----Collection接口:单列集合，用来存储一个一个的对象
 *         |----List接口：存储有序的、可重复的数据
 *            |----ArrayList:作为List接口的主要实现类:线程不安全的，效率高；底层使用Object[]存储
 *            |----LinkedList:对于频繁的插入、删除操作，使用此类效率比ArrayList高; 底层使用双向链表存储
 *            |----Vector:作为List接口的古老实现类:线程安全的，效率低
 *         |----Set接口：存储无序的、不可重复的数据
 *            |----HashSet、LinkedHashSet、TreeSet
 *         |----Map接口：双列集合，用来存储一对(key - value)一对的数据
 *            |----HashMap、LinkedHashMap、TreeMap、HashTable、Properties
 *
 * 2ArrayList的源码分析:
 * 2.1jdk7情况下
 * ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementData
 * list.add(123);//elementData[0] = new Integer(123);
 * ...
 * list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容
 * 默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中
 * 结论：建议开发中使用带参的构造器:ArrayList list = new ArrayList(int capacity)
 *
 *2.2 jdk8中ArrayList的变化:
 *ArrayList list = new ArrayList();//底层Object[] elemenetData初始化为{}
 * list.add(123);//第一次使用add()时，底层才创建了长度10的数组，并将数据123添加到elemnt[0]
 * ...
 * 后续的添加和扩容操作与jdk7无异
 *2.3小结:jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象
 * 的创建类型于单例的懒汉式，延迟了数组的创建，节省内存
 *
 * 3.LinkedList的源码分析:
 *LinkedList list = new LinkedList();内部声明了Node类型的first和last属性，默认值为null
 * list.add(123);//将123封装到Node中，创建了Node对象
 * 其中,Node定义为:体现了LinkedList的双向链表的说法
 *
 *
 * 面试题:ArrayList、LinkedList、Vector
 *见上
 *
 * 三、Collection接口中的方法的使用
 *
 * 总结:常用方法
 * 增：add(Object obj)
 * 删：remove(int index) /remove(Object obj)
 * 改：set(int index,Object ele)
 * 查：get(int index)
 * 插：add(int index, Object ele)
 * 长度：size()
 * 遍历:Iterator迭代器方式、增强for循环、普通的循环
 *
 *
 */

public class CollectionTest {
    @Test
    public void test1(){

        Collection coll = new ArrayList();

        //add(Object e):将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());

        //size():获取添加的元素的个数
        System.out.println(coll.size());

        //addAll(Collection coll1):将coll1集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size());
        System.out.println(coll);

        //clear():清空集合元素
        coll.clear();

        //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());


    }
}
