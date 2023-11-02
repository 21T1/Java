package topica.edu.vn;

import java.util.Random;

public class RandomLib {

	public static void main(String[] args) {
		
		Random rd = new Random();
		int x = rd.nextInt(101);
		System.out.println("X thuộc [0; 100]: " + x);
		x = rd.nextInt(-100, 101);
		System.out.println("X thuộc [-100; 100]: " + x);
		x = rd.nextInt(-100, 51);
		System.out.println("X thuộc [-100; 50]: " + x);
		
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(-50, 1);
		}
		System.out.print("Mảng ngẫu nhiên: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
