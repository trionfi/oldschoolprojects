/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: Febuary 09, 2016
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Employee class
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class Employee{ 
	private String employeeName; //variables for holding data
	private String employeeNumber;
	private String hireDate;
	public Employee(){ //no arg constructor
		employeeName = "N/A";
		employeeNumber = "###-@";
		hireDate = "N/A";
	}
	public Employee(String empName, String empNum, String hD){ //3 arg constructor
		employeeName = empName;
		employeeNumber = empNum;
		hireDate = hD;
	}
	public void setEmployeeName(String empName){ //set new employee name
		employeeName = empName;
	}
	public void setEmployeeNumber(String empNum){ //set new employee number
		employeeNumber = empNum;
	}
	public void setHireDate(String hD){ //set new hire date
		hireDate = hD;
	}
	public String getEmployeeName(){ //acquire employee name
		return employeeName;
	}
	public String getEmployeeNumber(){ //acquire employee number
		return employeeNumber;
	}
	public String getHireDate(){ //acquire hire date
		return hireDate;
	}
	public String toString(){ //output data as a string
		return "Employee Name: " + employeeName + "\nEmployee Number: " + employeeNumber + "\nHire Date: " + hireDate;
	}
}