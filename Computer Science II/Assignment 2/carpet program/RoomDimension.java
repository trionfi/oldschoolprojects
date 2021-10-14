/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: Febuary 09, 2016
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: RoomDimension Class
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class RoomDimension{
	private double length; //variable to hold length
	private double width; //variable to hold width
	
	public RoomDimension(double len, double w){
		length = len; //acquire length
		width = w; //acquire width
	}
	public RoomDimension(RoomDimension object2){ //copy variables to a new object
		length = object2.length; 
		width = object2.width;
	}
	public double getArea(){ //calculate and return area
		return length * width;
	}
	public String toString(){
		return String.format("(%.2f, %.2f) =  %.2f", length, width, getArea()); //output data as a variable
	}
}