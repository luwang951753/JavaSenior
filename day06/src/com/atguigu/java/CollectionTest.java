package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法的测试
 *
 * 结论:
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()
 *
 */
public class CollectionTest {

    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //1.contains(Object obj):判断当前集合中是否包含obj
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(new Person("Jerry",20)));//false -->true 需要在Person重写equals方法

        //2.containsAll(Collection coll1):判断形参coll1中所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll1));

    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //remove(Object obj):从当前集合中移除obj元素
        coll.remove(123);
        System.out.println(coll);

        coll.remove(new Person("Jerry",20));
        System.out.println(coll);

        //4.removeAll(Collection coll):差集：从当前集合中移除coll1中所有的元素
        List<Integer> coll1 = Arrays.asList(123, 456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
//        List<Integer> coll1 = Arrays.asList(123, 456, 789);
//        coll.retainAll(coll1);
//        System.out.println(coll1);

        //6.equals(Object obj):要想返回true,需要当前集合和形参集合的元素相同
        ArrayList coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("Tom"));
        coll1.add(false);
        coll1.add(new Person("Jerry",20));

        System.out.println(coll.equals(coll1));

    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合 -->数组: toArray
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //拓展: 数组-->集合: 调用Arrays类的
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List<int[]> arr1 = Arrays.asList(new int[]{123, 456});//注意
        List<Integer> arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr1);
        System.out.println(arr2);

        //9.iterator():返回Iterator接口的实例，用于遍历集合元素，放在IteratorTest.java中
    }
}
