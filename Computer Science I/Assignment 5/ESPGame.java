/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 28, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: ESP game
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class ESPGame{
	public static void main(String[] args){
		getAnswers(); //get user input
		
		System.exit(0); //end program
	}
	public static int random(){ //generate a random number
		Random rand = new Random();
		int num = rand.nextInt(5) + 1;
		return num; //return random number
	}
	public static void getAnswers(){
		int userInput;
		int computerInput;
		int counter = 0;
		for (int i = 1; i <= 10; i++){
			userInput = acquireInput(); //acquire user input
			computerInput = random(); //acquire random number
			displayCompChoice(computerInput);
			if (compareAnswer(userInput, computerInput)) //compare answers
				counter++; //count up if anwsers match
		}
		displayResults(counter); //display results
		
	}
	public static boolean compareAnswer(int user, int comp){
		return (user == comp) ? true : false; //check if inputs match
	}
	public static String choiceText(int num){ //convert number to text
		switch (num){
			case 1:
				return "Red";
			case 2:
				return "Green";
			case 3:
				return "Blue";
			case 4:
				return "Orange";
			case 5:
				return "Yellow";
		}
		return "something is very wrong1";
	}
	public static void displayCompChoice(int num){
		String result = choiceText(num);
		JOptionPane.showMessageDialog(null, "Computer Choice: " + result); //display computer's choice
	}
	public static void displayResults(int result){
		JOptionPane.showMessageDialog(null, "You guessed " + result + " right."); //display ending results
	}
	public static int acquireInput(){ //acquire user input
		String input;
		int numInput;
		input = JOptionPane.showInputDialog("This program tests your extrasensory perception (ESP) abilities. Pick a number corresponding to a letter: " +
											"\n1. Red\n2. Green\n3. Blue\n4. Orange\n5. Yellow");
		numInput = Integer.parseInt(input);
		return numInput; //return user input
	}
}