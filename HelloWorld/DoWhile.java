package topica.edu.vn;

public class DoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		int n = 1;
		do {
			n *= i;
			i++;
		} while (i <= 5);
		System.out.println("5! = " + n);
	}

}
