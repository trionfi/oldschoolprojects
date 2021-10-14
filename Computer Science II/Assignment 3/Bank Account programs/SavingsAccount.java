/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: March 09, 2016
	Course: 62:161 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: Savings Account class
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class SavingsAccount extends BankAccount{
	private boolean active;
	public SavingsAccount(double bal, double ann){ //constructor
		super(bal, ann);
		if (super.getBalance() > 25.00) //check if balance is over $25
			active = true;
		else
			active = false;
	}
	public void withdrawal(double with){
		if(with > super.getBalance()) //make sure account cannot go into negatives
			JOptionPane.showMessageDialog(null, "Your bank account does not contain enough funds.");
		else{
			if(active) //check if account is active
				super.withdrawal(with);
			else
				JOptionPane.showMessageDialog(null, "Your bank account is no longer active. Please make sure your balance is over $25.00 to re-activate it.");
		}
		if (super.getBalance() > 25.00) //check if balance is over %25
			active = true;
		else
			active = false;
	}
	public void deposit(double dep){
		if(active) //check if account is active
			super.deposit(dep);
		else{
			if(super.getBalance() + dep > 25.00) //check if new deposit will make account active
				super.deposit(dep);
			else
				JOptionPane.showMessageDialog(null, "Your bank account is no longer active. Please make sure your balance is over $25.00 to re-activate it.");
		}
		if (super.getBalance() > 25.00) //check if balance is over $25
			active = true;
		else
			active = false;
	}
	public void monthlyProcess(){ //do monthly processes, check if withdrawals is over 4
		if(active){
			if(super.getWithdrawals() > 4){
				double overwithdrawal = super.getWithdrawals() - 4;
				super.withdrawal(overwithdrawal * 1.00); //withdrawals over 4 are $1 each
				super.monthlyProcess();
			}
			else
				super.monthlyProcess();
		}
		if(super.getBalance() < 25.00){ //check if balance is over $25
			active = false;
		}
			
	}
	public String toString(){ //return info as string
		return "Status of account:" + active + "\n" + super.toString();
	}
}