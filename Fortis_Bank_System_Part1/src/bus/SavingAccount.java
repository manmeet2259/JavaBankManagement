package bus;

import java.util.Date;

public class SavingAccount extends Account  {
	
	private Date openedDate;
	private double balance;
	private double extraFee;
	private double annualInterestRate;
	private double annunalGain;
	
	
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
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public double getAnnunalGain() {
		return annunalGain;
	}
	public void setAnnunalGain(double annunalGain) {
		this.annunalGain = annunalGain;
	}
	public double getExtraFee() {
		return extraFee;
	}
	public void setExtraFee(double extraFee) {
		this.extraFee = extraFee;
	}
	
	

}
