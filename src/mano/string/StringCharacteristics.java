package mano.string;

public class StringCharacteristics 
{
	
	public  static void main(String args[]) 
	{
		//match();
		matchUsingEquals();
	}
	
	/**
	 * Compare string equality with ==
	 */
	
	public static  void match() 
	{
		String str1 = "test";
		String str2 = "test";
		
		//prints true
		System.out.println(str1 == str2);
		
		str1  = "come home";
		str2 = "come " + "home";
		
		//prints true
		System.out.println(str1 == str2);
		
		//prints false
		str2 = new String("come " + "home");
		System.out.println(str1 == str2);
		
		//prints false
		str2 = new String(str1);
		System.out.println(str1 == str2);
		
		//prints false		
		str2 = "tesT";
		System.out.println(str1 == str2);
	}
	
	public static void matchUsingEquals() 
	{
		String str1  = "come home";
		String str2 = "test";
		
		//prints true
		str2 = new String("come " + "home");
		System.out.println(str1.equals(str2));
	}

}
