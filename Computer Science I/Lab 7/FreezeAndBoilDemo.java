/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 28, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Freezing and Boiling Class Demo
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class FreezeAndBoilDemo{
	public static void main(String[] args){
		String input;
		double fahrenTemp;
		input = JOptionPane.showInputDialog("Input Fahrenheit temperature: ");
		fahrenTemp = Double.parseDouble(input);
		
		FreezeAndBoil temp = new FreezeAndBoil(fahrenTemp);
		
		String ethyl = "Liquid";
		String oxygen = "Liquid";
		String water = "Liquid";
		
		ethyl = temp.isEthylFreezing() ? "Freezing" : ethyl;
		ethyl = temp.isEthylBoiling() ? "Boiling" : ethyl;
		oxygen = temp.isOxygenFreezing() ? "Freezing" : oxygen;
		oxygen = temp.isOxygenBoiling() ? "Boiling" : oxygen;
		water = temp.isWaterFreezing() ? "Freezing" : water;
		water = temp.isWaterBoiling() ? "Boiling" : water;
		
		JOptionPane.showMessageDialog(null, "Temperature: " + temp.getTemp() + "F" + "\nEthyl: " + ethyl + "\nOxygen: " + oxygen + "\nWater: " + water);
		
		System.exit(0);
	}
}