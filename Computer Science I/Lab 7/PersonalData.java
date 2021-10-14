/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 28, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Personal Information Class Demo
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class PersonalData{
	public static void main(String[] args){
		PersonalInformation me = new PersonalInformation();
		PersonalInformation satan = new PersonalInformation();
		PersonalInformation god = new PersonalInformation();
		
		String meName, meAge, mePhone, satanName, satanAge, satanPhone, godName, godAge, godPhone;
		
		me.setAddress("Canada");
		satan.setAddress("Hell");
		god.setAddress("Heaven");
		me.setAge("24");
		satan.setAge("666?");
		god.setAge("???");
		me.setPhone("740-8273");
		satan.setPhone("666-6666");
		god.setPhone("???-????");
		
		System.out.println("Alexandra Paramor: " + me.getAddress() + " " + me.getAge() + " " + me.getPhone());
		System.out.println("Satan: " + satan.getAddress() + " " + satan.getAge() + " " + satan.getPhone());
		System.out.println("God: " + god.getAddress() + " " + god.getAge() + " " + god.getPhone());
	}
}