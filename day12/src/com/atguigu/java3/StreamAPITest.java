package com.atguigu.java3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. Stream关注的是对数据的运算，与CPU打交道
 *    集合关注的是数据的存储，与内存打交道
 *
 * 2.
 * 1)Stream 自己不会存在元素
 * 2)Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream
 * 3)Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 *
 * 3.Stream 执行流程
 * 1)Stream的实例化
 * 2)一系列的中间操作(过滤、映射...)
 * 3)终止操作
 *
 * 4.说明:
 * 4.1 一个中间操作链，对数据源的数据进行处理
 * 4.2 一旦执行终止操作，就执行中间操作链，并产生结果，之后，不会再被使用
 *
 * @Author lw
 * @Create2020-03-15 18:59
 */
class Employee{
    public int id;
    public String name;
    public int age;
    public double salary;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
class EmployeeData{
    public static List<Employee> getEmployees(){
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1001,"马化",12,6000.38));
        list.add(new Employee(1002,"腾2",21,7000.38));
        list.add(new Employee(1003,"化腾",13,9000.38));
        list.add(new Employee(1004,"马腾",31,3000.38));
        list.add(new Employee(1005,"马化腾5",45,5000.38));
        list.add(new Employee(1006,"马化腾6",76,11000.38));
        list.add(new Employee(1007,"腾7",32,300.38));
        list.add(new Employee(1008,"马化腾7",32,   300.38));

        return list;
    }
}
public class StreamAPITest {

    //创建Stream方式一:通过集合
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
//        default Stream<E> stream(): 返回一个顺序流
        employees.stream();

//        default Stream<E> paralleStream(): 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();

    }

    //创建Stream方式二:通过数组
    @Test
    public void test2(){
        int[] arr = {1, 2, 3, 4, 5, 6};
        //调用Arrays类的static <T> Stream<T> stream(T[] arrays):返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1002, "Jerry");
        Employee[] arr1 = {e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);

    }

    //创建Stream方式三:通过stream的of()
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    //创建Stream方式四:创建无限流
    @Test
    public void test4(){
        //迭代
//        public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);
        //生成
//        public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}

