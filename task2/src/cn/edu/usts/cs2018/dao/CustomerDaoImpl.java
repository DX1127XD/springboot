package cn.edu.usts.cs2018.dao;

import cn.edu.usts.cs2018.dao.base.ICustomerDao;
import cn.edu.usts.cs2018.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerDaoImpl implements ICustomerDao {
	private List<Customer> list = new ArrayList<Customer>();




	@Override
	public Customer login(Customer customer) {
		Customer result = null;

		for( Customer u : list) {
			if(u.getName().equals(customer.getName()) /*&&
					*//*u.getPassword().equals(customer.getPassword())*/) {
				result = u;
			}
		}

		return result;
	}

	@Override
	public boolean insert(List<Customer> list) {
		boolean result = true ;
		for ( Customer customer : list ) {
			if(! insert(customer)) {  // 失败
				result = false;
				break;
			}
		}
		return result;
	}

	@Override
	public boolean insert(Customer entity) {
		boolean flag = false;

		for(Customer u : list){
			if(u.getName().equals(entity.getName()))
			{
				flag = true;
				break;
			}
		}
		if(!flag)
			list.add(entity);

		return !flag;

	}

	@Override
	public boolean update(Customer entity) {
		return saveOrUpdate(entity) ;
	}

	@Override
	public boolean delete(Customer entity) {
		return false;
	}

	@Override
	public Object findById(Integer integer) {
		return null;
	}


	public Object findById(int id) {
		Customer customer = null;

		for (Customer c : list) {
			if(c.getId() == id){
				customer = c;
				break;
			}
		}
		return customer;
	}

	@Override
	public List find(Map condition) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}



	@Override
	public boolean saveOrUpdate(Customer customer) {
		boolean flag = false;

		for(Customer u : list){
			if(u.getId() == (customer.getId()))  // 查找指定的对象，找到进行更新。
			{
				flag = true;
				u.setName( customer.getName());
				break;
			}
		}

		return flag;

	}
	//jdbc增加数据
	public static boolean insertMYSQL(Customer customer) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBManager.getConnection();
			String sql = "INSERT INTO customer(id, name, telephone, address,dept) VALUES (?, ?, ?, ?,?);";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, customer.getId());
			statement.setString(2, customer.getName());
			statement.setString(3, customer.getTelephone());
			statement.setString(4, customer.getAddress());
			statement.setString(5, customer.getDept());
			int count = statement.executeUpdate();
			return count > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeAll(connection, statement);
		}
		return false;
	}
	//JDBC修改用户数据
	public static boolean updateMYSQL(Customer customer) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBManager.getConnection();
			String sql="UPDATE customer SET name = ?, telephone = ?, address=?,dept = ? WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(5, customer.getId());
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getTelephone());
			statement.setString(3, customer.getAddress());
			statement.setString(4,customer.getDept());

			int count = statement.executeUpdate();
			return count > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeAll(connection, statement);
		}
		return false;
	}

	//jdbc删除用户
	public static boolean deleteMYSQL(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBManager.getConnection();
			String sql = "DELETE FROM customer WHERE id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			int count = statement.executeUpdate();
			return count > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeAll(connection, statement);
		}
		return false;
	}

	//jdbc查找customer
	public static Customer findByIdMYSQL(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBManager.getConnection();
			String sql = "SELECT * FROM customer WHERE id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				return new Customer(resultSet.getInt("id"),
						resultSet.getString("name"), resultSet.getString("telephone"), resultSet.getString("address"), resultSet.getString("dept"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeAll(connection, statement, resultSet);
		}
		return null;
	}

	//JDBC返回所有用户
	public static List<Customer> findAllMYSQL() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Customer> list = new ArrayList<>();
		try {
			connection = DBManager.getConnection();
			String sql = "SELECT * FROM customer";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Customer customer = new Customer(resultSet.getInt("id"),
						resultSet.getString("name"), resultSet.getString("telephone"), resultSet.getString("address"), resultSet.getString("dept")
				);
				list.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeAll(connection, statement, resultSet);
		}
		return list;
	}
}
 
