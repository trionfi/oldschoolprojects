/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: December 08, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: bank acccount using text files
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class BankAccountFiles{
	public static void main(String[] args) throws IOException{
		double currentLine;
		double moneyLine;
		double interest;
		
		File dpFile = new File("Deposits.txt"); //open deposit file
		Scanner readDepositData = new Scanner(dpFile);
		File wdFile = new File("Withdrawals.txt"); //open withdrawl file
		Scanner readWithdrawalData = new Scanner(wdFile);
		
		SavingsAccount account = new SavingsAccount(500.00); //set starting balance
		
		account.setAnnualRate(0.05); //set the annual interest rate
		
		while(readDepositData.hasNext()){
			currentLine = readDepositData.nextDouble(); //get a line from the deposit data text file
			account.deposit(currentLine);
		}
		
		while(readWithdrawalData.hasNext()){
			currentLine = readWithdrawalData.nextDouble(); //get a line from the withdrawal data text file
			account.withdrawal(currentLine);
		}
		
		interest = account.getMonthlyInterest(); //get the montly interest earned
		account.addMontlyInterest(); //add the monthly interest
		
		String output = String.format("Current Balance: $%.2f \nInterest Earned: $%.2f", account.getBalance(), interest); //output data
		JOptionPane.showMessageDialog(null, output);
		
		readDepositData.close(); //close input file
		readWithdrawalData.close(); //close output file
	}
}