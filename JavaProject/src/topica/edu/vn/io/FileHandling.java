package topica.edu.vn.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import topica.edu.vn.model.Customer;

public class FileHandling {

	public static boolean saveFile(ArrayList<Customer> lstCt, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(lstCt);
			oos.close();
			fos.close();
			
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Customer> readFile(String path){
		ArrayList<Customer> lstCt = new ArrayList<Customer>();
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			lstCt = (ArrayList<Customer>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lstCt;
	}
	
	public static void main(String[] args) {
	}
}
