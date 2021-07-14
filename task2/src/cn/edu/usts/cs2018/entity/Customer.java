package cn.edu.usts.cs2018.entity;

public class Customer {

	private int id;

	private String name;

	private String telephone;

	private String address;

	private String dept;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Customer(int id, String name, String telephone, String address, String dept) {
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.address = address;
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", telephone='" + telephone + '\'' +
				", address='" + address + '\'' +
				", dept='" + dept + '\'' +
				'}';
	}

}
 
