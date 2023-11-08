package topica.edu.vn.test;

import java.util.ArrayList;

import topica.edu.vn.io.TextFileFactory;
import topica.edu.vn.model.Customer;

public class TestCustomer {

	public static void testSaveFile() {
		ArrayList<Customer> lstCt = new ArrayList<Customer>();
		lstCt.add(new Customer("KH01", "Nguyễn Văn A"));
		lstCt.add(new Customer("KH02", "Trần B"));
		lstCt.add(new Customer("KH03", "Hoàng C"));
		lstCt.add(new Customer("KH04", "Lê D"));
		lstCt.add(new Customer("KH05", "Ngô G"));
		
		boolean check = TextFileFactory.saveFile(lstCt, "C:\\Users\\Book\\Documents\\txtJava\\inp.txt");
		if (check) {
			System.out.println("Lưu file thành công");
		} else {
			System.out.println("Lưu file không thành công");
		}
	}
	public static void main(String[] args) {
//		testSaveFile();
		ArrayList<Customer> lstCt = TextFileFactory.readFile("C:\\Users\\Book\\Documents\\txtJava\\inpSer.txt");
		
		System.out.println("Danh sách khách hàng nạp vào máy tính là:");
		System.out.println("Mã\tTên");
		for (Customer ct : lstCt) {
			System.out.println(ct);
		}
	}

}
