package com.Test;

import java.util.List;

public class DAOTest {

    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001",new User(101,32,"lw"));
        dao.save("1003",new User(103,43,"yt"));
        dao.save("1002",new User(102,13,"hzz"));


//        dao.delete("1002");
//        dao.update("1001",new User(111,11,"sb"));
//        dao.show();

        List<User> users = dao.mapToList();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
