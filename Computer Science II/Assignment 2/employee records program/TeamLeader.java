/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: Febuary 09, 2016
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: TeamLeader class
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class TeamLeader extends ProductionWorker{
	private double monthlyBonus; //variables to hold data
	private int requiredTrainingHours;
	private int trainingHoursCompleted;
	public TeamLeader(){ //no arg constructor
		monthlyBonus = 0.0;
		requiredTrainingHours = 0;
		trainingHoursCompleted = 0;
	}
	public TeamLeader(String empName, String empNum, String hD, int sh, double hPR, double monBon, int reqTrainHr, int compTrainHr){ //7 arg constructor
		super(empName, empNum, hD, sh, hPR);																				//calling the Employee Class and ProductionWorker class
		
		monthlyBonus = monBon;
		requiredTrainingHours = reqTrainHr;
		trainingHoursCompleted = compTrainHr;
	}
	public void setMontlyBonus(double monBon){ //set new monthly bonus
		monthlyBonus = monBon;
	}
	public void setRequiredTrainingHours(int reqTrainHr){ //set new required training hours
		requiredTrainingHours = reqTrainHr;
	}
	public void setTrainingHoursCompleted(int compTrainHr){ //set new completed training hours
		trainingHoursCompleted = compTrainHr;
	}
	public double getMontlyBonus(){ //acquire monthly bonus
		return monthlyBonus;
	}
	public int getRequiredTrainingHours(){ //acquire required training hours
		return requiredTrainingHours;
	}
	public int getTrainingHoursCompleted(){ //acquire training hours completed
		return trainingHoursCompleted;
	}
	public String toString(){ //output data as a string
		return String.format("%s \nMonthly Bonus: $%.2f \nRequired Training Hours: %d \nTraining Hours Completed: %d", super.toString(), monthlyBonus, requiredTrainingHours, trainingHoursCompleted);
	}
}