/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: September 20, 2016
	Course: 62:206 Discrete Structures and Programming
	Instructor: Chenkuan Li
	Program: Assignment 1-3: Birthday Paradox
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class BirthdayParadox{
	public static void main(String[] args){
		String[] testArray = new String[23]; //create a string array to hold the birthdays
		int month, day; //int variables to hold month and day random numbers
		
		int count = 0; //counter
		
		//create random object
		Random rand = new Random();
		
		for(int i = 1; i <= 10; i++){ //repeat 10 times
			for(int j = 0; j < ((testArray.length) - 1); j++){ //fill each array
				month = rand.nextInt(12 - 1) + 1; //generate month
				
				if(month == 4 || month == 6 || month == 9 || month == 11) //check if month should have 30, 31, or 28 days
					day = rand.nextInt(30 - 1) + 1;
				else if(month == 2)
					day = rand.nextInt(28 - 1) + 1;
				else
					day = rand.nextInt(31 - 1) + 1;
				
				testArray[j] = month + "\\" + day; //place month and day into array
				//System.out.println(testArray[j]);
				}
				//System.out.println(" ");
			
				if(isParadox(testArray)) //if true, incriment counter
					count++;
				
			}
			
			System.out.println("The Birthday Paradox occurs " + count + " times out of 10 sets of 23."); //output result
			
		}
	public static boolean isParadox(String[] array){
		for(int i = 0; i < ((array.length) - 2); i++){ //starting at position zero, test if any of the birthdays
			for(int j = i + 1; j < ((array.length) - 1); j++){ //are different or the same
				if(array[i].equals(array[j]))						//then add one, and continue onward
					return false; //if it finds a match, return false
			}
		}
		return true; //if no matches, return true
	}
		

}