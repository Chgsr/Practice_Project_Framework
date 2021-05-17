package com.automation.scripts;

public class StringTest {

	
	public static void main(String[] args) {
		
		String Str= "Guna Shekar Reddy 9392705090";
		int sum=0;
		
		char[] Str1=Str.toCharArray();
		
		for(char SD:Str1)
		{
			if(Character.isDigit(SD))
			{
				int val=Character.getNumericValue(SD);
				sum= sum+val;
			}
		}
		System.out.println(sum);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//String Reverse="";
		
		/*
		 * char[] CH= Str.toCharArray();
		 * 
		 * for(char D:CH) { char S=CH. Reverse= Reverse+S; }
		 * 
		 * System.out.println(Reverse);
		 * 
		 * 
		 */
		
		
		/*
		 * char[] CH= Str.toCharArray();
		 * 
		 * for(int i=Str.length()-1; i>=0; i--) { char N=Str.charAt(i); Reverse=
		 * Reverse+N; }
		 * 
		 * System.out.println(Reverse);
		 */
		
		
		/*
		 * StringBuffer SB= new StringBuffer(Str);
		 * 
		 * StringBuffer R=SB.reverse();
		 * 
		 * System.out.println(R);
		 */
		
		/*String Str1= new String("Reddy");
		
		System.out.println(Str+"**************"+Str1);
		
		System.out.println(Str.hashCode());
		System.out.println(Str1.hashCode());
		
		
		
	String S=	Str.concat(" Shekar");
	
	if(Str==S)
	{
		System.out.println("True");
	}
	else {
		System.out.println(S);
	}
	
	System.out.println(Str.hashCode()+"**************"+S.hashCode());
		
	}*/

}
}
