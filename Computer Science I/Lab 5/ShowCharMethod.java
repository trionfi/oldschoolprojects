/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 15, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Outputs a character at a certain position
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class ShowCharMethod{
	public static void main(String[] args){
		String str;
		int pos;
		String input;
		
		str = JOptionPane.showInputDialog("Input a string of text.");
		input = JOptionPane.showInputDialog("Input a position in the string (first position is 0)");
		pos = Integer.parseInt(input);
		
		showChar(str, pos);
		
		System.exit(0);
	}
	
	public static void showChar(String strg, int integer){
			char showingChar;
			showingChar = strg.charAt(integer);
			JOptionPane.showMessageDialog(null, showingChar);
	}
}