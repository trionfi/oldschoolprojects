/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: September 28, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: A program that calculates tax and tip
	*~*~*~*~*~*~*~* */
import java.util.Scanner; //import scanner utility

public class TaxAndTip{
	public static void main(String[] args){
		//declare constants of percent of tax and tip
		final double TAX = 0.0675;
		final double TIP = 0.2;
		
		//declare variables to hold the bill, tax, and tip
		double bill, taxAmount, tipAmount, total, convertTax, convertTip;
		
		//declare variable for the scanner input
		Scanner inputBill = new Scanner (System.in);
		
		//acquire bill amount
		System.out.print("What is your bill?: $");
		bill = inputBill.nextDouble();
		
		//calculate tax, and convert to 2 decimals
		taxAmount = bill * TAX;
		convertTax = Math.round(taxAmount * 100.0);
		convertTax = convertTax/100;
		
		//calculate tip, and convert to 2 decimals
		tipAmount = bill * TIP;
		convertTip = Math.round(tipAmount * 100.0);
		convertTip = convertTip/100;
		
		//calculate total
		total = bill + convertTax + convertTip;
		
		//output calculations
		System.out.println("\nTax: $" + convertTax);
		System.out.println("Tip: $" + convertTip);
		System.out.println("Total: $" + total);
	}

}