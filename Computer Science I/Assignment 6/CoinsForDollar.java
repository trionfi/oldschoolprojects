/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: December 08, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: coin toss simulator
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class CoinsForDollar{
	public static void main(String[] args){
		int amount = 0; //variable to hold values
		String output; //output variable
		Coin quarter = new Coin(); //quarter object
		Coin dime = new Coin(); //dime object
		Coin nickel = new Coin(); //nickel object
		
		while (amount < 100){ //repeat while less than 100 cents
			quarter.toss(); //toss quarter
			if (quarter.getSideUp() == "Heads"){ //if heads
				if (!(amount <= 100)) //if amount is not 100
					amount += 25; //add 25 cents
				//System.out.println(amount);
			}
			dime.toss(); //toss dime
			if (dime.getSideUp() == "Heads"){ //if heads
				if (!(amount <= 100)) //if amount is not 100
					amount += 10; //add 10 cents
				//System.out.println(amount);
			}
			nickel.toss(); //toss nickel
			if (nickel.getSideUp() == "Heads"){ //if heads
				if (amount != 100) //if amount is not 100
					amount += 5; //add 5 cents
				//System.out.println(amount);
			}
		}
		
		//System.out.println(amount);
		if (amount == 100)
			output = "Your coin tosses equal to one dollar. You win!"; //determine output
		else
			output = "Your coin tosses have exceeded one dollar. You lose.";
		
		JOptionPane.showMessageDialog(null, output); //output result
	}
}