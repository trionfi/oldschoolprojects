/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: October 27, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: a program that will display the temperatures 0 to 20 of Celsius and their Fahrenheit equivalent
	*~*~*~*~*~*~*~* */
import java.util.Scanner; //import scanner utility

public class CelsiusFahrenheit{
	public static void main(String[] args){
		float fahrenheit, celsius; //variables for the temperatures

		System.out.print("Celsius     Fahrenheit"); //for the table
		for (int i = 0; i <= 20; i++){ //loop while i is less than or equal to 20
			celsius = i; //make celsius equal to the counter
			fahrenheit = ((9.0f / 5.0f) * celsius) + 32f; //calculate fahrenheit
			System.out.printf("\n%2.0f           %-1.1f", celsius, fahrenheit); //output results
		}
	}
}