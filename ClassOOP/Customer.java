package topica.edu.vn;

public class Customer {
	
	private String id;
	private String name;
	private int age;
	private String address;
	private static double x;
	
	public static double getX() {
		return x;
	}
	
	public static void setX(double value) {
		x = value;
	}

	public Customer() {
		System.out.println("Constructor mặc định tự động được gọi");
	}
	
	public Customer(String id, String name, int age, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		// this.id -> Instance Variable
		// id -> Local Variable
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return this.id + ";" + this.name + ";" + this.age + ";" + this.address;
	}
}