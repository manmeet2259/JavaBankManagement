package bus;
import java.util.*;

public class CheckingAccount extends Account {
	
	
	private Date openedDate;
	private double balance;
	private int listOfTransactions;
	
	
	public Date getOpenedDate() {
		return openedDate;
	}
	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getListOfTransactions() {
		return listOfTransactions;
	}
	public void setListOfTransactions(int listOfTransactions) {
		this.listOfTransactions = listOfTransactions;
	}
	

}
