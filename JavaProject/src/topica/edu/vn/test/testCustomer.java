package topica.edu.vn.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import topica.edu.vn.io.FileHandling;
import topica.edu.vn.model.Customer;

public class testCustomer {

	static ArrayList<Customer> lstCt = new ArrayList<Customer>();
	
	public static void menu() {
		System.out.println("1. Nhập khách hàng");
		System.out.println("2. Xuất khách hàng");
		System.out.println("3. Tìm kiếm khách hàng (theo SĐT)");
		System.out.println("4. Sắp xếp khách hàng (theo SĐT)");
		System.out.println("5. Lưu khách hàng");
		System.out.println("6. Đọc khách hàng");
		System.out.println("7. Thống kê (theo nhà mạng Viettel)");
		System.out.println("8. Thoát");
		System.out.print("Chọn chức năng (1 -> 8): ");
		int act = new Scanner(System.in).nextInt();
		switch (act) {
			case 1:
				addCt();
				break;
			case 2:
				showCt();
				break;
			case 3:
				searchCt();
				break;
			case 4:
				sortCt();
				break;
			case 5:
				saveDtb();
				break;
			case 6:
				readDtb();
				break;
			case 7:
				statistic();
				break;
			case 8:
				endTest();
			default:
				System.out.println("Lỗi");
		}
	}
	
	public static void showTitle() {
		System.out.println("\t\tDANH SÁCH KHÁCH HÀNG\n");
		System.out.println(String.format("| %5s | %-20s | %10s", "Mã KH", "Tên KH", "SĐT"));
		for (int i = 0; i < 50; i++) {
			System.out.print("-");
		}
	}
	
	public static void showBreakLine() {
		for (int i = 0; i < 50; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	private static void sortCt() {
		Collections.sort(lstCt);
		showBreakLine();
		System.out.println("Sắp xếp thành công!");
		showBreakLine();
		System.out.println();
	}

	private static void endTest() {
		showBreakLine();
		System.out.println("Kết thúc chương trình");
		showBreakLine();
		System.exit(0);
	}

	private static void statistic() {
		int cnt = 0;
		showBreakLine();
		for (Customer ct : lstCt) {
			if (ct.getPhoneNum().startsWith("098")) {
				cnt++;
			}
		}
		System.out.println("Có " + cnt + " khách hàng Viettel");
		showBreakLine();
		System.out.println();
	}

	private static void readDtb() {
		String path = System.getProperty("user.dir") + "/src/Customer.txt";
		lstCt = FileHandling.readFile(path);
		showBreakLine();
		System.out.println("Đọc file thành công");
		showBreakLine();
		System.out.println();
	}

	private static void saveDtb() {
		String path = System.getProperty("user.dir") + "/src/Customer.txt";
		boolean check = FileHandling.saveFile(lstCt, path);
		showBreakLine();
		if (check) {
			System.out.println("Lưu file thành công");
		} else {
			System.out.println("Lưu file thất bại");
		}
		showBreakLine();
		System.out.println();
	}

	private static void searchCt() {
		System.out.print("Nhập đầu số (vd: 098): ");
		String p = new Scanner(System.in).nextLine();
		
		boolean check = true;
		showBreakLine();
		for (Customer ct : lstCt) {
			if (ct.getPhoneNum().startsWith(p)) {
				if (check) {
					showTitle();
					check = false;
				}
				System.out.println(ct);
			}
		}
		showBreakLine();
		System.out.println();
	}

	private static void showCt() {
		showBreakLine();
		showTitle();
		System.out.println();
		for (Customer ct : lstCt) {
			System.out.println(ct);
		}
		showBreakLine();
		System.out.println();
	}

	private static void addCt() {
		showBreakLine();
		System.out.println("THÊM KHÁCH HÀNG MỚI");
		System.out.print("Nhập mã khách hàng: ");
		int id = new Scanner(System.in).nextInt();
		System.out.print("Nhập tên khách hàng: ");
		String name = new Scanner(System.in).nextLine();
		System.out.print("Nhập SĐT: ");
		String phoneNum = new Scanner(System.in).nextLine();
		Customer ct = new Customer(id, name, phoneNum);
		
		lstCt.add(ct);
		System.out.println("Thêm thành công!");
		showBreakLine();
	}

	public static void main(String[] args) {
		while (true) {
			menu();
		}
	}

}
