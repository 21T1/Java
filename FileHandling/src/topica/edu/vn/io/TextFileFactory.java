package topica.edu.vn.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import topica.edu.vn.model.Customer;

public class TextFileFactory {

	public static boolean saveFile(ArrayList<Customer> lstCt, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (Customer ct : lstCt) {
				String line = ct.getId() + ";" + ct.getName();
				bw.write(line);
				bw.newLine();
			}
			bw.close();
			osw.close();
			fos.close();
			return true;
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return false;	
	}
	
	public static ArrayList<Customer> readFile(String path){
		ArrayList<Customer> lstCt = new ArrayList<Customer>();
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			String line = br.readLine();
			while (line != null) {
				String[] ct = line.split(";");
				if (ct.length == 2) {
					lstCt.add(new Customer(ct[0], ct[1]));
					line = br.readLine();
				}
			}
			
			br.close();
			isr.close();
			fis.close();
		} catch (Exception ex) {
			ex.getStackTrace();
		}
		return lstCt;
	}
}
