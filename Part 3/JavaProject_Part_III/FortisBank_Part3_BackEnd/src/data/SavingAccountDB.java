package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bus.RaiseException;
import bus.SavingAccount;

public class SavingAccountDB {
	static private Connection myConnection;
	static private String mySQLStatement = null;
	static private String mySQLQuery = null;
	static private Statement myStatemnt = null;
	static private ResultSet myResultSet = null;
	static private SavingAccount savAc = null;

	// generate Account number
	public static int generateAccountNumber() throws NumberFormatException, SQLException {
		int tempAccNo = 0;
		myConnection = DBConnection.getConnection();

		mySQLQuery = "select max(accountno) from savingaccount";
		
		myStatemnt = myConnection.createStatement();
		myResultSet = myStatemnt.executeQuery(mySQLQuery);

		while (myResultSet.next()) {
			tempAccNo = myResultSet.getInt(1);
		}

		if (tempAccNo == 0) {
			tempAccNo = 6000;
		} else {
			tempAccNo++;
		}

		return tempAccNo;

	}

	// Insert Saving Account
	public static int insertSavingAccount(SavingAccount savingAccount) throws SQLException {
		myConnection = DBConnection.getConnection();
		mySQLStatement = "Insert into savingaccount(accountno,customerid,balance,openingdate,extrafee,interestrate,annualgain)  values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement newSavingAccount = myConnection.prepareStatement(mySQLStatement);

			newSavingAccount.setInt(1, savingAccount.getAccountNumber());
			newSavingAccount.setInt(2, savingAccount.getIdentificationNumber());
			;
			newSavingAccount.setDouble(3, savingAccount.getBalance());
			newSavingAccount.setDate(4, (Date) savingAccount.getOpenedDate());
			newSavingAccount.setDouble(5, savingAccount.getExtraFee());
			newSavingAccount.setDouble(6, savingAccount.getAnnualInterestRate());
			newSavingAccount.setDouble(7, savingAccount.getAnnunalGain());

			int rec = newSavingAccount.executeUpdate();
			myConnection.commit();

			if (rec > 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// searchAccount
	public static SavingAccount searchSavingAccount(int id) throws SQLException, RaiseException {
		savAc = null;
		myConnection = DBConnection.getConnection();

		mySQLQuery = "SELECT * FROM savingaccount WHERE  accountno = " + id;

		myStatemnt = myConnection.createStatement();

		myResultSet = myStatemnt.executeQuery(mySQLQuery);

		if (myResultSet.next()) {
			savAc = new SavingAccount();
			savAc.setAccountNumber(myResultSet.getInt(1));
			savAc.setIdentificationNumber(myResultSet.getInt(2));
			savAc.setBalance(myResultSet.getDouble(3));
			savAc.setOpenedDate(myResultSet.getDate(4));
			savAc.setExtraFee(myResultSet.getDouble(5));
			savAc.setAnnualInterestRate(myResultSet.getDouble(6));
			savAc.setAnnunalGain(myResultSet.getDouble(7));
		}

		return savAc;

	}

	// Delete Saving Account

	public static int deleteSavingAcc(int acc) throws SQLException {
		myConnection = DBConnection.getConnection();

		mySQLStatement = "Delete FROM savingaccount WHERE accountno = " + acc;

		try {
			myStatemnt = myConnection.createStatement();
			int rowAffected = myStatemnt.executeUpdate(mySQLStatement);

			myConnection.commit();

			if (rowAffected > 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// Search By ID
	public static SavingAccount searchSavByCustomerId(int id) throws SQLException, RaiseException {

		myConnection = DBConnection.getConnection();

		mySQLQuery = "SELECT * FROM savingaccount WHERE  customerid = " + id;

		myStatemnt = myConnection.createStatement();

		myResultSet = myStatemnt.executeQuery(mySQLQuery);

		if (myResultSet.next()) {
			savAc = new SavingAccount();
			savAc.setAccountNumber(myResultSet.getInt(1));
			savAc.setIdentificationNumber(myResultSet.getInt(2));
			savAc.setBalance(myResultSet.getDouble(3));
			savAc.setOpenedDate(myResultSet.getDate(4));
			savAc.setExtraFee(myResultSet.getDouble(5));
			savAc.setAnnualInterestRate(myResultSet.getDouble(6));
			savAc.setAnnunalGain(myResultSet.getDouble(7));
		}

		return savAc;

	}
	
	public static boolean withdraw(int accountNo, double balance) throws SQLException, RaiseException
	{
		boolean status = false;
		myConnection = DBConnection.getConnection();
		
		mySQLStatement = "update savingaccount set balance = ? where accountno = ?";
		
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
		
		mySQLStatement = "update savingaccount set balance = ? where accountno = ?";
		
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
