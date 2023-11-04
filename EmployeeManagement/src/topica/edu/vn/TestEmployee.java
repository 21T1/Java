package topica.edu.vn;

import java.util.ArrayList;
import java.util.Collections;

public class TestEmployee {

	public static void main(String[] args) {
		ArrayList<Employee> lst = new ArrayList<Employee>();
		lst.add(new Employee(2, "Dương"));
		lst.add(new Employee(1, "bình"));
		lst.add(new Employee(4, "An"));
		lst.add(new Employee(5, "Huy"));
		lst.add(new Employee(3, "duy"));
		lst.add(new Employee(6, "an"));
	
		System.out.println("Danh sách nhân viên của công ty:");
		for (Employee emp : lst) {
			System.out.println(emp.getId() + " " + emp.getName());
		}
		
		Collections.sort(lst);
		System.out.println("Danh sách nhân viên sau khi sắp xếp:");
		for (Employee emp : lst) {
			System.out.println(emp.getId() + " " + emp.getName());
		}
	}

}
