/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: January 20, 2016
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Lo Shu Magic Square
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class LoShuMagicSquare{
	public static void main(String[] args){
		int[][] magicArray = { {4, 9, 2}, //test variable
								{3, 5, 7},
								{8, 1, 6} };

		int[][] normalArray = { {1, 2, 3}, //test variable
								{4, 5, 6},
								{7, 8, 8} };
							
		System.out.println("Is it a magic square?"); //output results
		System.out.println("Array 1: " + isMagicSquare(magicArray));
		System.out.println("Array 2: " + isMagicSquare(normalArray));
	}
	public static boolean isMagicSquare(int[][] array){
		boolean isitMagicSquare = true; //returm value
		
		int num = 0; //addition variable
		
		for(int i = 0; i < array.length; i++){ //test rows
			num = 0;
			for(int j = 0; j < array[i].length; j++){
				num += array[i][j];
			}
			if (num != 15)
				isitMagicSquare = false;
		}
		
		for(int k = 0; k < array[k].length - 1; k++){ //test columns
			num = 0;
			for(int l = 0; l < array.length; l++){
				num += array[l][k];
			}
			if (num != 15)
				isitMagicSquare = false;
		}
		
		num = array[0][0] + array[1][1] + array[2][2]; //test one diagional
		if (num != 15)
			isitMagicSquare = false;
		
		num = array[0][2] + array[1][1] + array[2][0]; //test other diagional
		if (num != 15)
			isitMagicSquare = false;
		
		return isitMagicSquare; //return value
	}

}