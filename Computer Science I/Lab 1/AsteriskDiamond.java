/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: September 21, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: A program that will make a diamond made of asterisks
	*~*~*~*~*~*~*~* */
import java.util.*; //standard import statement that will be useful later in the course

public class AsteriskDiamond
{
	public static void main(String[] args)
	{
		//declaring string variables so I don't have to type out as many asterisks
		String oneStar = new String("\n      *");
		String threeStar = new String("\n    ***");
		String fiveStar = new String("\n  *****");
		String sevenStar = new String("\n*******");
		
		//outputting the asterisks into a diamond pattern using /n's
		System.out.print(oneStar + threeStar + fiveStar + sevenStar + fiveStar + threeStar + oneStar);
		
		//end of program
	}
}