package bus;
import java.util.*;

public class Transaction {
	
	private int transactionNumber;
	private String description;
	private Date transactionDate;
	private EnumTransactionType transactionType;
	private double tranactionAmount;
	
	public Transaction(int transactionNumber, String description, Date transactionDate,
			EnumTransactionType transactionType, double tranactionAmount) {
		super();
		this.setTransactionNumber(transactionNumber);
		this.setDescription(description);
		this.setTransactionDate(transactionDate);
		this.setTransactionType(transactionType);
		this.setTranactionAmount(tranactionAmount);
	}

	public Transaction() {
		super();
		
		transactionNumber = 0;
		description = "Undefined";
		transactionDate = new Date();
		transactionType = EnumTransactionType.Undefined;
		tranactionAmount = 0;

	}


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
	
	public void storeTransaction(int accNo, double amount)
	{
		System.out.println("Transaction details saved");
	}
	
	

}
