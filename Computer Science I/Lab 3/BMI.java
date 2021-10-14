/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: October 18, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Calculates and displays BMI
	*~*~*~*~*~*~*~* */
import javax.swing.JOptionPane; //import dialog box class

public class BMI{
	public static void main(String[] args){
		//variables
		float weight, height;
		float bmiCalculate;
		String input;
		String optimal = "optimal";

		//input
		input = JOptionPane.showInputDialog("What is your weight in pounds?");
		weight = Float.parseFloat(input);
		input = JOptionPane.showInputDialog("What is your height in inches?");
		height = Float.parseFloat(input);
		
		//calculate bmi
		bmiCalculate = (float)((weight * 703.0) / Math.pow(height, 2));
		
		//figure out if optimal, overweight, or underweight
		optimal = (bmiCalculate > 25.0) ? "overweight" : optimal;
		optimal = (bmiCalculate < 18.5) ? "underweight" : optimal;
		
		//output
		JOptionPane.showMessageDialog(null, "Your BMI is " + bmiCalculate + 
											". This is considered " + optimal + ".");
		//exit
		System.exit(0);
	
	}
}