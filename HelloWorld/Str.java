package topica.edu.vn;

public class Str {

	public static void main(String[] args) {
		String s = "123 Topica Education 321";
		System.out.println("Chiều dài của chuỗi = " + s.length());
		
		// Count upper, lower, number
		char[] arr = s.toCharArray();
		int upper = 0, lower = 0, num = 0;
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if (Character.isUpperCase(c)) {
				upper++;
			}
			if (Character.isLowerCase(c)) {
				lower++;
			}
			if (Character.isDigit(c)) {
				num++;
			}
		}
		System.out.println("Chuỗi có " + upper + " ký tự in hoa");
		System.out.println("Chuỗi có " + lower + " ký tự in thường");
		System.out.println("Chuỗi có " + num + " ký tự số");
		
		// Use substring
		String path = "D:/music/nhactrinh/riengmotgoctroi.mp3";
		String songName = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
		System.out.println("Tên bài hát: " + songName);	
		
		// Optimize string
		String x = "       Nguyễn        Văn         A      ";
		String[] arrStr = x.strip().split(" ");
		String optimalStr = "";
		for (String word : arrStr) {
			if (word != "") {
				optimalStr += word + " ";
			}
		}
		System.out.println("Chuỗi tối ưu: " + optimalStr);
	}
}
