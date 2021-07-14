package cn.edu.usts.cs2018.dao.base;

import cn.edu.usts.cs2018.entity.Customer;

import java.util.List;

public interface ICustomerDao extends IBaseDao <Customer, Integer> {


	public abstract Customer login(Customer customer);
	public abstract boolean insert(List<Customer> list);
}
 
