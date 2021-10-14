/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: Febuary 09, 2016
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: TeamLeader class demo
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class TeamLeaderDemo{
	public static void main(String[] args){
		String employeeName, employeeNumber, hireDate; //variables to hold data
		int shift;
		double payRate;
		double monthlyBonus;
		int requiredTrainingHours;
		int trainingHoursCompleted;
		
		employeeName = "Jim Bob"; //initialize data in program because this is just to test
		employeeNumber = "666-K";
		hireDate = "06-06-2006";
		shift = 1;
		payRate = 15.50;
		monthlyBonus = 200.00;
		requiredTrainingHours = 40;
		trainingHoursCompleted = 25;
		
		TeamLeader employee1 = new TeamLeader(employeeName, employeeNumber, hireDate, shift, payRate, monthlyBonus, requiredTrainingHours, trainingHoursCompleted); //populate object
		
		System.out.println(employee1.toString()); //output data
		
		//change employeeNumber
		employee1.setEmployeeNumber("665-J");
		
		//change pay rate
		employee1.setHrPayRate(18.50);
		
		System.out.println(" "); //re-output data
		System.out.println(employee1.toString());
	} 

}