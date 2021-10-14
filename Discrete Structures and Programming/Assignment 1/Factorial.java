/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: September 20, 2016
	Course: 62:206 Discrete Structures and Programming
	Instructor: Chenkuan Li
	Program: Assignment 1-5: Factorial program recussion
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class Factorial{
	public static void main(String[] args){
		long num; //input variable
		
		Scanner keyboard = new Scanner(System.in); //scanner object
		
		System.out.print("Input an integer to be multiplied factorially: ");
		num = keyboard.nextLong(); //user-inputted value
		
		System.out.println("Result: " + multiply(num)); //print out result
		
	}
	public static long multiply(long num){
		if(num > 1)
			return num * multiply(num - 1); //if num is larger than 1, multiply num by the result of the multiply method
		else
			return 1; //if num is equal to 1, return 1
		
	}
}