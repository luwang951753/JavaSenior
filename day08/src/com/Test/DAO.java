package com.Test;

import java.util.*;

public class DAO<T> {

    HashMap<String, T> map = new HashMap<>();

    public void save(String id, T entity){
        map.put(id, entity);
    }

    public void delete(String id){
        map.remove(id);
    }

    public void update(String id, T entity){
//        map.put(id, entity);
        if(map.containsKey(id)){
            map.put(id,entity);
        }else{
            System.out.println("指定ID不存在");
        }
    }
    public void show(){
        Set<Map.Entry<String, T>> entries = map.entrySet();
        Iterator<Map.Entry<String, T>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, T> entry = iterator.next();
            String key = entry.getKey();
            T value = entry.getValue();
            User u = (User) value;
            System.out.println(key+"="+u.getId()+"="+u.getAge()+"="+u.getName());
        }
    }

    public List<T> mapToList(){
//        ArrayList arrayList = new ArrayList();
        ArrayList<T> arrayList = new ArrayList<>();
        Set<Map.Entry<String, T>> entries = map.entrySet();
        Iterator<Map.Entry<String, T>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, T> next = iterator.next();
            System.out.println(next.getKey()+"=="+next.getValue());


            arrayList.add(next.getValue());
        }
        return arrayList;
    }
}
