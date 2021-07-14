package cn.edu.usts.cs2018.controller;

import cn.edu.usts.cs2018.entity.Customer;
import cn.edu.usts.cs2018.service.CustomerServiceImpl;

class CustomerServiceImplTest {
    public static void main(String[] args) {
        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();

        boolean insert = customerServiceImpl.insert(new Customer(222,"mike","123546","123456","苏州科技大学"));

        if(insert==true) {
            System.out.println("插入成功:" );
        }

        Customer byId = (Customer) customerServiceImpl.findById(222);
        System.out.println(byId);

        boolean update = customerServiceImpl.update(new Customer(2, "admin", "admin321", "13913013200", "东方大道3099号"));
        if(update==true) {
            System.out.println("修改成功:" );
        }
        System.out.println("修改后的信息: " + customerServiceImpl.findById(2));
        // 测试删除
        /*boolean delete = customerServiceImpl.delete(222);
        System.out.println("是否删除成功:" + delete);*/
    }
}