/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 22, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: even and odd counter
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class EvenOddCounter{
	public static void main(String[] args){
		Random rand = new Random();
		int num;
		int evenCount = 0, oddCount = 0;
		boolean isItEven;
		
		for(int i = 0; i < 100; i++){
			num = rand.nextInt();
			isItEven = isEven(num);
			if (isItEven)
				evenCount++;
			else
				oddCount++;
		}
		JOptionPane.showMessageDialog(null, evenCount + " even numbers were generated and " + oddCount + " odd numbers were generated.");
		
		System.exit(0);
	}
	
	public static boolean isEven(int num){
		if ((num % 2) == 0)
			return true;
		else
			return false;
	}
}