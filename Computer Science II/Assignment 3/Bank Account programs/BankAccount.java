/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: March 09, 2016
	Course: 62:161 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: Abstract Bank Account class
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public abstract class BankAccount{
	private double balance; //balance variable
	private int depositMonth; //counter for deposits
	private int withdrawalMonth; //counter for withdrawals
	private double annInterestRate; //annual interest rate
	private double monthCharge = 5.00; //monthly charge
	public BankAccount(double bal, double ann){ //constructor
		balance = bal;
		annInterestRate = ann;
		depositMonth = 0;
		withdrawalMonth = 0;
	}
	public void deposit(double dep){ //add to balance and increment deposit counter
		balance += dep;
		depositMonth++;
	}
	public void withdrawal(double with){ //subtract from balance and increment withdrawal counter
		balance -= with;
		withdrawalMonth++;
	}
	public void calcInterest(){ //calculate monthly interest
		double monthlyInterestRate = (annInterestRate) / 12.0;
		double monthlyInterest = balance * monthlyInterestRate;
		balance += monthlyInterest;
	}
	public double getBalance(){ //return balance
		return balance;
	}
	public int getWithdrawals(){ //return withdrawal counter
		return withdrawalMonth;
	}
	public void monthlyProcess(){ //calculate monthly interest, subtract fees, reset counters
		balance -= monthCharge;
		calcInterest();
		depositMonth = 0;
		withdrawalMonth = 0;
	}
	public String toString(){ //return  info as string
		return String.format("Current balance: $%.2f \nWithdrawals this month: %d \nDeposits this month: %d", balance, withdrawalMonth, depositMonth);
	}
}