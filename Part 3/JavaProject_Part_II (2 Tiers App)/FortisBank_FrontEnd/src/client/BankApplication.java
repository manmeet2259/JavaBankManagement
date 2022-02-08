package client;


import java.util.Date;
import java.util.Scanner;

import bus.*;

public class BankApplication {

	public static void main(String[] args) {

		int identificationNumber=0,  accNo;
		double  amount;
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int option;

		do {
			option = 0;
			while (option <= 0 || option > 9) {
				System.out.flush();
				displayMenu();
				option = scan.nextInt();
			}

			switch (option) {
			case 1: // Add a new customer
				
				boolean valid = false;

				Customer customer = new Customer();
				CheckingAccount chkAcc = new CheckingAccount();
				
				do
				{
					try
					{
						System.out.print("Customer Identification Number: ");
						customer.setIdentificationNumber(scan.nextInt());
						valid =  true;				
					}
					catch(RaiseException ex)
					{
						System.out.println(ex.getMessage());				
					}	
				}while(!valid);
				
				valid = false;
				do
				{
					try
					{
						System.out.print("Customer Name : ");
						customer.setName(scan.next());
						valid =  true;				
					}
					catch(RaiseException ex)
					{
						System.out.println(ex.getMessage());				
					}	
				}while(!valid);
				

				valid = false;
				do
				{
					try
					{
						System.out.print("Customer Social Insurance Number : ");
						customer.setSin(scan.nextInt());
						valid =  true;				
					}
					catch(RaiseException ex)
					{
						System.out.println(ex.getMessage());				
					}	
				}while(!valid);



				System.out.println(
						"It is required to open a checking account. Please enter the details to open an account : ");
				
				valid = false;
				do
				{
					try
					{
						System.out.print("Enter Account Number : ");
						chkAcc.setAccountNumber(scan.nextInt());
						valid =  true;				
					}
					catch(RaiseException ex)
					{
						System.out.println(ex.getMessage());				
					}	
				}while(!valid);
				


				DataCollectionCustomer.PopulateDataFromFile();
				DataCollectionCustomer.add(customer);
				if(DataCollectionCustomer.saveData())
				{
					System.out.println("Customer added successfully");
				}

				DataCollectionAccount.PopulateDataFromFile();
				DataCollectionAccount.add(chkAcc);
				if(DataCollectionAccount.saveData())
				{
					System.out.println("Checking account opened successfully");
				}

				System.out.print(
						"Welcome " + customer.getName() + " for choosing Fortis Banking Network. \nYour Account details are as : ");

				break;

			case 2: // Open a saving account
				
				SavingAccount savAcc = new SavingAccount();
				DataCollectionAccount.PopulateDataFromFile();
				
				valid = false;
				do
				{
					try
					{
						System.out.print("Enter Customer's Checking account Number : ");
						identificationNumber = scan.nextInt();
						savAcc.setIdentificationNumber(identificationNumber);
						savAcc.setBalance(0);
						valid =  true;				
					}
					catch(RaiseException ex)
					{
						System.out.println(ex.getMessage());				
					}	
				}while(!valid);

				
				
				if (DataCollectionAccount.search(identificationNumber) != null) 
				{
		
					savAcc.setOpenedDate(new Date());
					
					
					valid = false;
					do
					{
						try
						{
							System.out.print("Enter Saving Account Number :");
							savAcc.setAccountNumber(scan.nextInt());
							valid =  true;				
						}
						catch(RaiseException ex)
						{
							System.out.println(ex.getMessage());				
						}	
					}while(!valid);
					
					
					valid = false;
					do
					{
						try
						{
							System.out.print("Enter any extra fee :");
							savAcc.setExtraFee(scan.nextDouble());
							valid =  true;				
						}
						catch(RaiseException ex)
						{
							System.out.println(ex.getMessage());				
						}	
					}while(!valid);
					
					valid = false;
					do
					{
						try
						{
							System.out.print("Enter Annual Interest Rate");
							savAcc.setAnnualInterestRate(scan.nextDouble());
							valid =  true;				
						}
						catch(RaiseException ex)
						{
							System.out.println(ex.getMessage());				
						}	
					}while(!valid);
					
					valid = false;
					do
					{
						try
						{
							System.out.print("Enter Annual Gain");
							savAcc.setAnnunalGain(scan.nextDouble());
							valid =  true;				
						}
						catch(RaiseException ex)
						{
							System.out.println(ex.getMessage());				
						}	
					}while(!valid);
					

					DataCollectionAccount.add(savAcc);
					if(DataCollectionAccount.saveData())
					{
						System.out.print("Saving Account is opened successfully. Your Account details are as : ");
						System.out.print(savAcc.toString());
					}

				} else {
					System.out.print("A customer must have a checking account to open a saving account");
				}

				break;

			case 3: // Open a Credit Account
				
				DataCollectionAccount.PopulateDataFromFile();
				CreditAccount creAcc = new CreditAccount();
				
				valid = false;
				do
				{
					try
					{
						System.out.print("Enter Customer's Checking account Number : ");
						identificationNumber = scan.nextInt();
						creAcc.setIdentificationNumber(identificationNumber);
						valid =  true;				
					}
					catch(RaiseException ex)
					{
						System.out.println(ex.getMessage());				
					}	
				}while(!valid);

				if (DataCollectionAccount.SearchAccount(identificationNumber)) {


					valid = false;
					do
					{
						try
						{
							System.out.print("Enter credit Account Number :");
							creAcc.setAccountNumber(scan.nextInt());
							valid =  true;				
						}
						catch(RaiseException ex)
						{
							System.out.println(ex.getMessage());				
						}	
					}while(!valid);
					
					
					valid = false;
					do
					{
						try
						{
							System.out.print("Enter Credit Limit :");
							creAcc.setCreditLimit(scan.nextDouble());
							valid =  true;				
						}
						catch(RaiseException ex)
						{
							System.out.println(ex.getMessage());				
						}	
					}while(!valid);
					
					try {
						creAcc.setBorrowedAmount(0.0);
					} catch (RaiseException e) {
						System.out.println(e.getMessage());
					}

					

					

					DataCollectionAccount.add(creAcc);
					if(DataCollectionAccount.saveData())
					{
						System.out.print("Credit Account is opened successfully. Your Account details are as : ");
						System.out.print(creAcc.toString());
					}

				} else {
					System.out.print("A customer must have a checking account to open a credit account");
				}

				break;
			case 4: // Withdraw Money

				
				System.out.print("Enter Account Number : ");
				accNo = scan.nextInt();
				System.out.print("Enter Amount : ");
				amount = scan.nextDouble();
				
				
				try {
					if(DataCollectionAccount.withdraw(accNo, amount))
					{
						DataCollectionAccount.saveData();
						System.out.print("Withdraw Success");
					}
					else
					{
						System.out.print("Account not found");
					}
				} catch (RaiseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 5: // Deposit Money
				System.out.print("Enter Account Number : ");
				accNo = scan.nextInt();
				System.out.print("Enter Amount : ");
				amount = scan.nextDouble();
				try {
					if(DataCollectionAccount.deposite(accNo, amount))
					{
						DataCollectionAccount.saveData();
						System.out.print("Deposite Success");
					}
					else
					{
						System.out.print("Account not found");
					}
				} catch (RaiseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 6: // Transfer Money

				//deduction sender account
				int senderAccNo, receiverAccNo;
				System.out.print("Enter Sender Account Number : ");
				senderAccNo = scan.nextInt();
				System.out.print("Enter Receiver Account Number : ");
				receiverAccNo = scan.nextInt();
				System.out.print("Enter Amount : ");
				amount = scan.nextDouble();
				
				boolean trnStatus = false;
				
				try 
				{
					if(DataCollectionAccount.withdraw(senderAccNo, amount))
					{
						trnStatus = true;
					}
				
					if(trnStatus)
					{
						if(DataCollectionAccount.deposite(receiverAccNo, amount))
						{
							System.out.print("Transfer Success");	
						}
					}
				} catch (RaiseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
						
				break;
			case 7: // Close an Account
				System.out.print("Enter Account Number : ");
				accNo = scan.nextInt();
				
				if(DataCollectionAccount.removeAccount(accNo))
				{
					System.out.print("Account Deleted");
				}
				else
				{
					System.out.print("Account Not Found.");
				}
	
				break;
			
			case 8:
				System.out.println("---------List Of All Customers---------");
				DataCollectionCustomer.print();
				System.out.println("---------List Of All Accounts---------");
				DataCollectionAccount.print();

				break;
			case 9:
				System.out.println("Thanks for using Fortis Bank. Have a nice day");
				System.exit(0);
				break;
			
			}


		} while (true);
	}

	public static void displayMenu() {
		System.out.println("\n-------------Welcome to Fortis Bank---------------");
		System.out.println("1. Add a new customer");
		System.out.println("2. Open a Saving Account");
		System.out.println("3. Open a Credit Account");
		System.out.println("4. Withdraw Money");
		System.out.println("5. Deposit Money");
		System.out.println("6. Transfer Money");
		System.out.println("7. Close an Account");
		System.out.println("8. Display all customers.");
		System.out.println("9. Exit");
		System.out.println("\nPlease enter an option : ");

	}

}

/*
----------------------Output------------------------------- 

-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
1
Customer Identification Number: 333333
Customer Name : Manmeet12
invalid input- value must be only alphabet letter
Customer Name : Manmeet
Customer Social Insurance Number : 12
invalid input; value must be between 100000 and 999999
Customer Social Insurance Number : 333333
It is required to open a checking account. Please enter the details to open an account : 
Enter Account Number : -15
invalid input; Account number must be between 1111 and 9999
Enter Account Number : 2000
Customer added successfully
Checking account opened successfully
Welcome Manmeet for choosing Fortis Banking Network. 
Your Account details are as : 
-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
8
---------List Of All Customers---------
Customer ID : 101 Name : Manpreet Personal Identification Number : 111111
Customer ID : 102 Name : Jaskaran Personal Identification Number : 222222
Customer ID : 333333 Name : Manmeet Personal Identification Number : 333333
---------List Of All Accounts---------
Account [accountNumber=7147, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 19:47:03 EST 2021, balance=2000.0, numberOfTransactions=0]
Account [accountNumber=7148, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 19:48:02 EST 2021, balance=6000.0, numberOfTransactions=0]
Account [accountNumber=2000, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 20:02:57 EST 2021, balance=0.0, numberOfTransactions=0]

-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
2
Enter Customer's Checking account Number : 2222
A customer must have a checking account to open a saving account
-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
2
Enter Customer's Checking account Number : 2000
Enter Saving Account Number :2001
Enter any extra fee :10
invalid input; Extra Fee must be between 20 and 100
Enter any extra fee :20
Enter Annual Interest Rate-10
invalid input; Interest Rate must be between 0.0 and 10
Enter Annual Interest Rate2
Enter Annual Gain2.5
Saving Account is opened successfully. Your Account details are as : Account [accountNumber=2001, identificationNumber=2000]SavingAccount [openedDate=Wed Nov 24 20:04:21 EST 2021, balance=0.0, extraFee=20.0, annualInterestRate=2.0, annunalGain=2.5]
-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
8
---------List Of All Customers---------
Customer ID : 101 Name : Manpreet Personal Identification Number : 111111
Customer ID : 102 Name : Jaskaran Personal Identification Number : 222222
Customer ID : 333333 Name : Manmeet Personal Identification Number : 333333
---------List Of All Accounts---------
Account [accountNumber=7147, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 19:47:03 EST 2021, balance=2000.0, numberOfTransactions=0]
Account [accountNumber=7148, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 19:48:02 EST 2021, balance=6000.0, numberOfTransactions=0]
Account [accountNumber=2000, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 20:02:57 EST 2021, balance=0.0, numberOfTransactions=0]
Account [accountNumber=2001, identificationNumber=2000]SavingAccount [openedDate=Wed Nov 24 20:04:21 EST 2021, balance=0.0, extraFee=20.0, annualInterestRate=2.0, annunalGain=2.5]

-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
5
Enter Account Number : 2000
Enter Amount : 5000
Deposite Success
-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
8
---------List Of All Customers---------
Customer ID : 101 Name : Manpreet Personal Identification Number : 111111
Customer ID : 102 Name : Jaskaran Personal Identification Number : 222222
Customer ID : 333333 Name : Manmeet Personal Identification Number : 333333
---------List Of All Accounts---------
Account [accountNumber=7147, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 19:47:03 EST 2021, balance=2000.0, numberOfTransactions=0]
Account [accountNumber=7148, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 19:48:02 EST 2021, balance=6000.0, numberOfTransactions=0]
Account [accountNumber=2000, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 20:02:57 EST 2021, balance=5000.0, numberOfTransactions=0]
Account [accountNumber=2001, identificationNumber=2000]SavingAccount [openedDate=Wed Nov 24 20:04:21 EST 2021, balance=0.0, extraFee=20.0, annualInterestRate=2.0, annunalGain=2.5]

-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
4
Enter Account Number : 7145
Enter Amount : 2000
Account not found
-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
4
Enter Account Number : 7148
Enter Amount : 8000
Insufficient BalanceAccount not found
-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
4
Enter Account Number : 7148
Enter Amount : 1000
Withdraw Success
-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
8
---------List Of All Customers---------
Customer ID : 101 Name : Manpreet Personal Identification Number : 111111
Customer ID : 102 Name : Jaskaran Personal Identification Number : 222222
Customer ID : 333333 Name : Manmeet Personal Identification Number : 333333
---------List Of All Accounts---------
Account [accountNumber=7147, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 19:47:03 EST 2021, balance=2000.0, numberOfTransactions=0]
Account [accountNumber=7148, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 19:48:02 EST 2021, balance=5000.0, numberOfTransactions=0]
Account [accountNumber=2000, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 20:02:57 EST 2021, balance=5000.0, numberOfTransactions=0]
Account [accountNumber=2001, identificationNumber=2000]SavingAccount [openedDate=Wed Nov 24 20:04:21 EST 2021, balance=0.0, extraFee=20.0, annualInterestRate=2.0, annunalGain=2.5]

-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
6
Enter Sender Account Number : 2000
Enter Receiver Account Number : 7147
Enter Amount : 8000
Insufficient Balance
-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
8
---------List Of All Customers---------
Customer ID : 101 Name : Manpreet Personal Identification Number : 111111
Customer ID : 102 Name : Jaskaran Personal Identification Number : 222222
Customer ID : 333333 Name : Manmeet Personal Identification Number : 333333
---------List Of All Accounts---------
Account [accountNumber=7147, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 19:47:03 EST 2021, balance=2000.0, numberOfTransactions=0]
Account [accountNumber=7148, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 19:48:02 EST 2021, balance=5000.0, numberOfTransactions=0]
Account [accountNumber=2000, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 20:02:57 EST 2021, balance=5000.0, numberOfTransactions=0]
Account [accountNumber=2001, identificationNumber=2000]SavingAccount [openedDate=Wed Nov 24 20:04:21 EST 2021, balance=0.0, extraFee=20.0, annualInterestRate=2.0, annunalGain=2.5]

-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
6
Enter Sender Account Number : 2000
Enter Receiver Account Number : 7147
Enter Amount : 1000
Transfer Success
-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
8
---------List Of All Customers---------
Customer ID : 101 Name : Manpreet Personal Identification Number : 111111
Customer ID : 102 Name : Jaskaran Personal Identification Number : 222222
Customer ID : 333333 Name : Manmeet Personal Identification Number : 333333
---------List Of All Accounts---------
Account [accountNumber=7147, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 19:47:03 EST 2021, balance=3000.0, numberOfTransactions=0]
Account [accountNumber=7148, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 19:48:02 EST 2021, balance=5000.0, numberOfTransactions=0]
Account [accountNumber=2000, identificationNumber=0]CheckingAccount [openedDate=Wed Nov 24 20:02:57 EST 2021, balance=4000.0, numberOfTransactions=0]
Account [accountNumber=2001, identificationNumber=2000]SavingAccount [openedDate=Wed Nov 24 20:04:21 EST 2021, balance=0.0, extraFee=20.0, annualInterestRate=2.0, annunalGain=2.5]

-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
7
Enter Account Number : 2000
Cannot close checking account
-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
7
Enter Account Number : 2001
Account Deleted
-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 
7
Enter Account Number : 2556
Account Not Found.

-------------Welcome to Fortis Bank---------------
1. Add a new customer
2. Open a Saving Account
3. Open a Credit Account
4. Withdraw Money
5. Deposit Money
6. Transfer Money
7. Close an Account
8. Display all customers.
9. Exit

Please enter an option : 

9
Thanks for using Fortis Bank. Have a nice day






  */
