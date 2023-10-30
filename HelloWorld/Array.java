package topica.edu.vn;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m = new int[4];
		m[0] = 7;
		m[1] = 0;
		m[2] = 3;
		m[3] = 9;
		System.out.print("Mảng của bạn là: ");
		for (int i = 0; i < m.length; i++) {
			System.out.print(m[i] + " ");
		}
		Arrays.sort(m);
		
		System.out.print("\nMảng sau khi sắp xếp: ");
		for (int i = 0; i < m.length; i++) {
			System.out.print(m[i] + " ");
		}
		
		System.out.print("\nCác số nguyên tố trong mảng: ");
		for (int i = 0; i < m.length; i++) {
			int cnt = 0;
			for (int j = 1; j <= m[i]; j++) {
				if (m[i] % j == 0) {
					cnt++;
				}
			}
			if (cnt == 2) {
				System.out.print(m[i] + " ");
			}
		}
	}

}
