/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: October 18, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Calculates price of internet service 
	*~*~*~*~*~*~*~* */
import javax.swing.JOptionPane; //import dialog box class

public class InternetProvider{
	public static void main(String[] args){
		String input;
		char packageInput;
		float hours;
		float monthPrice;
		final float PACKAGEA = 9.95f;
		final int HOURSA = 10;
		final float PACKAGEB = 13.95f;
		final int HOURSB = 20;
		final float PACKAGEC = 19.95f;
		final float PACAKGEAOVER = 2.00f;
		final float PACKAGEBOVER = 1.00f;
		
		input = JOptionPane.showInputDialog("What is your package? (A, B, or C)");
		input = input.toUpperCase();
		packageInput = input.charAt(0);
		input = JOptionPane.showInputDialog("How many hours did you use your Internet service this month?");
		hours = Float.parseFloat(input);
		
		switch (packageInput){
			case 'A':
				if (hours > HOURSA)
					hours -= HOURSA;
				else
					hours = 0;
				monthPrice = PACKAGEA + (hours * PACAKGEAOVER);
				break;
			case 'B':
				if (hours > HOURSB)
					hours -= HOURSB;
				else
					hours = 0;
				monthPrice = PACKAGEB + (hours * PACKAGEBOVER);
				break;
			default:
				monthPrice = PACKAGEC;
		}
		
		JOptionPane.showMessageDialog(null, "Your monthly total is: $" + monthPrice);
		
		System.exit(0);
		
	}
}