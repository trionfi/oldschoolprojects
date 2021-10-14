/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: March 19, 2016
	Course: 62:161 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: Encryption program, in theory the key would be stored in seperate places
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class FileEncryptionFilter{
	public static void main(String[] args){
		File file; //file object
		
		ArrayList<Integer> encrypt1 = new ArrayList<Integer>(); //two array lists for the encryption keys
		ArrayList<Integer> encrypt2 = new ArrayList<Integer>();
		
		ArrayList<Character> stringFile = new ArrayList<Character>(); //array list to hold characters of the MyLetters files
		
		FileWriter wrFile1; //file writer objects
		PrintWriter writeEncryptData1;
		
		FileWriter wrFile2; //^
		PrintWriter writeEncryptData2;
		
		FileInputStream encryptFile; //input stream objects
		DataInputStream encrypt;
		
		FileOutputStream encryptOutput; //output stream objects
		DataOutputStream outputFile;
		
		try{
		
			file = new File("MyLetters.txt");  //open the MyLetters files
			wrFile1 = new FileWriter("Encrypt1.txt", false); //open output for first key
			writeEncryptData1 = new PrintWriter(wrFile1);
			wrFile2 = new FileWriter("Encrypt2.txt", false); //open output for second key
			writeEncryptData2 = new PrintWriter(wrFile2);
			encryptFile = new FileInputStream(file); //open input file as an input stream
			encrypt = new DataInputStream(encryptFile);
			encryptOutput = new FileOutputStream("EncryptLetters.dat"); //open file for output
			outputFile = new DataOutputStream(encryptOutput);
		
			System.out.println("Converting"); //convert string into characters
			while(encryptFile.available() > 0){
				
				stringFile.add(encrypt.readChar());
			}
		
			System.out.println("done");
		
			Random rand = new Random(); //random numbers
		
			for(int i = 0; i < stringFile.size(); i++){ //generate two encryption keys
				encrypt1.add(rand.nextInt((100 - 0) + 0));
				writeEncryptData1.println(encrypt1.get(i)); //output keys into text file
				encrypt2.add(rand.nextInt((100 - 0) + 0));
				writeEncryptData2.println(encrypt2.get(i));
			}
		

		
			for(int t = 0; t < stringFile.size(); t++){
				outputFile.writeChar(stringFile.get(t) + encrypt1.get(t) + encrypt2.get(t)); //add encryption keys to characters
			}
		
			outputFile.close(); //close files
			encryptFile.close();
			writeEncryptData1.close();
			writeEncryptData2.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}