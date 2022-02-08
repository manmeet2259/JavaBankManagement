package bus;

import java.io.Serializable;


public class Customer implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int identificationNumber;
	private String name;
	private int sin;
	
	
	public Customer(int identificationNumber, String name, int sin)throws RaiseException {
		this.setIdentificationNumber(identificationNumber);
		this.setName(name);
		this.setSin(sin);
	}
	
	public Customer() {
		this.identificationNumber = 0;
		this.name = "Undefined";
		this.sin = 0;
	}

	public int getIdentificationNumber() {
		return identificationNumber;
	}
	public int getSin() {
		return sin;
	}
	public String getName() {
		return name;
	}
	
	
	public void setIdentificationNumber(int identificationNumber)throws RaiseException {
		Validator.isIntPositive(identificationNumber);
		this.identificationNumber = identificationNumber;
	}
	
	public void setName(String name) throws RaiseException{
		Validator.isAlphabetic(name);
		this.name = name;
	}
	
	public void setSin(int sin)throws RaiseException {
		Validator.sinInRange(sin);
		this.sin = sin;
	}

	@Override
	public String toString() {
		String str =  "Customer ID : "+ identificationNumber + " Name : " + name + " Personal Identification Number : "+ sin;
		return str;
	}
	
	
	

}
