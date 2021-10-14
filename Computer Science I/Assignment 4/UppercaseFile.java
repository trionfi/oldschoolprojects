/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 08, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: a program that reads files and converts the file to all uppercase letters
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs
	
	
public class UppercaseFile{
	public static void main(String[] args) throws IOException{
		String readFile, writeFile;
		String currentLine;
		
		readFile = JOptionPane.showInputDialog("Enter file to read from (include extension):"); //get input file
		writeFile = JOptionPane.showInputDialog("Enter file to write to (include extension:"); //get output file
		
		File rdFile = new File(readFile); //open read file
		Scanner readFileData = new Scanner(rdFile);
		FileWriter wrFile = new FileWriter(writeFile, true); //open output file
		PrintWriter writeFileData = new PrintWriter(wrFile);
		
		//read lines in the input file until there are no lines left, convert to uppercase, and then output into output file
		while(readFileData.hasNext()){
			currentLine = readFileData.nextLine(); //get a line from the input data
			currentLine = currentLine.toUpperCase(); //convert to uppercase
			writeFileData.println(currentLine);
		}
		
		readFileData.close(); //close input file
		writeFileData.close(); //close output file
	
		System.exit(0); //exit program
	
	}

}