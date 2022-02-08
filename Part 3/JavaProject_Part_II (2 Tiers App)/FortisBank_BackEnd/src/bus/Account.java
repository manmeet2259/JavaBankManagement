package bus;
import java.io.Serializable;

public abstract class Account implements IBankSystem,Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int accountNumber;
	private int identificationNumber;
	

	public Account() {
		this.accountNumber = 0;
		this.identificationNumber = 0;
	}
	public Account(int accountNumber,int identificationNumber) throws RaiseException {
		this.setAccountNumber(accountNumber);
		this.setIdentificationNumber(identificationNumber);
	}
	
	
	

	public int getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(int identificationNumber)throws RaiseException  {
		Validator.isIntPositive(identificationNumber);
		this.identificationNumber = identificationNumber;
	}
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber)throws RaiseException {
		Validator.isInRange(accountNumber);
		this.accountNumber = accountNumber;
	}
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", identificationNumber=" + identificationNumber + "]";
	}

	
	

}
