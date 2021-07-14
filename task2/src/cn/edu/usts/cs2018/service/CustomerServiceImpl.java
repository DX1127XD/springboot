package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.dao.CustomerDaoImpl;
import cn.edu.usts.cs2018.dao.base.ICustomerDao;
import cn.edu.usts.cs2018.entity.Customer;
import cn.edu.usts.cs2018.service.base.IUserService;

import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements IUserService {
    private ICustomerDao dao;    // DAO对象，采用接口的引用
    public CustomerServiceImpl(){
        this.dao=  new CustomerDaoImpl();
        }


    // 构造方法，初始化dao属性

    @Override
    public Customer login(Customer customer) {
        return dao.login(customer);
    }

    @Override
    public boolean insert(List<Customer> list) {
        return dao.insert(list);
    }

    @Override
    public boolean insert(Customer entity) {
        return dao.insert(entity);
    }

    @Override
    public boolean update(Customer entity) {
        return dao.update(entity);
    }

    @Override
    public boolean delete(Customer entity) {
        return dao.delete(entity);
    }

    @Override
    public  Object findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List find(Map condition) {
        return null;
    }

    @Override
    public long count(Map obj) {
        return 0;
    }

    @Override
    public boolean saveOrUpdate(Customer entity) {
        return dao.saveOrUpdate(entity);
    }
}
