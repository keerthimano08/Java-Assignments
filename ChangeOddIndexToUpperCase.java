package week3.day2;

import java.util.Arrays;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		
		 /* Declare String Input as Follow
		 * String test = "changeme";
		 * a) Convert the String to character array
		 * b) Traverse through each character (using loop)
		 * c)find the odd index within the loop (use mod operator)
		 * d)within the loop, change the character to uppercase, if the index is odd else don't change
		 */
		String test = "changeme";
		
		char[] charArray = test.toCharArray();
		
		String odd="";
		
		for(int i=0;i<charArray.length;i++) {
			
			if(i%2==0) {
				odd=Character.toString(test.charAt(i));
				System.out.print(odd.toUpperCase()); 
			}else {
			System.out.print(charArray[i]); 
		}
		//System.out.println(odd.toUpperCase());
	}
		
	}}

