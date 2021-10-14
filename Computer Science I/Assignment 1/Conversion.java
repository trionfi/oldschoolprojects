/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: September 27, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: A program that calculates the monitary composition of an amount of money
	*~*~*~*~*~*~*~* */
import java.util.Scanner; //import scanner utility

public class Conversion{
	public static void main(String[] args){
		//constants for the amount each value of currecy is equal
		final int DOLLAR = 100;
		final int QUARTER = 25;
		final int DIME = 10;
		final int NICKEL = 5;
		final int PENNY = 1;
		
		//variables to hold inputted money, and money converted to cents only
		double inputMoney;
		int moneyAsCents;
		
		//variables to hold each amount of dollar, quarters, dimes, nickels, and pennies, as well as remainders
		int dollars, quarters, dimes, nickels, pennies;
		int dollarRemainder, quarterRemainder, dimeRemainder, nickelRemainder;
		
		//scanner object to acquire input
		Scanner keyboard = new Scanner(System.in);
		
		//acquire currency input from user
		System.out.print("How much money do you have?: $");
		inputMoney = keyboard.nextDouble();
		
		//convert currency to cents
		moneyAsCents = (int)(inputMoney * 100); //convert to int as well
		
		//convert cents to 1 dollar increments and find the remaining cents
		dollars = moneyAsCents/DOLLAR;
		dollarRemainder = moneyAsCents % DOLLAR;
		
		//convert remainder into quarters and obtain remainders
		quarters = dollarRemainder/QUARTER;
		quarterRemainder = dollarRemainder % QUARTER;
		
		//convert remainder into dimes and obtain remainder
		dimes = quarterRemainder/DIME;
		dimeRemainder = quarterRemainder % DIME;
		
		//convert remainder into nickels and obtain remainder
		nickels = dimeRemainder/NICKEL;
		nickelRemainder = dimeRemainder % NICKEL;
		
		//convert remainder to pennies
		pennies = nickelRemainder/PENNY;
		
		//output results
		System.out.println("\n$" + inputMoney + " is equivalent to " + dollars + " dollars, " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, and " + pennies + " pennies.");
	}
}