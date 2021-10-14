/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: Febuary 09, 2016
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: sum of numbers in a string, sepeated by commas
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class CommaStringAdd{
	public static void main(String[] args){
		String str; //string variable to hold inputted string
		
		str = JOptionPane.showInputDialog("Input a string of numbers seperated by commas (no spaces):"); //acquire string
		
		String[] tokenString = str.split(","); //split string into an array, splitting at the commas
		
		int[] tokenInt = new int[tokenString.length]; //create int array to hold tokens as integers
		
		for(int i = 0; i < tokenString.length; i++){ //convert tokens to integers
			tokenInt[i] = Integer.parseInt(tokenString[i]);
		}
		
		int total = 0; //variable to hold total
		
		for(int j = 0; j < tokenInt.length; j++){ //add all integer tokens together
			total += tokenInt[j];
		}
		
		JOptionPane.showMessageDialog(null, "The total of the numbers in the string is " + total + "."); //output results
		
		System.exit(0); //exit program
	}
}