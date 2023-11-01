package topica.edu.vn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarLib {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		System.out.println("Hôm nay là: " + day + "/" + month + "/" + year);
		
		Date date = cal.getTime();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yy");
		System.out.println("Định dạng 1: " + sdf1.format(date));
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("d/M/yyyy");
		System.out.println("Định dạng 2: " + sdf2.format(date));
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Định dạng 3: " + sdf3.format(date));
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("hh:mm:ss aaa");
		System.out.println("Định dạng 4: " + sdf4.format(date));
	}
}
