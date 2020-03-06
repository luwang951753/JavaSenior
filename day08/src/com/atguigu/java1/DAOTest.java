package com.atguigu.java1;

import java.util.List;

public class DAOTest {

    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();
        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);

        StudentDAO dao = new StudentDAO();
//        dao.add();
    }

}
