/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: September 30, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: A program that converts a cookie recipe
	*~*~*~*~*~*~*~* */
import java.util.Scanner; //import scanner utility

public class CookieConverter{
	public static void main(String[] args){
		//declare constants to hold the amounts of the original recipe
		final float SUGAR = 1.5f;
		final float BUTTER = 1.0f;
		final float FLOUR = 2.75f;
		final float COOKIEAMOUNT = 48.0f;
		
		//declare a varible that holds the inputted amount the user wishes to make, and the variables to hold the new amounts of sugar, butter, and flour
		float cookiesToMake, convertSugar, convertButter, convertFlour;
		
		//declare variable to calculate conversion number
		float conversion;
		
		//declare variable to hold scanner input
		Scanner keyboard = new Scanner(System.in);
		
		//acquire inputted amount of cookies from user
		System.out.print("How many cookies do you wish to make?: ");
		cookiesToMake = keyboard.nextFloat();
		
		//calculate conversion value
		conversion = cookiesToMake/COOKIEAMOUNT;
		
		//convert ingredients to new amounts
		convertSugar = SUGAR * conversion;
		convertButter = BUTTER * conversion;
		convertFlour = FLOUR * conversion;
		
		//output results
		System.out.println("\nSugar: " + convertSugar + " cups"); //output sugar
		System.out.println("Butter: " + convertButter + " cups"); //output butter
		System.out.println("Flour: " + convertFlour + " cups"); //output flour
		System.out.println("Makes " + cookiesToMake + " cookies"); //output recipe yield
		
	}
}