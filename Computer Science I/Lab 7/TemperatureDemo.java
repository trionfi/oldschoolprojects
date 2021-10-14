/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 28, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Temperature Class Demo
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class TemperatureDemo{
	public static void main(String[] args){
		String input;
		double fahrenTemp;
		input = JOptionPane.showInputDialog("Input Fahrenheit temperature: ");
		fahrenTemp = Double.parseDouble(input);
		
		Temperature temp = new Temperature(fahrenTemp);
		
		JOptionPane.showMessageDialog(null, "Fahrenheit: " + temp.getFahrenheit() + "\nCelsius: " + temp.getCelsius() + "\nKelvin: " + temp.getKelvin());
		
		System.exit(0);
	}
}