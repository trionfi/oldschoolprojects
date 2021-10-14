/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: October 12, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: A program that converts a cookie recipe, now with dialog boxes
	*~*~*~*~*~*~*~* */
import javax.swing.JOptionPane; //import dialog box class

public class CookieConverter{
	public static void main(String[] args){
		//declare constants to hold the amounts of the original recipe
		final float SUGAR = 1.5f;
		final float BUTTER = 1.0f;
		final float FLOUR = 2.75f;
		final float COOKIEAMOUNT = 48.0f;
		
		//declare a varible that holds the inputted amount the user wishes to make, and the variables to hold the new amounts of sugar, butter, and flour
		float cookiesToMake, convertSugar, convertButter, convertFlour;
		
		//declare string variable to hold input from dialog boxes to be converted to numbers later
		String input;
		
		//declare variable to calculate conversion number
		float conversion;
		
		//acquire inputted amount of cookies from user
		input = JOptionPane.showInputDialog("How many cookies do you wish to make?");
		cookiesToMake = Float.parseFloat(input);
		
		//calculate conversion value
		conversion = cookiesToMake/COOKIEAMOUNT;
		
		//convert ingredients to new amounts
		convertSugar = SUGAR * conversion;
		convertButter = BUTTER * conversion;
		convertFlour = FLOUR * conversion;
		
		//output results
		JOptionPane.showMessageDialog(null, "Sugar: " + convertSugar + " cups" + //output sugar
											"\nButter: " + convertButter + " cups" + //output butter
											"\nFlour: " + convertFlour + " cups" + //output flour
											"\nMakes " + cookiesToMake + " cookies"); //output recipe yield

		//end program
		System.exit(0);
		
	}
}