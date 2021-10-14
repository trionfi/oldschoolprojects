/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: December 08, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Saving Account Class
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class SavingsAccount{
	private double annualRate; //annual interest rate
	private double balance; //balance of account

	public SavingsAccount(double num){ //constructor
		balance = num; //set balance
	}
	public void setBalance(double num){
		balance = num; //set Balance
	}
	public void setAnnualRate(double rate){
		annualRate = rate; //set annual rate
	}
	public void withdrawal(double num){
		balance -= num; //withdrawal money
	}
	public void deposit(double num){
		balance += num; //deposit money
	}
	public void addMontlyInterest(){
		balance += (balance * (annualRate / 12.0)); //add monthly interest rate
	}
	public double getBalance(){
		return balance; //get balance
	}
	public double getMonthlyInterest(){
		return (balance * (annualRate / 12.0)); //get the montly interest
	}
}