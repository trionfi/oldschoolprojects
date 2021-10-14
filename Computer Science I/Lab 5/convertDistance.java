/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 15, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: convert a distance in meters to kilometers, inches, or feet
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class convertDistance{
	public static void main(String[] args){
		
		menu();
		System.exit(0);
	}
	public static void showKilometers(double meter){
		double kilo = meter * 0.001;
		JOptionPane.showMessageDialog(null, meter + " meters is " + kilo + " kilometers.");
	}
	public static void showInches(double meter){
		double inch = meter * 39.37;
		JOptionPane.showMessageDialog(null, meter + " meters is " + inch + " inches.");	
	}
	public static void showFeet(double meter){
		double feet = meter * 3.281;
		JOptionPane.showMessageDialog(null, meter + " meters is " + feet + " feet.");
	}
	public static void menu(){
		double meters;
		String input;
		String sentinal = "0";
		
		do{
			input = JOptionPane.showInputDialog("Input a distance in meters:");
			meters = Double.parseDouble(input);
		}while (meters < 0);
		while (!(sentinal.equals("4"))){
			sentinal = JOptionPane.showInputDialog("Choose from the following: \n1. Convert to kilometers\n2. Convert to inches" +
												"\n3. Convert to feet\n4. Quit the program");
			switch (sentinal){
					case "1":
						showKilometers(meters);
						break;
					case "2":
						showInches(meters);
						break;
					case "3":
						showFeet(meters);
						break;
					case "4":
						break;
					default:
						JOptionPane.showMessageDialog(null, "That is not a valid input");
			}
		}
	}
}