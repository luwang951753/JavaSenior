package com.atguigu.java2;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 使用enum关键字定义枚举类
 * 说明: 定义的枚举类默认继承于java.lang.Enum类
 *
 * @Author lw
 * @Create2020-03-11 14:37
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        //toString():
        System.out.println(summer.toString());

//        System.out.println(Season1.class.getSuperclass());
        System.out.println("**************");
        //values():
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            System.out.println(value);
            value.show();
        }

        Thread.State[] values1 = Thread.State.values();
        for (Thread.State state : values1) {
            System.out.println(state);
        }

        //valueOf(String objName):返回枚举类中对象名是objName的对象
        Season1 winter = Season1.valueOf("WINTER");
        //如果没有objName的枚举类对象,则抛异常
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);

    }
}

interface Info{
    void show();
}

//自定义枚举类
enum Season1 implements Info{
    //1.提供当前枚举类的对象,多个对象之间用"，"隔开，末尾对象"；"结束
    SPRING("春天","春春春春"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天","夏夏夏夏"){
        @Override
        public void show() {
            System.out.println("夏天去哪里");
        }
    },
    AUTUMN("秋天","秋秋秋秋"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冬冬冬冬"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //私有化类的构造器
    private Season1(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    //4.提供获取值
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //其它诉求1: 提供toString()

    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
}

