package topica.edu.vn;

public class CheckedError {

	public static void main(String[] args) {
		try {
			int x = 1 / 0;
			
			System.out.println("Lỗi thực thi (chia cho 0)");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println("Bye!");
	}

}
