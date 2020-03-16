package com.atguigu.java3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 * @Author lw
 * @Create2020-03-15 20:30
 */
public class StreamAPITest1 {
    //1.筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
        //filter(Predicate p) --接收lambda，从流中排除某些元素
        Stream<Employee> stream = list.stream();
        //练习:查询员工表中薪资大于8000的员工信息
        stream.filter(e->e.getSalary()>8000).forEach(System.out::println);
        System.out.println("*************");
        //limit(n) --截断流,使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);
        //skip(n) --跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个
        System.out.println("*************");
        list.stream().skip(3).forEach(System.out::println);
        //distinct() --筛    选，通过流所生成元素的hashCode()和equals(0去除重复元素
        System.out.println("*************");
        list.stream().distinct().forEach(System.out::println);


    }

    //映射
    @Test
    public void test2(){
        //map(Function f) --接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素
        List<String> list1 = Arrays.asList("aa", "bb", "cc", "dd");
        list1.stream().map(str->str.toUpperCase()).forEach(System.out::println);
        //练习1：获取员工姓名长度大于3的员工的姓名
        List<Employee> list = EmployeeData.getEmployees();
        Stream<String> stringStream = list.stream().map(Employee::getName);
        stringStream.filter(name->name.length() > 3).forEach(System.out::println);

        //练习2:
        //flatMap(Function f) --接收一个函数作为参数，将流中的生个值都转换成另一个流，然后把所有流连接成一个流

    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public Stream<Character> fromStringToStream(String str){//aa
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3(){
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

//        list1.add(list2);
        list1.addAll(list2);
        System.out.println(list1);


    }

    //3.排序
    @Test
    public void test4(){
        //sorted() --自然排序
//        List<Integer> list = Arrays.asList(32,21,54,23,45);
//        list.stream().sorted().forEach(System.out::println);
        //抛异常，原因:employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com) --定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2)->{
//            return Integer.compare(e1.getAge(),e2.getAge());
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if(ageValue != 0){
                return ageValue;
            }else{
                return Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);
    }

}
