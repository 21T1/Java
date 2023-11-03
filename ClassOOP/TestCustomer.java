package topica.edu.vn;

public class TestCustomer {

	public static void main(String[] args) {
		Customer a = new Customer();
		a.setId("NV1");
		a.setName("Trần A");
		a.setAge(30);
		a.setAddress("Cà Mau");
		System.out.println(a);
		System.out.println("Địa chỉ: " + a.getAddress());
		
		Customer b = new Customer();
		b.setName("Nguyễn B");
		System.out.println("Tên của A: " + a.getName());
		System.out.println("Tên của B: " + b.getName());
		
		a = b;
		a.setName("Hoàng C");
		System.out.println("Tên của B: " + b.getName());
	
		System.out.println("x = " + a.getX());
		Customer c = new Customer();
		c.setX(100);
		System.out.println("x = " + c.getX());
		System.out.println("x = " + a.getX());
	}
}