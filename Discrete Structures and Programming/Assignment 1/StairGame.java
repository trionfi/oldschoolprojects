/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: September 20, 2016
	Course: 62:206 Discrete Structures and Programming
	Instructor: Chenkuan Li
	Program: Assignment 1-4: stair game
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class StairGame{
	public static void main(String[] args){
		int sentinal = 1; //test if game should continue
		int sentinal2 = 0; //test if input should loop
		int position = 50; //default position
		String input; //user input
		
		Scanner keyboard = new Scanner(System.in); //scanner input
		
		do{
			position = turn(position); //determine current position
			System.out.println("You are currently at step " + position + " out of 100. \n"); //output current position
			
			if(status(position)) //if win or lose, end game
				sentinal = 0;
			if(sentinal != 0){
				do{
					sentinal2 = 0; //reset second sentinal
					System.out.print("Do you wish to continue? Y/N:" ); //get user input
					input = keyboard.nextLine();
					
					input = input.toUpperCase(); //convert to uppercase
					//System.out.println(input);
					if(input.equals("Y")){ //game continues
						sentinal = 1;
						sentinal2 = 0;
					}
					else if(input.equals("N")){ //game ends
						sentinal = 0;
						sentinal2 = 0;
					}
					else{
						System.out.println("Incorrect input."); //unrecognized input
						sentinal2 = 1;
					}
				}while(sentinal2 != 0); //do while second sentinal is not zero, meaning input is incorrect
			}
		}while(sentinal != 0); //do while first sentinal is not 0, meaning game continues
	}
	public static int flip(){ //generate coin flip
		Random rand = new Random();
		
		return rand.nextInt(2);
	}
	public static int turn(int num){ //add or minus steps depending on coin flip
		int coin = flip();
		if(coin == 1){ //if heads
			System.out.println("\nHeads! Go up two steps.");
			num = num + 2;
		}
		else{ //if tails
			System.out.println("\nTails! Go down one step.");
			num = num - 1;
			}
		return num;
	}
	public static boolean status(int num){ //determine if win or loss
		if(num >= 100){ //win
			System.out.println("You win!");
			return true;
		}
		else if(num <= 0){ //loss
			System.out.println("You lose.");
			return true;
		}
		else //continue
			return false;
	}
}