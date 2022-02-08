package bus;

import java.util.Date;

public class SavingAccount extends Account  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date openedDate;
	private double balance;
	private double extraFee;
	private double annualInterestRate;
	private double annunalGain;
	
	

	public SavingAccount() {
		super();
		openedDate = new Date();
		balance = 0;
		extraFee = 0;
		annualInterestRate = 0;
		annunalGain = 0;
	}
	public SavingAccount(Date openedDate, double balance, double extraFee, double annualInterestRate, 
			double annunalGain,int accountNumber,int identificationNumber) throws RaiseException
	{
		super(accountNumber,identificationNumber);
		this.openedDate = openedDate;
		this.balance = balance;
		this.extraFee = extraFee;
		this.annualInterestRate = annualInterestRate;
		this.annunalGain = annunalGain;
	}
	public Date getOpenedDate() {
		return openedDate;
	}
	public void setOpenedDate(Date openedDate){
		this.openedDate = openedDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) throws RaiseException {
		Validator.isDoublePositive(balance);
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate)throws RaiseException {
		Validator.isValidInterestRate(annualInterestRate);
		this.annualInterestRate = annualInterestRate;
	}
	public double getAnnunalGain() {
		return annunalGain;
	}
	public void setAnnunalGain(double annunalGain) throws RaiseException{
		Validator.isValidAnnunalGain(annunalGain);
		this.annunalGain = annunalGain;
	}
	public double getExtraFee() {
		return extraFee;
	}
	public void setExtraFee(double extraFee) throws RaiseException{
		Validator.isValidExtraFee(extraFee);
		this.extraFee = extraFee;
	}
	

	@Override
	public String toString() {
		return super.toString() +"SavingAccount [openedDate=" + openedDate + ", balance=" + balance + ", extraFee=" + extraFee
				+ ", annualInterestRate=" + annualInterestRate + ", annunalGain=" + annunalGain + "]";
	}
	
	

}
