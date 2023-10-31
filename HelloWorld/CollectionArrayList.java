package topica.edu.vn;

import java.util.ArrayList;

public class CollectionArrayList {

	public static void main(String[] args) {
		
		ArrayList ds = new ArrayList();
		ds.add("An");
		ds.add("Bình");
		ds.add("Công");
		ds.add("Dương");
		ds.add(2, "Duy");
		
		for (int i = 0; i < ds.size(); i++) {
			System.out.print(ds.get(i) + " ");
		}
		System.out.println("\n------");
		for (Object data : ds) {
			System.out.print(data + " ");
		}
		
		ArrayList<Float> lst = new ArrayList<Float>();
		lst.add(1.5f);
		lst.add(1.8f);
		System.out.println("\nSố phần tử của danh sách lst: " + lst.size());
		lst.add(113.114f);
		System.out.println("Số phần tử của danh sách lst: " + lst.size());
		lst.remove(1.5f);	// lst.remove(0);
		System.out.println("Số phần tử của danh sách lst: " + lst.size());
		
		System.out.println("Các phần từ trong ArrayList lst:");
		for (float x : lst) {
			System.out.print(x + " ");
		}
		
		lst.set(0, 78.79f);
		System.out.println("\nCác phần từ trong ArrayList lst sau chỉnh sửa:");
		for (Object x : lst) {
			System.out.print(x + " ");
		}
	}

}
