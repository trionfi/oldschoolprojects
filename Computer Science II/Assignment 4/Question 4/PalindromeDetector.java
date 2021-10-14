/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: March 19, 2016
	Course: 62:161 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: Palindrome detector
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class PalindromeDetector{
	public static void main(String[] args){
		String input; //for original input
		String input2; //for modified input
		try{ //@exception: incorrect input
		input = JOptionPane.showInputDialog("Enter phrase to test for palindrome-ness:"); //get input
		
		input2 = input.replaceAll("\\s", ""); //remove white spaces, commas, and put as lowercase
		input2 = input2.replaceAll(",", "");
		input2 = input2.toLowerCase();
		
		boolean palindrome = isPalindrome(input2);
		if(palindrome)
			JOptionPane.showMessageDialog(null, input + " is a palindrome.");
		else
			JOptionPane.showMessageDialog(null, input + " is NOT a palindrome.");
	
		System.exit(0);
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "Invalid input.");
		}

	}
	public static boolean isPalindrome(String p){
		StringBuilder str = new StringBuilder(p); //convert to string builder
		
		if (str.charAt(0) != str.charAt(str.length() - 1)) //if a miss match is found, return false
			return false;
		else if (str.length() == 1) //if only one character left, return true
			return true; 
		else if (str.length() == 2) //if two characters left, return true
			return true;
		else{ //else remove first and last characters, and recall method
			str.deleteCharAt(0);
			str.deleteCharAt(str.length() - 1);
			return isPalindrome(str.toString());
		}
	}
}