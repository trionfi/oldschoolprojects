/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: Febuary 09, 2016
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: RoomCarpet Class
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class RoomCarpet{
	private RoomDimension size;  //RoomDimension object to hold length, width, and area
	private double carpetCost; //variable to hold cost
	
	public RoomCarpet(RoomDimension dim, double cost){
		size = new RoomDimension(dim); //initalize the object
		carpetCost = cost; //acquire cost
	}
	public double getTotalCost(){
		return size.getArea() * carpetCost; //calculate total cost
	}
	public String toString(){
		return String.format("%.2f sq.ft x $%.2f = $%.2f", size.getArea(), carpetCost, getTotalCost()); //output data as a string
	}
}