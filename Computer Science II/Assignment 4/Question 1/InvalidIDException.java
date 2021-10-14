/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: March 19, 2016
	Course: 62:161 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: Error messages for invalid employee ID
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class InvalidIDException extends Exception{
	public InvalidIDException(){ //generic error message
		super("Error: Invalid Employee ID.");
	}
	public InvalidIDException(int id){ //specifies variable giving error
												// @param id bad id #
		super("Error!" + id + " cannot be an ID Number.");
	}
}