package bus;
import java.io.*; 
import java.util.ArrayList;

public class FileManagerAccount {
	public static void writeToSerializedFile(ArrayList<IBankSystem> listOfAccounts) throws IOException
	{		
		FileOutputStream fos = new FileOutputStream("C:\\JavaWork\\JavaProject_Part_II (2 Tiers App)\\FortisBank_BackEnd\\src\\data\\AccountList.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);		
		//write the list of cities(listOfCities) into the physical file(cities.ser)
		  oos.writeObject(listOfAccounts);
		  fos.close();		
	}	
	@SuppressWarnings("unchecked")
	public static ArrayList <IBankSystem>  readFromSerializedFile() throws IOException, ClassNotFoundException
	{
		ArrayList<IBankSystem> listOfAccountsFromFile = new ArrayList<IBankSystem>();
		  FileInputStream fis = new FileInputStream("C:\\JavaWork\\JavaProject_Part_II (2 Tiers App)\\FortisBank_BackEnd\\src\\data\\AccountList.ser");
		  ObjectInputStream ois = new ObjectInputStream(fis);		  
		  listOfAccountsFromFile  =   (ArrayList<IBankSystem>) ois.readObject();		  
		  fis.close();			  
		  return listOfAccountsFromFile;	
	} 	
	public static boolean SearchAccount(int customerId)
	{
		boolean flag = false;
		ArrayList<IBankSystem> AllAccounts = new ArrayList<IBankSystem>();
		try {
			AllAccounts = readFromSerializedFile();
			
			for(IBankSystem aAccount : AllAccounts)
			{
				if(aAccount instanceof CheckingAccount)
				{
					if(((CheckingAccount) aAccount).getIdentificationNumber() == customerId)
					{
						flag = true;
					}
				}
			}
			
			flag = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	


}
