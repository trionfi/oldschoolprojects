/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: September 28, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: A program that manipulates the name of a city
	*~*~*~*~*~*~*~* */
import java.util.Scanner; //import scanner utility

public class StringManipulator{
	public static void main(String[] args){
		String cityName, upperCityName, lowerCityName; //string input variables
		char firstCharCity; //char input variable
		int numberCityName; //int input variable
		
		Scanner inputCityName = new Scanner (System.in); // scanner variable for collecting input
		
		//get city name
		System.out.print("What is your favourite city?: ");
		cityName = inputCityName.nextLine();
		
		//convert string to uppercase and lowercase
		upperCityName = cityName.toUpperCase();
		lowerCityName = cityName.toLowerCase();
		
		//acquire first character of the name
		firstCharCity = cityName.charAt(0);
		
		//acquire length of string
		numberCityName = cityName.length();
		
		//output conversions
		System.out.println("\nName of city: " + cityName);
		System.out.println("Name of city in uppercase: " + upperCityName);
		System.out.println("Name of city in lowercase: " + lowerCityName);
		System.out.println("First letter of city: " + firstCharCity);
		System.out.println("Length of name of city: " + numberCityName);
	}
	
}