/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: April 1, 2016
	Course: 62:161 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: image based slot machine program
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class slotMachineController {

    @FXML
    private ImageView imageOne;

    @FXML
    private ImageView imageTwo;

    @FXML
    private ImageView imageThree;

    @FXML
    private Label amountLabel;

    @FXML
    private TextField insertAmount;

    @FXML
    private Button slotMachineSpin;

    @FXML
    private Label insertOutput;
	
	private double currentWin;
	private double totalWin;
	
	//private fields for all slot machine image
	private Image appleImage;
	private Image bananaImage;
	private Image cherriesImage;
	private Image grapesImage;
	private Image lemonImage;
	private Image limeImage;
	private Image orangeImage;
	private Image pearImage;
	private Image strawberryImage;
	private Image watermelonImage;
	
	public void initialize(){ //initialize all slot machine image
		appleImage = new Image("Apple.png");
		bananaImage = new Image("Banana.png");
		cherriesImage = new Image("Cherries.png");
		grapesImage = new Image("Grapes.png");
		lemonImage = new Image("Lemon.png");
		limeImage = new Image("Lime.png");
		orangeImage = new Image("Orange.png");
		pearImage = new Image("Pear.png");
		strawberryImage = new Image("Strawberry.png");
		watermelonImage = new Image("Watermelon.png");
	}
	
	public void slotMachineSpinListener() {
		String str = insertAmount.getText();
		
		double input = Double.parseDouble(str);
		
		Random rand = new Random();
		int rollOne = rand.nextInt((10 - 1) + 1) + 1; //roll one
		int rollTwo = rand.nextInt((10 - 1) + 1) + 1; //roll two
		int rollThree = rand.nextInt((10 - 1) + 1) + 1; //roll three
		
		int matchCount = 0;
		
		switch (rollOne){ //image output for first slot
			case 1:
				imageOne.setImage(appleImage);
				break;
			case 2:
				imageOne.setImage(bananaImage);
				break;
			case 3:
				imageOne.setImage(cherriesImage);
				break;
			case 4:
				imageOne.setImage(grapesImage);
				break;
			case 5:
				imageOne.setImage(lemonImage);
				break;
			case 6:
				imageOne.setImage(limeImage);
				break;
			case 7:
				imageOne.setImage(orangeImage);
				break;
			case 8:
				imageOne.setImage(pearImage);
				break;
			case 9:
				imageOne.setImage(strawberryImage);
				break;
			case 10:
				imageOne.setImage(watermelonImage);
				break;
		}
		
		switch (rollTwo){ //image output for image two
			case 1:
				imageTwo.setImage(appleImage);
				break;
			case 2:
				imageTwo.setImage(bananaImage);
				break;
			case 3:
				imageTwo.setImage(cherriesImage);
				break;
			case 4:
				imageTwo.setImage(grapesImage);
				break;
			case 5:
				imageTwo.setImage(lemonImage);
				break;
			case 6:
				imageTwo.setImage(limeImage);
				break;
			case 7:
				imageTwo.setImage(orangeImage);
				break;
			case 8:
				imageTwo.setImage(pearImage);
				break;
			case 9:
				imageTwo.setImage(strawberryImage);
				break;
			case 10:
				imageTwo.setImage(watermelonImage);
				break;
		}
		
		switch (rollThree){ //image output for image three
			case 1:
				imageThree.setImage(appleImage);
				break;
			case 2:
				imageThree.setImage(bananaImage);
				break;
			case 3:
				imageThree.setImage(cherriesImage);
				break;
			case 4:
				imageThree.setImage(grapesImage);
				break;
			case 5:
				imageThree.setImage(lemonImage);
				break;
			case 6:
				imageThree.setImage(limeImage);
				break;
			case 7:
				imageThree.setImage(orangeImage);
				break;
			case 8:
				imageThree.setImage(pearImage);
				break;
			case 9:
				imageThree.setImage(strawberryImage);
				break;
			case 10:
				imageThree.setImage(watermelonImage);
				break;
		}
		
		if (rollOne == rollTwo){ //count matches
			matchCount++; //if roll one and two match
			if (rollTwo == rollThree)
				matchCount++; //if roll two and three match
		}
		else if (rollOne == rollThree) //if roll one and three match, but not two
			matchCount++;
		
		if (matchCount == 1){ //if there is one match
			currentWin = input * 2.0; //calculate winnings, doubles amount spent
			totalWin += currentWin;
		}
		else if (matchCount == 2){ //if all three matched
			currentWin = input * 3.0; //calculate winnings, triples amount spent
			totalWin += currentWin;
		}
		else 
			currentWin = 0.00f;
		
		String strOutput = String.format("Amount Won This Spin: $%.2f\nTotal Amount Won: $%.2f", currentWin, totalWin);
		
		//output results
		insertOutput.setText(strOutput);
		
	}

}
