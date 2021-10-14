/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: January 20, 2016
	Course: 62:160 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: Payroll class
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class Payroll{
	//initalize arrays, employee ids are already set
	int[] employeeId = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489}; 
	double[] hours = new double[7];
	double[] payRate = new double[7];
	double[] wages = new double[7];
	double wage;
	
	public void setHours(double[] array){
		for(int i = 0; i < array.length; i++){
			hours[i] = array[i]; //copy inputted hours into hours array
		}
	}
	
	public void setPayRate(double[] array){
		for(int i = 0; i < array.length; i++){
			payRate[i] = array[i]; //copy inputted wages into wages array
		}
	}
	
	public double[] getWages(){
		for(int i = 0; i < wages.length; i++){
			wages[i] = hours[i] * payRate[i]; //calculate the wages with each given pay rate and hours
		}
		
		return wages;
	}
	
	public int[] getEmployeeId(){
		return employeeId;
	}
	
	public void setIndvHours(int emp, double hrs){
		int count = 0;
		for(int i = 0; i < hours.length; i++){ //be able to edit individual employee hours
			count++;
			if(employeeId[i] == emp)
				hours[count] = hrs;
		}
		for(int i = 0; i < wages.length; i++){
			wages[i] = hours[i] * payRate[i]; //recalculate wages
		}
	}
	
	public void setIndvPayRate(int emp, double pay){
		int count = 0;
		for(int i = 0; i < hours.length; i++){ //be able to edit individual employee pay rates
			count++;
			if(employeeId[i] == emp)
				payRate[count] = pay;
		}
		
		for(int i = 0; i < wages.length; i++){
			wages[i] = hours[i] * payRate[i]; //recalculate wages
		}
	}
	
	public double getIndvWages(int empNum){
		int count = 0;
		for(int i = 0; i < employeeId.length; i++){ //return wages for individual employees
			count++;
			if(employeeId[i] == empNum)
				wage = wages[i];
		}
		return wage;
	}
}