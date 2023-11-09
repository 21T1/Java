package topica.edu.vn.model;

import java.io.Serializable;

public class Customer implements Serializable, Comparable<Customer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String phoneNum;
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
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Customer(int id, String name, String phoneNum) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNum = phoneNum;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return String.format("| %5d | %-20s | %10s", this.id, this.name, this.phoneNum);
	}
	@Override
	public int compareTo(Customer o) {
		return this.phoneNum.compareToIgnoreCase(o.getPhoneNum());
	}
}
