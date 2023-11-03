package topica.edu.vn;

public class StaticUse {

	public static int x = 5;	// x -> class member
	public int y;
	
	// static first -> non - static
	public static void fn() {
		// System.out.println(y);
		System.out.println(x);
	}
	
	public void fn2() {
		System.out.println(y);
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		
	}
}
