/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: Febuary 09, 2016
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: RoomCarpet Class test
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class CarpetTest{
	public static void main(String[] args){
		double length;  //variables to hold data
		double width;
		double cost;
		String input;
		
		input = JOptionPane.showInputDialog("Input room length: ");  //acquire length
		length = Double.parseDouble(input);
		
		input = JOptionPane.showInputDialog("Input room width: "); //acquire width
		width = Double.parseDouble(input);
		
		input = JOptionPane.showInputDialog("Input cost of carpet per square foot: "); //acquire cost
		cost = Double.parseDouble(input);
		
		RoomDimension room = new RoomDimension(length, width); //create RoomDimension object
		
		JOptionPane.showMessageDialog(null, "Length and Width of room: " + room.toString()); //output first set of data
		
		RoomCarpet roomCost = new RoomCarpet(room, cost); //create RoomCarpet object using cost and the room object
		
		JOptionPane.showMessageDialog(null, roomCost.toString()); //output final data
		
		System.exit(0);
	}
}