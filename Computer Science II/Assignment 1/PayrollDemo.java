/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: January 20, 2016
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Payroll class demo
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class PayrollDemo{
	public static void main(String[] args){
		int[] employeeId = new int[7];
		double[] hours = new double[7];
		double[] payRate = new double[7]; //initialize arrays and input variables
		double[] wages = new double[7];
		String input;
		double numInput;
		
		Payroll payroll = new Payroll(); //initialize payroll class
		
		employeeId = payroll.getEmployeeId(); //get employee ids
		
		for(int i = 0; i < employeeId.length; i++){ //get hours and pay rate for all employees
			do{
				input = JOptionPane.showInputDialog("Input hours worked by Employee #" + employeeId[i] + ":");
				numInput = Double.parseDouble(input);
				hours[i] = numInput;
			}while(numInput < 0); //get hours, do not allow negatives
			
			do{
				input = JOptionPane.showInputDialog("Input pay rate for Employee #" + employeeId[i] + ":");
				numInput = Double.parseDouble(input);
				payRate[i] = numInput;
			}while(numInput < 6.00); //get pay rate, do not allow less than $6.00
		}
		
		payroll.setHours(hours); //set hours in payroll object
		payroll.setPayRate(payRate); //set pay rate in payroll object
		
		wages = payroll.getWages(); //calculate and get wages
		
		for(int j = 0; j < wages.length; j++){
			System.out.printf("Employee #%d: $%.2f\n", employeeId[j], wages[j]); //output data
		}
		
		System.exit(0);
	}
}