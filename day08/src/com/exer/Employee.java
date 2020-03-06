package com.exer;

public class Employee implements Comparable<Employee>{
    private String name;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private int age;
//    private MyDate birthday;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //指明泛型时的写法
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}
