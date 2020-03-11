package com.atguigu.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @Author lw
 * @Create2020-03-10 17:24
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate(){
        Date date1 = new Date(2020 - 1900, 9 - 1, 8);
        System.out.println(date1);
    }

    /**
     * LocalDate、LocalTime、LocalDateTime 的使用
     * LocalDateTime相较于LocalDate、LocalTime，使用频率要高
     */
    @Test
    public void test1(){
        //now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 12, 21, 23, 31);
        System.out.println(localDateTime1);

        //getXxx():获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //体现不可变性
        //withXxx():设置相关的属性
        LocalDateTime localDate1 = localDateTime.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);


        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);


    }

    /**
     * Instant
     * 类似于java.util.date类
     */
    @Test
    public void test2(){
        //now()：获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);
        //添加时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取自1070开始的对应的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);
        //ofEpochMilli:通过给定的毫秒数，获取Instant实例
//        Instant.ofEpochMilli()

    }

    /**
     * DateTimeFormatter: 格式化或解析日期、时间
     * 类似于SimpleDateFormat
     */
    @Test
    public void test3(){
        //方式一:预定义的标准格式 如:ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期 --> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        //解析: 字符串 --> 日期
        TemporalAccessor parse = formatter.parse("2019-02-18");
        System.out.println(parse);

    }

}
