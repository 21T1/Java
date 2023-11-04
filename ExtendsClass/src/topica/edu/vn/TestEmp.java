package topica.edu.vn;

public class TestEmp {

	public static void main(String[] args) {
		Employee a = new OfficialEmp();
		a.setName("Nguyễn Văn A");
		System.out.println(a);
		
		OfficialEmp b = new OfficialEmp();
		b.setName("Lê B");
		System.out.println(b);
		
		a = new PartTimeEmp();
		a.setName("Nguyễn Văn A");
		System.out.println(a);
	}

}
