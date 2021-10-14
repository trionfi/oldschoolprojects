/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: October 12, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: A program that converts numbers to Roman Numerals
	*~*~*~*~*~*~*~* */
import javax.swing.JOptionPane; //import dialog box class

public class RomanNumerals{
	public static void main(String[] args){
		// acquire variable to hold inputted numbers, and a variable to hold the converted number or error message
		String input;
		int number;
		String output = "---";
	
		//acquire input from user
		input = JOptionPane.showInputDialog("Enter a number between 1 and 10.");
		number = Integer.parseInt(input);
		
		//determine which number was inputted and fill the output variable
		if (number == 1){ //if number is 1
			output = "I"; //then output is I
		}
		else if (number == 2){ //if number is 2
			output = "II"; //then output is II
		}
		else if (number == 3){ //if number is 3
			output = "III"; //then output is III
		}
		else if (number == 4){ //if number is 4
			output = "IV"; //then output is IV
		}
		else if (number == 5){ //if number is 5
			output = "V"; //then output is V
		}
		else if (number == 6){ //if number is 6
			output = "VI"; //then output is VI
		}
		else if (number == 7){ //if number is 7
			output = "VII"; //then output is VII
		}
		else if (number == 8){ //if number is 8
			output = "VIII"; //then output is VIII
		}
		else if (number == 9){ //if number is 9
			output = "IX"; //then output is IX
		}
		else if (number == 10){ //if number is 10
			output = "X"; //then output is X
		}
		else { //return error message
			JOptionPane.showMessageDialog(null, number + " is not a valid input."); //output error message
			
			System.exit(0); //end program
		};
		
		JOptionPane.showMessageDialog(null, number + " is represented by \"" + output + "\" in Roman Numerals."); //output conversion to Roman Numerals
		
		System.exit(0); //end program
	
	
	}
}