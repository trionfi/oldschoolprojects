/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: September 30, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: A program that calculates the average of three test scores
	*~*~*~*~*~*~*~* */
import java.util.Scanner; //import scanner utility

public class TestAverage{
	
	public static void main(String[] args){
		//declare three variables to hold the test scores, and the variable to hold the average
		float testOne, testTwo, testThree, average;
	
		//declare constant of the value to divide for the average
		final float THREE = 3.0f;
	
		//declare constant to use as the scanner input
		Scanner keyboard = new Scanner(System.in);
	
		//acquire input from user
		System.out.print("Input first test score: ");
		testOne = keyboard.nextFloat(); //fill first variable
		System.out.print("Input second test score: ");
		testTwo = keyboard.nextFloat(); //fill second variable
		System.out.print("Input third test score: ");
		testThree = keyboard.nextFloat(); //fill third variable
	
		//calculate average
		average = (testOne + testTwo + testThree)/THREE;
		
		//output test scores inputted
		System.out.println("\nFirst test score: " + testOne + "\nSecond test score: " + testTwo + "\nThird test score: " + testThree);
	
		//output average
		System.out.println("----------------------");
		System.out.println("Average of test scores: " + average);
	}
}