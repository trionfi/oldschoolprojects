/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: September 21, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: A program that will display my personal information
	*~*~*~*~*~*~*~* */
import java.util.*; //standard import statement that will be useful later in the course
	
public class PersonalInformation //beginning statements
{
	public static void main(String[] args)
	{
		// declare varibales to hold personal information 
		//(i am aware i don't have to do this, but it makes more sense in my head)
		// I am also filling the variables as they are declared, as they are static variables
		String name = new String("Alexandra Paramor");
		String address = new String("3-245 12th Street\n\t Brandon, MB\n\t R7A 4L9");
		String telephoneNumber = new String("1-306-740-8273");
		String major = new String("Computer Science");
		
		// outputting the string variables with the required formatting 
		//(each new piece of information on it's own line)
		System.out.print("Name: " + name + "\nAddress: " + address + "\nTelephone Number: " + telephoneNumber + "\nMajor: " + major);
		
		//end of program
		}
}