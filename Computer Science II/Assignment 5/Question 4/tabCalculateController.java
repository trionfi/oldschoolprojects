/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: April 1, 2016
	Course: 62:161 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: restaurant tab calculator
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class tabCalculateController {

    @FXML
    private Label promptText;

    @FXML
    private TextField tabCalculateInput;

    @FXML
    private Label tabCalculateOutput;

    @FXML
    private Button tabCalculateButton;
	
	public void tabCalculateButtonListener() {
		
		final double TIP_PERCENTAGE = .18;
		final double TAX_PERCENTAGE = .07;
		
		//get input from user
		String str = tabCalculateInput.getText();
		
		//calculate tip and tax
		double tip = Double.parseDouble(str) * TIP_PERCENTAGE;
		double tax = Double.parseDouble(str) * TAX_PERCENTAGE;
		double total = Double.parseDouble(str) + tip + tax;
		
		String strTip = String.format("$%.2f", tip);
		String strTax = String.format("$%.2f", tax);
		String strTotal = String.format("$%.2f", total);
		str = "$" + str;
		
		//formatting
		String output = String.format("%15s %15s\n%15s %21s\n%15s %20s\n       ----------------\n%15s %19s",
										"Meal Cost:", str, "Tip:", strTip, "Tax:", strTax, "Total:", strTotal);
		
		//output results
		tabCalculateOutput.setText(output);
		
	}

}
