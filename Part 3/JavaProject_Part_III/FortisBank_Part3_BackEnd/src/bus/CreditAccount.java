package bus;

import java.sql.SQLException;
import java.util.Date;

import data.CreditAccountDB;

public class CreditAccount extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double creditLimit;
	private double balance;
	private Date openedDate;
	
	
	
	public CreditAccount() {
		super();
		creditLimit = 0;
		balance = 0;
		openedDate = new Date();
	}
	public CreditAccount(double creditLimit, double balance, int accountNumber,int identificationNumber, Date date)throws RaiseException {
		super(accountNumber,identificationNumber);
		this.setCreditLimit(creditLimit);
		this.setBalance(balance);
		this.setOpenedDate(date);
	}
	
	
	
	public Date getOpenedDate() {
		return openedDate;
	}
	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) throws RaiseException{
		Validator.isDoublePositive(creditLimit);
		this.creditLimit = creditLimit;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) throws RaiseException{
		Validator.isDoublePositive(balance);
		this.balance = balance;
	}
	
	public static int getAccountNo() throws SQLException,NumberFormatException {
		return CreditAccountDB.generateAccountNumber();
	}
	public static int add(CreditAccount element) throws SQLException {
		return CreditAccountDB.insertCreditAccount(element);
	}
	public static CreditAccount search(int id) throws SQLException, NumberFormatException, RaiseException {
		return CreditAccountDB.searchCreditAccount(id);
	}
	public static int remove(int id) throws SQLException, NumberFormatException, RaiseException {
		return CreditAccountDB.deleteCreditAcc(id);
	}
	
	public static CreditAccount searchByCustomer(int id) throws SQLException, NumberFormatException, RaiseException {
		return CreditAccountDB.searchCreByCustomerId(id);
	}

	@Override
	public String toString() {
		return super.toString() + "CreditAccount [creditLimit=" + creditLimit + ", balance=" + balance + "]";
	}
	
}
