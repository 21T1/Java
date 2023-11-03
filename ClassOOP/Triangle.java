package topica.edu.vn;

public class Triangle {

	private int a, b, c;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public Triangle(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Triangle() {
		super();
	}

	public String toString() {
		String info = "Triangle [a=" + a + ", b=" + b + ", c=" + c + "]";
		if (check()) {
			return info + "\nChu vi: " + perimeter() + "\nDiện tích: " + area();
		}else {
			return info + "\nTam giác không hợp lệ";
		}
	}
	
	// support method
	private boolean check() {
		return this.a > 0 && this.b > 0 && this.c > 0
				&& (this.a + this.b) > this.c 
				&& (this.a + this.c) > this.b
				&& (this.b + this.c) > this.a;
	}
	
	public double perimeter() {
		return this.a + this.b + this.c;
	}
	
	public double area() {
		double p = perimeter() / 2;
		return Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
	}
}
