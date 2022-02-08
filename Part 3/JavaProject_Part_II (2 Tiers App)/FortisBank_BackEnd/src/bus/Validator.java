package bus;

public class Validator {
	
	//check if id is: 1111 <= value <= 9999
	public static void isInRange(int value) throws RaiseException
	{
		if( value < 1000  || value > 9999)
		{
			throw new RaiseException("invalid input; Account number must be between 1111 and 9999");
		}		
	}
	
	public static void isAlphabetic(String value) throws RaiseException
	{
		for(int i = 0 ; i != value.length() ; i++)
		{
			
			if(  !Character.isAlphabetic(value.charAt(i)))
			{
				throw new RaiseException("invalid input- value must be only alphabet letter");			
			}		
		}		
	}
	
	public static void isIntPositive(int value) throws RaiseException
	{
		if( value <= 0)
		{			
			throw new RaiseException("invalid input - Data must be positive");
			
		}
		
	}
	public static void isDoublePositive(double value) throws RaiseException
	{
		if( value < 0.0)
		{			
			throw new RaiseException("invalid input - Data must be positive");
			
		}
		
	}
	public static void sinInRange(int value) throws RaiseException
	{
		if( value < 100000  || value > 999999)
		{
			throw new RaiseException("invalid input; value must be between 100000 and 999999");
		}		
	}
	
	public static void isValidInterestRate(double value) throws RaiseException
	{
		if( value < 0.0  || value > 10)
		{
			throw new RaiseException("invalid input; Interest Rate must be between 0.0 and 10");
		}		
	}
	public static void isValidAnnunalGain(double value) throws RaiseException
	{
		if( value < 2  || value > 10)
		{
			throw new RaiseException("invalid input; Annunal Gain must be between 2 and 10");
		}		
	}
	public static void isValidExtraFee(double value) throws RaiseException
	{
		if( value < 20  || value > 100)
		{
			throw new RaiseException("invalid input; Extra Fee must be between 20 and 100");
		}		
	}
	public static void ValidTransCount(int value) throws RaiseException
	{
		if( value <= 0  || value > 4)
		{
			throw new RaiseException("invalid input; Max Transaction Limit exceeds ");
		}		
	}
	
	
	

}
