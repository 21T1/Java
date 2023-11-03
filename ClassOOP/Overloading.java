package topica.edu.vn;

public class Overloading {

	public static int fn(int x, int y) {
		return x + y;
	}
	
	public static double fn(double x, double y) {
		return x + y + 100;
	}
	
	public static int fn2(int a, int b, int c) {
		return a + b + c;
	}
	
	public static int fn2(int a) {
		return a;
	}
	
	// parameter list
	public static int fn3(int ...arr) {
		int sum = 0;
		for (int x : arr) {
			sum += x;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(fn(1, 1));
		System.out.println(fn(1.0, 1.0));
		
		System.out.println(fn2(1, 2, 3));
		System.out.println(fn2(2));
		
		System.out.println(fn3(1, 2, 3));
		System.out.println(fn3(1, 2, 3, 4));
		System.out.println(fn3(1, 2, 3, 4, 5));
	}
}
