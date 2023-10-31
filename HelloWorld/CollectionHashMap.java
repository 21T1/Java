package topica.edu.vn;

import java.util.HashMap;

public class CollectionHashMap {
	public static void main(String[] args) {
		
		HashMap<Integer, String> lst = new HashMap<Integer, String>();
		lst.put(1, "Hoàng A");
		lst.put(2, "Nguyễn B");
		lst.put(3, "Lê C");
		
		System.out.println("MNV\tHọ và tên");
		for (int id : lst.keySet()) {
			System.out.println(id + "\t" + lst.get(id));
		}
		lst.remove(3);
		
		System.out.println("Danh sách nhân  viên sau khi xóa:");
		System.out.println("MNV\tHọ và tên");
		for (int id : lst.keySet()) {
			System.out.println(id + "\t" + lst.get(id));
		}
	}
}
