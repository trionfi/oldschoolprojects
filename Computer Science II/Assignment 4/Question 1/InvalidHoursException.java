/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: March 19, 2016
	Course: 62:161 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: Error messages for invalid number of hours
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class InvalidHoursException extends Exception{
	public InvalidHoursException(){ //generic error message
		super("Error: Invalid Hours Worked.");
	}
	public InvalidHoursException(double hr){ //specifies variable giving error
												// @param hr bad # of hours
		super("Error!" + hr + " is not a valid number of hours.");
	}
}