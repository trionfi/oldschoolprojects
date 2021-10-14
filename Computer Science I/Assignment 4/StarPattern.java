/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 13, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: output star pattern
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class StarPattern{
	public static void main(String[] args){
		for(int j = 7; j > 0; j--){ //while j is greater than 0, repeat, with j decreasing every time
				for(int k = j; k > 0; k--){ //while k is greater than zero, repeat, decreasing each time
					System.out.print("*"); //output *
				}
				System.out.println(); //new line
			}
		for(int o = 0; o < 6; o++){ //while o is less than 6, repeat, increasing each time
			System.out.print("*"); //output *
			if (o > 0){
				for(int p = 0; p < o; p++){ //while p is less than o, repeat, increasing each time
					System.out.print(" "); //output a space
				}
			}
			System.out.print("*"); //output *
			System.out.println(); //new line
		}
	}
}