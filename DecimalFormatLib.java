package topica.edu.vn;

import java.text.DecimalFormat;

public class DecimalFormatLib {

	public static void main(String[] args) {
		
		double m = 5;
		double p = 6;
		double c = 9;
		double mark = (m + p + c) / 3;
		
		System.out.println(mark);
		
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println(df.format(mark));
		
	}
}
