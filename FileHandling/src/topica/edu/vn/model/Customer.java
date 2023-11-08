package topica.edu.vn.model;

import java.io.Serializable;

public class Customer implements Serializable {

	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return this.id + "\t" + this.name;
	}
}
