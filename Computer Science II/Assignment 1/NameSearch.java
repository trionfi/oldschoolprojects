/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: January 20, 2016
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Name Search
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class NameSearch{
	public static void main(String[] args) throws IOException{ //possibility of IOException
		String currentLine; //declare variables
		String input;
		String boyName = "null";
		String girlName = "null";
		int sentinal = 0;
		boolean hasBoyName = false, hasGirlName = false;
		int inputNum;
		ArrayList<String> girlNameList = new ArrayList<String>();
		ArrayList<String> boyNameList = new ArrayList<String>();
		
		File boyFile = new File("BoyNames.txt"); //open boy name file
		Scanner readBoyData = new Scanner(boyFile);
		File girlFile = new File("GirlNames.txt"); //open girl name file
		Scanner readGirlData = new Scanner(girlFile);
		
		while(readBoyData.hasNext()){
			currentLine = readBoyData.nextLine(); //populate boy array
			boyNameList.add(currentLine);
		}
		
		while(readGirlData.hasNext()){
			currentLine = readGirlData.nextLine(); //populate girl array
			girlNameList.add(currentLine);
		}
		
		readBoyData.close(); //close boy name file
		readGirlData.close(); //close girl name file
		
		do{
			input = JOptionPane.showInputDialog("Search\n1. Boys' Names\n2. Girls' Names\n3. Search Both"); //menu for user
			inputNum = Integer.parseInt(input);
			switch(inputNum){
				case 1:
					sentinal = 1;
					break;
				case 2:
					sentinal = 1;
					break;
				case 3:
					sentinal = 1;
					break;
				default:
					sentinal = 0;
			}
		}while(sentinal == 0);
		
		switch(inputNum){ //get input from user
			case 1:
				boyName = JOptionPane.showInputDialog("Enter a boy's name: ");
				break;
			case 2:
				girlName = JOptionPane.showInputDialog("Enter a girl's name: ");
				break;
			case 3:
				boyName = JOptionPane.showInputDialog("Enter a boy's name: ");
				girlName = JOptionPane.showInputDialog("Enter a girl's name: ");
				break;
		}
		
		for(int i = 0; i < boyNameList.size(); i++){ //check against boy array
			if(boyNameList.get(i).equals(boyName))
				hasBoyName = true;
		}
		
		for(int j = 0; j < girlNameList.size(); j++){ //check against girl array
			if(girlNameList.get(j).equals(girlName))
				hasGirlName = true;
		}
		
		if(hasBoyName) //output results
			JOptionPane.showMessageDialog(null, boyName + " is on the list of popular boy's names.");
		if(hasGirlName)
			JOptionPane.showMessageDialog(null, girlName + " is on the list of popular girl's names.");
		if(!(hasBoyName) && !(hasGirlName))
			JOptionPane.showMessageDialog(null, "No match");
		
		System.exit(0); //close program
	}
}