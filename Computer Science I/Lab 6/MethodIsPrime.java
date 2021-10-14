/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 22, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: check for primeness
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class MethodIsPrime{
	public static void main(String[] args){
		boolean isItPrime = false;
		int num;
		String input;
		
		input = JOptionPane.showInputDialog("Input a number to test for prime-ness:");
		num = Integer.parseInt(input);
		
		isItPrime = isPrime(num);
		
		if (isItPrime)
			JOptionPane.showMessageDialog(null, num + " is a prime number.");
		else
			JOptionPane.showMessageDialog(null, num + " is NOT a prime number.");
		
		System.exit(0);
		}
	
	public static boolean isPrime(int num){
		
		for (int i = 2; i < num; i++){
			if (num%i == 0)
				return false;
		}
		return true;
	}
}