package topica.edu.vn;

public class PartTimeEmp extends Employee {

	@Override
	public int salary() {
		return 100;
	}

	@Override
	public String toString() {
		return super.toString() + " (Nhân viên thời vụ)";
	}
	
}
