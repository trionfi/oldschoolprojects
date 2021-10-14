/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: March 19, 2016
	Course: 62:161 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: Error messages for invalid hourly pay rate
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class InvalidHourlyRateException extends Exception{
	public InvalidHourlyRateException(){ //generic error message
		super("Error: Invalid Hour Rate.");
	}
	public InvalidHourlyRateException(double pr){ //specifies variable giving error
												// @param pr bad hourly pay rate
		super("Error!" + pr + " is not a valid hour rate.");
	}
}