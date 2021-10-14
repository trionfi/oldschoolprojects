/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 28, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Personal Information Class
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class PersonalInformation{
	private String address;
	private String age;
	private String phone;
	public PersonalInformation(){
		address = "null";
		age = "null";
		phone = "null";
	}
	public void setAddress(String adr){
		address = adr;
	}
	public void setAge(String str){
		age = str;
	}
	public void setPhone(String pho){
		phone = pho;
	}
	public String getAddress(){
		return address;
	}
	public String getAge(){
		return age;
	}
	public String getPhone(){
		return phone;
	}
}