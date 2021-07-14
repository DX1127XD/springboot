package cn.edu.usts.cs2018.dao;

import cn.edu.usts.cs2018.entity.Customer;

public class testsql {
    public static void main(String[] args) {
        Customer customer06 = new Customer(8, "6", "6","6","6");
        System.out.println("修改信息后的customer表如下：");
        CustomerDaoImpl sc=new CustomerDaoImpl();
        CustomerDaoImpl.insertMYSQL(customer06);
    }
}
