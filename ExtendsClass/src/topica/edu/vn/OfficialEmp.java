package topica.edu.vn;

public class OfficialEmp extends Employee {

	@Override
	public String toString() {
		return super.toString() + " (Nhân viên chính thức)";
	}

	@Override
	public int salary() {
		return 500;
	}

}
