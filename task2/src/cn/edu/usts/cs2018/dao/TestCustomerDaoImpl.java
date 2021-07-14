package cn.edu.usts.cs2018.dao;

import cn.edu.usts.cs2018.entity.Customer;

import java.util.List;

//测试customerdaoImpl数据库customer增删改查
public class TestCustomerDaoImpl {
    public static void main(String[] args) {
        System.out.println("customer表如下：");
        List<Customer> list01 = CustomerDaoImpl.findAllMYSQL();
        for (Customer customer : list01) {
            System.out.println(customer);
        }
        System.out.println("插入一条新信息");
        Customer customer01 = new Customer(4, "rosy", "784651","陕西","人力");
        Customer customer05 = new Customer(6, "6", "6","6","6");
        System.out.println("修改信息后的customer表如下：");
        CustomerDaoImpl.insertMYSQL(customer01);
        CustomerDaoImpl.insertMYSQL(customer05);
        List<Customer> list02 = CustomerDaoImpl.findAllMYSQL();
        for (Customer customer : list02) {
            System.out.println(customer);
        }

        System.out.println("修改插入的信息");
        Customer customer02 = new Customer(4, "jacy", "rosy","新疆","法律部");
        System.out.println(CustomerDaoImpl.updateMYSQL(customer02));
        System.out.println("修改信息后的customer表如下：");
        List<Customer> list03 = CustomerDaoImpl.findAllMYSQL();
        for (Customer customer : list03) {
            System.out.println(customer);
        }



        System.out.println("查询id=4的信息：");
        System.out.println(CustomerDaoImpl.findByIdMYSQL(4));

        System.out.println("删除id=4的插入的信息，并返回结果"+CustomerDaoImpl.deleteMYSQL(4));






        System.out.println("返回最终的customer表：");
        List<Customer> list04 = CustomerDaoImpl.findAllMYSQL();
        for (Customer customer : list04) {
            System.out.println(customer);
        }
    }
}

