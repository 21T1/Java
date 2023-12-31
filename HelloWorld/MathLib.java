package topica.edu.vn;

import java.text.DecimalFormat;

public class MathLib {

	public static void main(String[] args) {
		
		int n = 25;
		System.out.println("Căn bậc 2 của 25 = " + Math.sqrt(n));
		
		int x = 8;
		int y = 3;
		System.out.println(x + "^" + y + " = " + Math.pow(x, y));
		
		int k = -113;
		System.out.println("|-113| = " + Math.abs(k));
		
		int r = 5;
		double C = 2 * Math.PI * r;
		double S = Math.PI * Math.pow(r, 2);
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		System.out.println("Bán kính r = " + r + "\nChu vi: " + df.format(C) + "\nDiện tích: " + df.format(S));
		
		int deg = 55;
		double rad = Math.PI * deg / 180;
		System.out.println("Sin(" + deg + ") = " + Math.sin(rad));
		System.out.println("Cos(" + deg + ") = " + Math.cos(rad));
		System.out.println("Tan(" + deg + ") = " + Math.tan(rad));
		System.out.println("Cotan(" + deg + ") = " + 1/Math.tan(rad));
	}
}
