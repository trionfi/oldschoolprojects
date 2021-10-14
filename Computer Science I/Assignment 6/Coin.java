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

public class Coin{
	public String sideUp;
	Random rand = new Random(); //generate random variable
	public Coin(){
		int toss = rand.nextInt(2 - 0); //generate coin toss
		if (toss == 1)
			sideUp = "Heads";
		else
			sideUp = "Tails";
	}
	public void toss(){
		int toss = rand.nextInt(2 - 0); //generate new coin toss
		if (toss == 1)
			sideUp = "Heads";
		else
			sideUp = "Tails";
	}
	public String getSideUp(){ //return side
		return sideUp;
	}
}