package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bus.CheckingAccount;
import bus.RaiseException;

public class CheckingAccountDB {
	static private Connection myConnection;
	static private String mySQLStatement = null;
	static private String mySQLQuery = null;
	static private Statement myStatemnt = null;
	static private ResultSet myResultSet = null;
	static private CheckingAccount chkAc = null;
	
	
	//generate Account number
	public static int generateAccountNumber() throws NumberFormatException, SQLException
	{
		int tempAccNo = 0;
		myConnection = DBConnection.getConnection();
	
		mySQLQuery = "select max(accountno) from checkingaccount";
		
		myStatemnt = myConnection.createStatement();
		myResultSet = myStatemnt.executeQuery(mySQLQuery);
		
		while(myResultSet.next()) 
		{
			tempAccNo = myResultSet.getInt(1);
		}
		if(tempAccNo == 0)
		{
			tempAccNo = 5000;
		}
		else
		{
			tempAccNo++;
		}
		
		return tempAccNo;
	
	}
	
	// Insert Checking Account
	
		public static int insertCheckingAccount(CheckingAccount aNewCheckingAccount) throws SQLException  
		{
			myConnection = DBConnection.getConnection();		
			mySQLStatement = "Insert into checkingaccount(accountno,customerid,balance,openingdate)  values(?,?,?,?)";
			
			try {
				PreparedStatement newCheckingAcc = myConnection.prepareStatement(mySQLStatement);
				
				newCheckingAcc.setInt(1, aNewCheckingAccount.getAccountNumber());
				newCheckingAcc.setInt(2, aNewCheckingAccount.getIdentificationNumber());;
				newCheckingAcc.setDouble(3, aNewCheckingAccount.getBalance());
				newCheckingAcc.setDate(4, (Date) aNewCheckingAccount.getOpenedDate());
				
				int rec = newCheckingAcc.executeUpdate();
				myConnection.commit();
					
				if(rec > 0) {
					return 1;
				}else {
					return 0;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
			
		}
		
		//Search Account
		
		public static CheckingAccount searchCheackingAccount(int id) throws SQLException, RaiseException
		{
			chkAc = null;
			myConnection = DBConnection.getConnection();
			
			mySQLQuery = "SELECT * FROM checkingaccount WHERE  accountno = " + id ;
			
			myStatemnt = myConnection.createStatement();
			
			myResultSet = myStatemnt.executeQuery(mySQLQuery);
			
			if(myResultSet.next()) {
				chkAc = new CheckingAccount();
				chkAc.setAccountNumber(myResultSet.getInt(1) );
				chkAc.setIdentificationNumber(myResultSet.getInt(2));
				chkAc.setBalance(myResultSet.getInt(3));
				chkAc.setOpenedDate(myResultSet.getDate(4));
			}	

			return chkAc;

		}
		
		// Search By ID
		public static CheckingAccount searchCheByCustomerId(int id) throws SQLException, RaiseException
		{
			myConnection = DBConnection.getConnection();
			
			mySQLQuery = "SELECT * FROM checkingaccount WHERE  customerid = " + id ;
			
			myStatemnt = myConnection.createStatement();
			
			myResultSet = myStatemnt.executeQuery(mySQLQuery);
			
			if(myResultSet.next()) {
				chkAc = new CheckingAccount();
				chkAc.setAccountNumber(myResultSet.getInt(1) );
				chkAc.setIdentificationNumber(myResultSet.getInt(2));
				chkAc.setBalance(myResultSet.getInt(3));
				chkAc.setOpenedDate(myResultSet.getDate(4));
			}	

			return chkAc;

		}
		public static boolean withdraw(int accountNo, double balance) throws SQLException, RaiseException
		{
			boolean status = false;
			myConnection = DBConnection.getConnection();
			
			mySQLStatement = "update checkingaccount set balance = ? where accountno = ?";
			
			try {
				
				PreparedStatement withdrawstmt = myConnection.prepareStatement(mySQLStatement);
				
				withdrawstmt.setDouble(1, balance);
				withdrawstmt.setInt(2, accountNo);
			
				int rec = withdrawstmt.executeUpdate();
				myConnection.commit();
					
				if(rec > 0) {
					status = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return status;

		}
		
		public static boolean deposit(int accountNo, double balance) throws SQLException, RaiseException
		{
			boolean status = false;
			myConnection = DBConnection.getConnection();
			
			mySQLStatement = "update checkingaccount set balance = ? where accountno = ?";
			
			try {
				
				PreparedStatement withdrawstmt = myConnection.prepareStatement(mySQLStatement);
				
				withdrawstmt.setDouble(1, balance);
				withdrawstmt.setInt(2, accountNo);
			
				int rec = withdrawstmt.executeUpdate();
				myConnection.commit();
					
				if(rec > 0) {
					status = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return status;

		}

}
