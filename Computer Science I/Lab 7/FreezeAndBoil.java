/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 28, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Freezing and Boiling points
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class FreezeAndBoil{
	private double temperature;
	public FreezeAndBoil(double temp){
		temperature = temp;
	}
	public void setTemp(double temp){
		temperature = temp;
	}
	public double getTemp(){
		return temperature;
	}
	public boolean isEthylFreezing(){
		return (temperature <= -173) ? true : false;
	}
	public boolean isEthylBoiling(){
		return (temperature >= 172) ? true : false;
	}
	public boolean isOxygenFreezing(){
		return (temperature <= -362) ? true : false;
	}
	public boolean isOxygenBoiling(){
		return (temperature >= -306) ? true : false;
	}
	public boolean isWaterFreezing(){
		return (temperature <= 32) ? true : false;
	}
	public boolean isWaterBoiling(){
		return (temperature >= 212) ? true : false;
	}
}