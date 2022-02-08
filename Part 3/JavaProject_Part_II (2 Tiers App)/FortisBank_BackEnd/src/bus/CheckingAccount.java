package bus;
import java.util.*;

public class CheckingAccount extends Account {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date openedDate;
	private double balance;
	private int numberOfTransactions;
	
	
	
	
	public CheckingAccount() {
		super();
		openedDate = new Date();
		balance = 0;
		numberOfTransactions = 0;
	}
	public CheckingAccount(Date openedDate, double balance, int numberOfTransactions, int accountNumber,int identificationNumber) throws RaiseException
	{
		super(accountNumber,identificationNumber);
		this.setOpenedDate(openedDate);
		this.setBalance(balance);
		this.setnumberOfTransactions(numberOfTransactions);
		
	}
	public Date getOpenedDate() {
		return openedDate;
	}
	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance)throws RaiseException {
		Validator.isDoublePositive(balance);
		this.balance = balance;
	}
	public int getnumberOfTransactions() {
		return numberOfTransactions;
	}
	public void setnumberOfTransactions(int numberOfTransactions) throws RaiseException{
		Validator.ValidTransCount(numberOfTransactions);
		this.numberOfTransactions = numberOfTransactions;
	}
	public String toString() {
		return  super.toString() + "CheckingAccount [openedDate=" + openedDate + ", balance=" + balance + ", numberOfTransactions="
				+ numberOfTransactions + "]";
	}

	
	
	

}
