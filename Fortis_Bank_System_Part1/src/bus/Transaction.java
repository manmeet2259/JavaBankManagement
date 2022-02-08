package bus;
import java.util.*;

public class Transaction {
	
	private int transactionNumber;
	private String description;
	private Date transactionDate;
	private EnumTransactionType transactionType;
	private double tranactionAmount;
	
	public int getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public EnumTransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(EnumTransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public double getTranactionAmount() {
		return tranactionAmount;
	}
	public void setTranactionAmount(double tranactionAmount) {
		this.tranactionAmount = tranactionAmount;
	}
	
	
	

}
