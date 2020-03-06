package com.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class EmployeeTest {

    public void test2(){
        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return 0;
            }
        }

        );

    }

    @Test
    public void test(){
        TreeSet<Employee> set = new TreeSet<Employee>();

        Employee e1 = new Employee("liudehua", 55);
        Employee e2 = new Employee("zhangxueyou", 43);
        Employee e3 = new Employee("guofucheng", 44);
        Employee e4 = new Employee("liming", 51);
        Employee e5 = new Employee("liangzhaowei", 21);

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){

            System.out.println(iterator.next());
        }


    }
}
