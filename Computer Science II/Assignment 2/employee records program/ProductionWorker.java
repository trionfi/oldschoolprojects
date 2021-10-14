/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: Febuary 09, 2016
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: ProductionWorker class
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class ProductionWorker extends Employee{ //ProductionWorker is a subclass of Employee
	private int shift; //variables for data
	private double hrPayRate;
	public ProductionWorker(){ //no arg constructor
		shift = 0;
		hrPayRate = 0.0;
	}
	public ProductionWorker(String empName, String empNum, String hD, int sh, double hPR){ //5 arg constructor, calling the 3 arg
		super(empName, empNum, hD);															//constructor from employee
		
		shift = sh;
		hrPayRate = hPR;
	}
	public void setShift(int sh){ //set new shift number
		shift = sh;
	}
	public void setHrPayRate(double hPR){ //set new hourly pay rate
		hrPayRate = hPR;
	}
	public int getShift(){ //acquire shift number
		return shift;
	}
	public double getHrPayRate(){ //acquire hourly pay rate
		return hrPayRate;
	}
	public String toString(){ //output data as a string
		return String.format("%s \nShift: %d \nHourly Pay Rate: $%.2f", super.toString(), shift, hrPayRate);
	}
}