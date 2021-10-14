/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: September 20, 2016
	Course: 62:206 Discrete Structures and Programming
	Instructor: Chenkuan Li
	Program: Assignment 1-2: check for multiples of two numbers (test)
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class IsItMultiple{
	public static void main(String[] args){
		long num1, num2; //declare two long variables to hold test data
		
		//scanner object to acquire input
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter first number: "); //acquire first number
		num1 = keyboard.nextLong();
		
		System.out.println("Enter second number: "); //acquire second number
		num2 = keyboard.nextLong();
		
		System.out.println(isMultiple(num1, num2)); //output result from method
	}
	
	public static boolean isMultiple(long n, long m){
		if(n % m == 0) //modulus division, if there is no remainder, it is a multiple
			return true;
		else
			return false; //if there is a remainder, it is not a multiple
	}

}