/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: March 09, 2016
	Course: 62:161 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: Course Grades demo
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class CourseGradesDemo{
	public static void main(String[] args){
		GradedActivity lab = new GradedActivity(); //lab object
		lab.setScore(80);
		
		PassFailExam activity = new PassFailExam(25, 5, 13); //PassfailExam object
		
		GradedActivity essay = new GradedActivity(); //essay object
		essay.setScore(80);
		
		FinalExam exam = new FinalExam(100, 20); //final exam object
		
		CourseGrades demo = new CourseGrades(); //send object data to CourseGrades object
		demo.setLab(lab);
		demo.setPassFailExam(activity);
		demo.setEssay(essay);
		demo.setFinalExam(exam);
		
		System.out.println(demo.toString()); //output letter grade data
		
	}
}