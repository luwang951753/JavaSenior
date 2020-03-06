package com.atguigu.exer1;

import java.util.*;

public class DAO<T> {
    private Map<String, T> map = new HashMap<String, T>();

    //保存T类型的对象到Map成员变量中
    public void save(String id, T entity){
        map.put(id, entity);
    }
    //从map中获取id对应的对象
    public T get(String id){
        T t = map.get(id);
        return t;
    }
    //替换 map 中 key为id的内容，改为entity 对象
    public void update(String id, T entity){
        if(map.containsKey(id)){
            map.put(id, entity);
        }
    }
    //返回map中存放的所有T对象
    public List<T> list() {
        ArrayList<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for (T t : values) {
            list.add(t);
        }
        return list;
    }
    //删除指定 id 对象
    public void delete(String id){
        map.remove(id);
    }

}
