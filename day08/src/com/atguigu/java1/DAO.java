package com.atguigu.java1;

import java.util.List;

public class DAO<T> {//表的共性操作

    //添加一条记录
    public void add(T t){

    }

    //删除一条记录
    public boolean remove(int index){
        return false;
    }

    //修改一条记录
    public void update(int index, T t){

    }

    //查询一条记录
    public T getIndex(int index){
        return null;
    }

    //查询多条记录
    public List<T> getForList(int index){
        return null;
    }

    //获取表中一共有多少条记录
    public <E> E getValue(){
        return null;
    }

}
