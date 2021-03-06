package bus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManagerCustomer {
	public static void writeToSerializedFile(ArrayList<Customer> customer) throws IOException
	{		
		FileOutputStream fos = new FileOutputStream("C:\\JavaWork\\JavaProject_Part_II (2 Tiers App)\\FortisBank_BackEnd\\src\\data\\CustomerList.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);		
		//write the list of cities(listOfCities) into the physical file(cities.ser)
		  oos.writeObject(customer);
		  fos.close();		
	}	
	@SuppressWarnings("unchecked")
	public static ArrayList <Customer>  readFromSerializedFile() throws IOException, ClassNotFoundException
	{
		ArrayList<Customer> listOfCustomersFromFile = new ArrayList<Customer>();
		  FileInputStream fis = new FileInputStream("C:\\JavaWork\\JavaProject_Part_II (2 Tiers App)\\FortisBank_BackEnd\\src\\data\\CustomerList.ser");
		  ObjectInputStream ois = new ObjectInputStream(fis);		  
		  listOfCustomersFromFile  =   (ArrayList<Customer>) ois.readObject();		  
		  fis.close();			  
		  return listOfCustomersFromFile;	
	} 	

}
