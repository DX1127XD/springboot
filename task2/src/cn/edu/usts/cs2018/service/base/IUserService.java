package cn.edu.usts.cs2018.service.base;

import cn.edu.usts.cs2018.entity.Customer;

import java.util.List;

public interface IUserService extends IBaseService<Customer, Integer> {
 
	public abstract Customer login(Customer customer);
	public abstract boolean insert(List<Customer> list);
}
 
