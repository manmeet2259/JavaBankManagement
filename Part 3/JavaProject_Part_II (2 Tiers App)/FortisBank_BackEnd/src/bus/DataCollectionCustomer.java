package bus;

import java.io.IOException;
import java.util.ArrayList;

public class DataCollectionCustomer {
	
	private static ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public static void add(Customer object)
	 {
		 customerList.add(object );		 
	 }	 
	 
  public static void remove(Customer object)
	 {
		 customerList.remove(object);		 
	 }	 
	
  public static void removeAt(int index)
	 {
		 customerList.remove(index);		 
	 }	 
	 
	 
	 public static void print()	 
	 {
		 customerList.removeAll(customerList);
		 DataCollectionCustomer.PopulateDataFromFile();
		 for(Customer element : customerList)
		 {
			 System.out.println(element);
			 
		 } 		 
	 } 	 
	 
	 public static Customer search(int key)
	 {
			 for( Customer element : customerList)
			 {
				 if(element.getIdentificationNumber() == key)
				 {
					 return element;				 
				 }
			 }		 
	   return null;	   
	 }
	 
	 public static void PopulateDataFromFile()
	 {
		 try {
			customerList = FileManagerCustomer.readFromSerializedFile();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 public static boolean saveData()
	 {
		 boolean status = false;
		 try {
			FileManagerCustomer.writeToSerializedFile(customerList);
			return status = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return status;
		 
	 }

}
