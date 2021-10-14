/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 13, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: a slot machine program
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs

public class SlotMachine{
	public static void main(String[] args){
		Random rand = new Random(); //generate random variable
		float totalSpent = 0.0f; //total money spent
		float totalWin = 0.0f; //total money won
		float payToPlay = 0.0f; //amount being paid
		float win = 0.0f; //current amount won
		String input; //string for input
		int rollOne = 6, rollTwo = 6, rollThree = 6; //variables for random integers
		final char SENTINAL = 'n'; //control sentinal constant
		char playAgain = 'y'; //sentinal variable
		int matchCount; //count amount of matches
		String outputDialog; //for formatting output dialog
		
		//constants for roll output
		final String CHERRY = "Cherry ";
		final String ORANGE = "Orange ";
		final String PLUM = "Plum ";
		final String BELL = "Bell ";
		final String MELON = "Melon ";
		final String BAR = "Bar ";
		
		while (playAgain != SENTINAL){ //while sentinal does not equal the sentinal constant
			String winOutput = ""; //reset roll output
			matchCount = 0; //reset counter
			do{ //input validation
				input = JOptionPane.showInputDialog("How much would you like to bet?");
				payToPlay = Float.parseFloat(input);
			} while (payToPlay < 0.0);
			totalSpent += payToPlay; //for keeping track of total spent
			
			rollOne = rand.nextInt((5 - 0) + 1) + 0; //roll one
			rollTwo = rand.nextInt((5 - 0) + 1) + 0; //roll two
			rollThree = rand.nextInt((5 - 0) + 1) + 0; //roll three
				
			switch (rollOne){ //figure out the string for the random number generated in the first roll
				case 0: //0 = cherry
					winOutput += CHERRY;
					break; 
				case 1: //1 = orange
						winOutput += ORANGE;
					break;
				case 2: // 2 = plum
					winOutput += PLUM;
					break;
				case 3: //3 = bell
					winOutput += BELL;
					break;
				case 4: //4 = melon
					winOutput += MELON;
					break;
				case 5: //5 = bar
					winOutput += BAR;
					break;
			}
					
			switch (rollTwo){ //figure out the string for the random variable generated for the second roll
				case 0: //0 = cherry
					winOutput += CHERRY;
					break; 
				case 1: //1 = orange
						winOutput += ORANGE;
					break;
				case 2: // 2 = plum
					winOutput += PLUM;
					break;
				case 3: //3 = bell
					winOutput += BELL;
					break;
				case 4: //4 = melon
					winOutput += MELON;
					break;
				case 5: //5 = bar
					winOutput += BAR;
					break;
			}
					
			switch (rollThree){ //figure out the string for the random variable generated for the third roll
				case 0: //0 = cherry
					winOutput += CHERRY;
					break; 
				case 1: //1 = orange
						winOutput += ORANGE;
					break;
				case 2: // 2 = plum
					winOutput += PLUM;
					break;
				case 3: //3 = bell
					winOutput += BELL;
					break;
				case 4: //4 = melon
					winOutput += MELON;
					break;
				case 5: //5 = bar
					winOutput += BAR;
					break;
			}
					
			if (rollOne == rollTwo){ //count matches
				matchCount++; //if roll one and two match
				if (rollTwo == rollThree)
					matchCount++; //if roll two and three match
			}
			else if (rollOne == rollThree) //if roll one and three match, but not two
				matchCount++;
				
			
			if (matchCount == 1){ //if there is one match
				win = payToPlay * 2; //calculate winnings, doubles amount spent
				totalWin += win;
			}
			else if (matchCount == 2){ //if all three matched
				win = payToPlay * 3; //calculate winnings, triples amount spent
				totalWin += win;
			}
			else 
				win = 0.00f;
			
			outputDialog = String.format("%s \n %d matches! You win $%,.2f.", winOutput, matchCount, win); //format spin
			
			JOptionPane.showMessageDialog(null, outputDialog);
			input = JOptionPane.showInputDialog("Would you like to try again?"); //ask if user wants to play again
			input = input.toUpperCase();
			
			switch (input){
				case "YES":
					playAgain = 'y';
					break;
				case "Y":
					playAgain = 'y';
					break;
				case "NO":
					playAgain = 'n';
					break;
				case "N":
					playAgain = 'n';
					break;
				default:
					playAgain = 'y'; //by default it will play again
			}
			
		}
		
		outputDialog = String.format("Total spent: $%,.2f \nTotal won: $%,.2f", totalWin, totalSpent);
		JOptionPane.showMessageDialog(null, outputDialog); //output total spent and total winnings
		
		System.exit(0); //exit program
	}

}