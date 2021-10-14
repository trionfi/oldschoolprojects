/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 28, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Game of Rock, Paper, Scissors
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class RockPaperScissorsGame{
	public static void main(String[] args){
		menu(); //call menu method
		
		System.exit(0); //exit program
	}
	public static void isRock(int compNum){ //if player's choice was Rock
		compChoice(compNum); //display computer's choice
		if (compNum == 1) //if computer chose rock
			tie();
		else if (compNum == 2) //if computer chose paper
			win();
		else //if computer chose scissors
			lose();
	}
	public static void isPaper(int compNum){ //if player's choice was paper
		compChoice(compNum); //display computer's choice
		if (compNum == 1) //if computer chose rock
			win();
		else if (compNum == 2) //if computer chose paper
			tie();
		else //if computer chose scissors
			lose();
	}
	public static void isScissors(int compNum){ //if player's choice was scissors
		compChoice(compNum); //display computer's choice
		if (compNum == 1) //if computer chose rock
			lose();
		else if (compNum == 2) //if computer chose paper
			win();
		else //if computer chose scissors
			tie();
	}
	public static void compChoice(int comChoice){ //display Computer's choice
		String comp = "0";
		switch (comChoice){ //convert computer choice to a word
			case 1:
				comp = "Rock";
				break;
			case 2:
				comp = "Paper";
				break;
			case 3:
				comp = "Scissors";
				break;
		}
		
		JOptionPane.showMessageDialog(null, "Computer's Choice: " + comp); //display Computer's choice
	}
	public static void tie(){ //method so I don't have to type out results over and over
		JOptionPane.showMessageDialog(null, "Tie!");
		playAgain();
	}
	public static void win(){ //method so I don't have to type out results over and over
		JOptionPane.showMessageDialog(null, "You win!");
		playAgain();
	}
	public static void lose(){ //method so I don't have to type out results over and over
		JOptionPane.showMessageDialog(null, "You lose.");
		playAgain();
	}
	public static void playAgain(){ //play again method
		String input;
		input = JOptionPane.showInputDialog("Would you like to try again? (Y)es\\(N)o?"); //ask if user wants to play again
		input = input.toUpperCase();
		//checks for yes, no, y, and n
		switch (input){
			case "YES":
				menu();
				break;
			case "Y":
				menu();
				break;
			case "NO":
				System.exit(0);
				break;
			case "N":
				System.exit(0);
				break;
			default:
				System.exit(0); //by default it will NOT play again
			}
	}
	public static void menu(){
		Random rand = new Random(); //call the random class
		int choice = rand.nextInt(3 - 1)  + 1; //generate random number
		String input = "0";
		while (!(input.equals("4"))){ //loop if input is incorrect
			input = JOptionPane.showInputDialog("You are now playing Rock, Paper, Scissors against the computer. Choose an option:" +
											"\n1. Rock\n2.Paper\n3.Scissors");
			switch (input){
				case "1":
					isRock(choice);
					break;
				case "2":
					isPaper(choice);
					break;
				case "3":
					isScissors(choice);
					break;
				default:
					JOptionPane.showMessageDialog(null, "That is not a valid input");
			}
		
		}
	}
}