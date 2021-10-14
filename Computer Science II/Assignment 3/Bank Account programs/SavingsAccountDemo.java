/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: March 09, 2016
	Course: 62:161 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: Savings Account class demo
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class SavingsAccountDemo{
	public static void main(String[] args){
		SavingsAccount account1 = new SavingsAccount(500.00, .08); //new SavingsAccount object with balance and annual interest rate
		System.out.println(account1.toString() + "\n"); //output data
		account1.deposit(300.00);
		System.out.println(account1.toString() + "\n");
		account1.withdrawal(100.00);
		System.out.println(account1.toString() + "\n");
		account1.withdrawal(30.00);
		System.out.println(account1.toString() + "\n");
		account1.withdrawal(300.00);
		System.out.println(account1.toString() + "\n");
		account1.withdrawal(200.00);
		System.out.println(account1.toString() + "\n");
		account1.withdrawal(150.00);
		System.out.println(account1.toString() + "\n");
		account1.withdrawal(10.00);
		System.out.println(account1.toString() + "\n");
		account1.deposit(800.00);
		System.out.println(account1.toString() + "\n");
		account1.monthlyProcess();
		System.out.println(account1.toString() + "\n");
	}
}