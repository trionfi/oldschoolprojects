/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: September 20, 2016
	Course: 62:206 Discrete Structures and Programming
	Instructor: Chenkuan Li
	Program: Assignment 1-1: check if all numbers in an array are unique
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class CheckUnique{
	public static void main(String[] args){
		
		int[] array = {3, 4, 6, 7, 2, 8, 15, 1, 9}; //test array
		
		System.out.println(isUnique(array)); //output result
		
	}
	
	public static boolean isUnique(int[] array){ //import array into method to test if all numbers are unique
		for(int i = 0; i < ((array.length) - 2); i++){ //starting at position zero, test if any of the numbers
			for(int j = i + 1; j < ((array.length) - 1); j++){ //are different or the same
				if(array[i] == array[j])						//then add one, and continue onward
					return false; //if it finds a match, return false
			}
		}
		
		return true; //if no matches, return true
		
	}

}