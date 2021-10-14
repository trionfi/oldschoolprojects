/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 28, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Temperature Class
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class Temperature{
	private double ftemp;
	public Temperature (double fahren){
		ftemp = fahren;
	}
	public void setFahrenheit(double fahren){
		ftemp = fahren;
	}
	public double getFahrenheit(){
		return ftemp;
	}
	public double getCelsius(){
		return (5.0/9.0) * (ftemp - 32.0);
	}
	public double getKelvin(){
		return ((5.0/9.0) * (ftemp - 32.0)) + 273.0;
	}
}