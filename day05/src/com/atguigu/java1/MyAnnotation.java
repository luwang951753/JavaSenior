package com.atguigu.java1;

/**
 * @Author lw
 * @Create2020-03-11 16:16
 */
public @interface MyAnnotation {
    String value() default "hello";
}
