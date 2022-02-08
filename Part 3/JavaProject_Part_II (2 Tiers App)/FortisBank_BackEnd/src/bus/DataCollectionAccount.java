package bus;

import java.io.IOException;
import java.util.ArrayList;

public class DataCollectionAccount {
	
	private static ArrayList<IBankSystem> bankSystem = new ArrayList<IBankSystem>();
	
	public static void add(IBankSystem object)
	 {
		 bankSystem.add(object );		 
	 }	 
	 
   public static boolean remove(IBankSystem object)
	 {
		 bankSystem.remove(object);
		 return true;
	 }	 
	
   public static void removeAt(int index)
	 {
		 bankSystem.remove(index);		 
	 }	 
	 
	 
	 public static void print()	 
	 {
		 bankSystem.removeAll(bankSystem);
		 DataCollectionAccount.PopulateDataFromFile();
		 for(IBankSystem element : bankSystem)
		 {
			 System.out.println(element);
			 
		 } 		 
	 } 	 
	 
	 public static IBankSystem search(int key)
	 {
			 for( IBankSystem element : bankSystem)
			 {
				 if(element.getAccountNumber() == key)
				 {
					 return element;				 
				 }
			 }		 
	   return null;	   
	 }

	 public static ArrayList<CheckingAccount> getCheckingAccountList()
	 {
	   ArrayList<CheckingAccount> listOfCheckingAccount = new ArrayList<CheckingAccount>();
		 
		   for( IBankSystem element : bankSystem)
		   {
			   if(element instanceof CheckingAccount)
			   {			   
				   listOfCheckingAccount.add((CheckingAccount)element);		   
			   }  	   
		   }
		   
	      return listOfCheckingAccount ;
		 
	 }
	 
	 public static ArrayList<SavingAccount> getSavingAccountList()
	 {
	   ArrayList<SavingAccount>  listOfSavingAccount = new ArrayList<SavingAccount>();
		 
		   for( IBankSystem element : bankSystem)
		   {
			   if(element instanceof SavingAccount)
			   {			   
				   listOfSavingAccount.add((SavingAccount)element);	   
			   }
		   }	
		   
	      return listOfSavingAccount; 
	 }
	 
	 public static ArrayList<CreditAccount> getCreditAccountList()
	 {
	   ArrayList<CreditAccount>  listOfCreditAccount = new ArrayList<CreditAccount>();
		 
		   for( IBankSystem element : bankSystem)
		   {
			   if(element instanceof SavingAccount)
			   {			   
				   listOfCreditAccount.add((CreditAccount)element);	   
			   }
		   }	
		   
	      return listOfCreditAccount; 
	 }
	 
	 public static void displayCheckingAccount()
	 {
		 ArrayList<CheckingAccount> listOfCheckingAccount = new ArrayList<CheckingAccount>();
		 
		   for( IBankSystem element : bankSystem)
		   {
			   if(element instanceof CheckingAccount)
			   {			   
				   listOfCheckingAccount.add((CheckingAccount)element);		   
			   }  	   
		   }
		   for( CheckingAccount element : listOfCheckingAccount)
		   {
			   if(element instanceof CheckingAccount)
			   {			   
				   System.out.print(element.toString());	   
			   }  	   
		   }

	 }
	 
	 public static void PopulateDataFromFile()
	 {
		 try {
			 bankSystem.removeAll(bankSystem);
			 bankSystem = FileManagerAccount.readFromSerializedFile();
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
			FileManagerAccount.writeToSerializedFile(bankSystem);
			return status = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return status;
		 
	 }
	 public static boolean SearchAccount(int customerId)
	 {
		boolean flag = false;
		
		DataCollectionAccount.PopulateDataFromFile();
		
		for(IBankSystem aAccount : bankSystem)
		{
			if(aAccount instanceof CheckingAccount)
			{
				if(((CheckingAccount) aAccount).getIdentificationNumber() == customerId)
				{
					flag = true;
				}
			}
		}
		
		return flag;
	 }
	 public static boolean withdraw(int accNo, double amount) throws RaiseException
	 {
			boolean flag = false;
			
			DataCollectionAccount.PopulateDataFromFile();
			
			try
			{
				for (IBankSystem targetAcc : bankSystem)
				{
					if (targetAcc instanceof CheckingAccount) 
					{
						if (((CheckingAccount) targetAcc).getAccountNumber() == accNo) 
						{
							if (((CheckingAccount) targetAcc).getBalance() >= amount) 
							{
								double balance = ((CheckingAccount) targetAcc).getBalance();
								balance = balance - amount;
								((CheckingAccount) targetAcc).setBalance(balance);
								flag = true;
							} 
							else 
							{
								System.out.print("Insufficient Balance");
							}
	
						}
					}
					if (targetAcc instanceof SavingAccount) {
						if (((SavingAccount) targetAcc).getAccountNumber() == accNo) {
							if (((SavingAccount) targetAcc).getBalance() >= amount) 
							{
								double balance = ((SavingAccount) targetAcc).getBalance();
								balance = balance - amount;
								((SavingAccount) targetAcc).setBalance(balance);
								flag = true;
							} else {
								System.out.print("Insufficient Balance");
							}
						}
					}
					if (targetAcc instanceof CreditAccount) {
						if (((CreditAccount) targetAcc).getAccountNumber() == accNo) {
							
							double tempBal = ((CreditAccount) targetAcc).getBorrowedAmount() + amount;
							if (((CreditAccount) targetAcc).getCreditLimit() >= tempBal) 
							{
								double balance = ((CreditAccount) targetAcc).getBorrowedAmount();
								balance = balance + amount;
								((CreditAccount) targetAcc).setBorrowedAmount(balance);
								flag = true;
	
							} else {
								System.out.print("Insufficient Balance");
							}
						}
					}
				}
			}
			catch(RaiseException ex)
			{
				System.out.println(ex.getMessage());				
			}
			
			if(flag)
			{
				DataCollectionAccount.saveData();
			}
			
			return flag;

		}
	 
	 public static boolean deposite(int accNo, double amount) throws RaiseException
	 {
			boolean flag = false;
			
			DataCollectionAccount.PopulateDataFromFile();
			try
			{
				
			
				for (IBankSystem targetAcc : bankSystem)
				{
					if (targetAcc instanceof CheckingAccount) 
					{
						if (((CheckingAccount) targetAcc).getAccountNumber() == accNo) 
						{
							((CheckingAccount) targetAcc).setBalance(((CheckingAccount) targetAcc).getBalance() + amount);
							flag = true;
						}
					}
					if (targetAcc instanceof SavingAccount) {
						if (((SavingAccount) targetAcc).getAccountNumber() == accNo) 
						{
							((SavingAccount) targetAcc).setBalance(((SavingAccount) targetAcc).getBalance() + amount);
							flag = true;
						}
					}
					if (targetAcc instanceof CreditAccount) {
						if (((CreditAccount) targetAcc).getAccountNumber() == accNo) 
						{
							((CreditAccount) targetAcc).setBorrowedAmount(((CreditAccount) targetAcc).getBorrowedAmount() - amount);
							flag = true;
							
						}
					}
				}
			}
			catch(RaiseException ex)
			{
				System.out.println(ex.getMessage());				
			}
			
			if(flag)
			{
				DataCollectionAccount.saveData();
			}
			
			return flag;

		}

	 public static boolean removeAccount(int accNo)
	 {
		 DataCollectionAccount.PopulateDataFromFile();
		 
		 boolean status = false;
			boolean crestatus = false;
			boolean savestatus = false;
			
			SavingAccount deleteSaveAcc = new SavingAccount();
			CreditAccount deleteCreAcc = new CreditAccount();
			for (IBankSystem targetAcc : bankSystem)
			{
				if(targetAcc instanceof CheckingAccount) 
				{
					if(((CheckingAccount) targetAcc).getAccountNumber() == accNo)
					{
						System.out.print("Cannot close checking account");
					}

				}
				else if(targetAcc instanceof SavingAccount)
				{
					if(((SavingAccount) targetAcc).getAccountNumber() == accNo)
					{
						deleteSaveAcc = (SavingAccount) targetAcc;
						savestatus = true;
					}
					
				}
				else
				{
					if(((CreditAccount) targetAcc).getAccountNumber() == accNo)
					{
						deleteCreAcc = (CreditAccount) targetAcc;
						crestatus = true;
					}
				}
			
			}
			if(savestatus)
			{
				DataCollectionAccount.remove(deleteSaveAcc);
				status = true;
			}
			if(crestatus)
			{
				DataCollectionAccount.remove(deleteCreAcc);
				status = true;
			}
			if(status)
			{
				DataCollectionAccount.saveData();
			}
			
		return status;
	 }

}
