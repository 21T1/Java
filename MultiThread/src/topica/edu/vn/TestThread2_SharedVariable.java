package topica.edu.vn;

public class TestThread2_SharedVariable {

	public static void main(String[] args) {
		Thread2 th = new Thread2();
		
		Thread th1 = new Thread(th);
		th1.setName("[TT 1]");
		th1.start();
		
		Thread th2 = new Thread(th);
		th2.setName("[TT 2]");
		th2.start();
		
		Thread th3 = new Thread(th);
		th3.setName("[TT 3]");
		th3.start();
		
		System.out.println("x [now] = " + th.getX());
	}
}
