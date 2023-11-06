package topica.edu.vn;

public class TestThread1 {

	public static void main(String[] args) {
		Thread1 th1 = new Thread1();
		th1.setName("Tiến trình 1");
		th1.start();	// Kích hoạt tiến trình/tiểu trình
		
		Thread1 th2 = new Thread1();
		th2.setName("Tiến trình 2");
		th2.start();	
	}

}
