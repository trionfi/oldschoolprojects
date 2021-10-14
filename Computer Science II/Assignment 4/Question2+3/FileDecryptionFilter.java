/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: March 19, 2016
	Course: 62:161 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: Decryption program
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class FileDecryptionFilter{
	public static void main(String[] args){
		String currentLine; //variables for output and input
		int currentInt;
		ArrayList<Integer> encrypt1 = new ArrayList<Integer>(); //arrays for keys
		ArrayList<Integer> encrypt2 = new ArrayList<Integer>();
		
		FileInputStream encryptInput; //input stream objectss
		DataInputStream inputFile;
		
		File encrypt1File; //file objects
		Scanner readEncrypt1File;
		
		File encrypt2File;
		Scanner readEncrypt2File;
		
		FileOutputStream encryptOutput; //output stream objects
		DataOutputStream outputFile;
		try{
			encryptInput = new FileInputStream("EncryptLetters.dat"); //open encrypted file
			inputFile = new DataInputStream(encryptInput);
			encrypt1File = new File("Encrypt1.txt"); //open 1st key
			readEncrypt1File = new Scanner(encrypt1File);
			encrypt2File = new File("Encrypt2.txt"); //open 2nd key
			readEncrypt2File = new Scanner(encrypt2File);
		
			while(readEncrypt1File.hasNext()){
				currentLine = readEncrypt1File.nextLine();
				currentInt = Integer.parseInt(currentLine);
				encrypt1.add(currentInt);
			}
			
			while(readEncrypt2File.hasNext()){
				currentLine = readEncrypt2File.nextLine();
				currentInt = Integer.parseInt(currentLine);
				encrypt2.add(currentInt);
			}
			System.out.println("Converting...");
			ArrayList<Character> stringFile = new ArrayList<Character>();
		
			while(inputFile.available() > 0){
				stringFile.add(inputFile.readChar());
			}
		
			encryptOutput = new FileOutputStream("OriginalMyLetters.txt");
			outputFile = new DataOutputStream(encryptOutput);
		
			for(int t = 0; t < stringFile.size(); t++){
				outputFile.writeChar(stringFile.get(t) - encrypt1.get(t) - encrypt2.get(t));
			}
		
			System.out.println("Done");
		
			inputFile.close();
			readEncrypt1File.close();
			readEncrypt2File.close();
			outputFile.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}