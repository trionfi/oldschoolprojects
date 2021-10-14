/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: October 27, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: a program that will read inputted numbers and terminate if 3 consecutive negative numbers are inputted
	*~*~*~*~*~*~*~* */
import javax.swing.JOptionPane; //import dialog box class
	
public class numberAdd{
	public static void main(String[] args){
		int numberInput, total = 0, negativeCounter = 0; //variables for the inputted number, the total, and the negative number counter
		String input; //input for dialog boxes
		
		while (negativeCounter != 3){ //while the negative counter is not 3
			input = JOptionPane.showInputDialog("Please input a number. \nEnter 3 consecutive negative number to end program. \n Current total: " + total); //inputted value
			numberInput = Integer.parseInt(input); //parse to Int
			
			if (numberInput > 0){ //if the number is not negative
				total += numberInput; //calculate total
				negativeCounter = 0; //reset negative counter
			}
			else
				negativeCounter++; //count if negative
		}
		
		JOptionPane.showMessageDialog(null, "Total: " + total); //output final total
		
		System.exit(0); //exit out of program
	}
}