package topica.edu.vn;

public class Thread1 extends Thread {

	@Override
	public void run() {
		super.run();
		
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " i = " + i);
		}
	}

}
