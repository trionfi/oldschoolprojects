/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: October 27, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: a program that calculates pennies earned per day when the ammount earned doubles each day
	*~*~*~*~*~*~*~* */
import java.util.Scanner; //import scanner utility

public class PenniesEarned{
	public static void main(String[] args){
		//scanner object to acquire input
		Scanner keyboard = new Scanner(System.in);

		int pennies = 1, days, total = 0; //variable for amount of pennies (always starting at one), inputted days, and the total
		int daysCounter, penniesCounter = 0; //variables for counting days and pennies
		float totalDollars; //for outputting in dollars

		//input validation, while days is less than 1
		do{
			System.out.print("How many days have you worked?: ");
			days = keyboard.nextInt();
		}while (days < 1);

		daysCounter = 0; //day counter needs to start at zero

		System.out.print("\nDays                Pennies Earned");

		while (daysCounter < days){ //while daysCounter is less than inputted days
			pennies = pennies + penniesCounter; //starting at one penny, and adding the same amount each day
			penniesCounter = pennies;
			total += pennies; //calculate total
			daysCounter++; //count up one
			System.out.printf("\n%3d                  %,d", daysCounter, pennies); //output data
		}

		totalDollars = (float) total / 100.0f; //convert to dollars

		System.out.printf("\nThe total pay: $%,.2f", totalDollars); //output total


	}
}