/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 22, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: calculate present value
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class CalculatePresentValue{
	public static void main(String[] arge){
		double futureValue, annIntRate, years;
		double result;
		String input;
		
		input = JOptionPane.showInputDialog("Input the total amount of money you wish to gain from interest: ");
		futureValue = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Input Annual Interest Rate (in percentage): ");
		annIntRate = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Input number of years you will let the money sit in savings: ");
		years = Double.parseDouble(input);
		
		result = presentValue(futureValue, annIntRate, years);
		
		String output = String.format("You will need to deposit $%.2f to obtain $%.2f after %.0f years.", result, futureValue, years);
		JOptionPane.showMessageDialog(null, output);
		
		System.exit(0);
	}
	
	public static double presentValue(double f, double r, double n){
		r = r / 100;
		double pValue = f / (Math.pow((1 + r), n));
		
		return pValue;
	}
}