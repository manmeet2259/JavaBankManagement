package bus;

public class CreditAccount extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double creditLimit;
	private double borrowedAmount;
	
	
	
	public CreditAccount() {
		super();
		creditLimit = 0;
		borrowedAmount = 0;
	}
	public CreditAccount(double creditLimit, double borrowedAmount, int accountNumber,int identificationNumber)throws RaiseException {
		super(accountNumber,identificationNumber);
		this.setCreditLimit(creditLimit);
		this.setBorrowedAmount(borrowedAmount);
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) throws RaiseException{
		Validator.isDoublePositive(creditLimit);
		this.creditLimit = creditLimit;
	}
	public double getBorrowedAmount() {
		return borrowedAmount;
	}
	public void setBorrowedAmount(double borrowedAmount) throws RaiseException{
		Validator.isDoublePositive(borrowedAmount);
		this.borrowedAmount = borrowedAmount;
	}

	@Override
	public String toString() {
		return super.toString() + "CreditAccount [creditLimit=" + creditLimit + ", borrowedAmount=" + borrowedAmount + "]";
	}
	
}
