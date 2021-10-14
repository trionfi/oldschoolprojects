/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: March 19, 2016
	Course: 62:160 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: Payroll class
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class Payroll{
	//declare variables
	private int employeeId; 
	private String employeeName;
	private double hours;
	private double payRate;

	public Payroll(String name, int id) throws InvalidIDException, InvalidNameException{
		if(name.equals(""))
			throw new InvalidNameException();
			
		employeeName = name;
		
		if(id <= 0)
			throw new InvalidIDException(id);
		
		employeeId = id;
	}
	public void setHours(double hr) throws InvalidHoursException{
		if(hr < 0 || hr > 84)
			throw new InvalidHoursException(hr);
		hours = hr;
	}
	
	public void setPayRate(double pr) throws InvalidHourlyRateException{
		if(pr < 0 || pr > 25)
			throw new InvalidHourlyRateException(pr);
		payRate = pr;
	}
	
	public void setEmployeeName(String name) throws InvalidNameException{
		if(name.equals(""))
			throw new InvalidNameException();
			
		employeeName = name;
	}
	
	public void setEmployeeId(int id) throws InvalidIDException{
		if(id <= 0)
			throw new InvalidIDException(id);
		
		employeeId = id;
	}
	
	public double getWage(){
		return hours * payRate; //calculate the wages with each given pay rate and hours
	}
	
	public double getHours(){
		return hours;
	}
	
	public double getPayRate(){
		return payRate;
	}
	
	public int getEmployeeId(){
		return employeeId;
	}
	
	public String getEmployeeName(){
		return employeeName;
	}
	
	
}