package topica.edu.vn;

import java.util.StringTokenizer;

public class StringLib {

	public static void main(String[] args) {
		// StringBuilder
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			builder.append("Phần tử thứ ");
			builder.append(i);
			builder.append("\n");
		}
		System.out.println(builder.toString());
	
		// StringTokenizer
		String s = "học , học , học nữa... học, mãi";
		StringTokenizer token = new StringTokenizer(s);
		System.out.println("Token 1:");
		while (token.hasMoreTokens()) {
			System.out.println(token.nextToken());
		}
		
		StringTokenizer token2 = new StringTokenizer(s, ",");
		System.out.println("\nToken 2:");
		while (token2.hasMoreTokens()) {
			System.out.println(token2.nextToken());
		}
		
		StringTokenizer token3 = new StringTokenizer(s, ", ");
		System.out.println("\nToken 3:");
		while (token3.hasMoreTokens()) {
			System.out.println(token3.nextToken());
		}
		
	}
}
