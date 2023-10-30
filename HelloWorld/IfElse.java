package topica.edu.vn;

import java.util.Scanner;

public class IfElse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 6;
		if (i % 2 == 0)
			System.out.println(i + " là số chẵn");
		else
			System.out.println(i + " là số lẻ");
		
		String s = (i % 2 == 0) ? "số chẵn" : "số lẻ";
		System.out.println(i + " là " + s);
		
		// the days of the month
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhập tháng: ");
		int month = sc.nextInt();
		switch (month) {
			case 1, 3, 5, 7, 8, 10, 12:
				System.out.println("Tháng " + month + " có 31 ngày");
				break;
			case 4, 6, 9, 11:
				System.out.println("Tháng " + month + " có 30 ngày");
				break;
			case 2:
				System.out.print("Nhập năm: ");
				int year = sc.nextInt();
				String ans = ((year % 4 == 0 && year % 100 != 0) || (year %400 == 0))
							? ("29 ngày")
							: ("28 ngày");
				System.out.println("Tháng 2/" + year + " có " + ans);
				break;
			default:
				System.out.println("Không tồn tại tháng " + month);
		}
		
		sc.close();
	}

}
