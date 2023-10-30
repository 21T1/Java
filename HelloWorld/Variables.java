package topica.edu.vn;

public class Variables {

	public static void main(String[] args) {
		int x = 5, y = 7;
		
		System.out.println("Min của Int = " + Integer.MIN_VALUE);
		System.out.println("Max của Int = " + Integer.MAX_VALUE);
		
		int z = x++ + ++y - 8;	// 5 + 8 - 8
		System.out.println(z);
	}
}
