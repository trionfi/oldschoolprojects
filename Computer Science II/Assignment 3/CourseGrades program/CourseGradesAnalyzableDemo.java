/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: March 09, 2016
	Course: 62:161 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: Course Grades Analyzable demo
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class CourseGradesAnalyzableDemo{
	public static void main(String[] args){
		GradedActivity lab = new GradedActivity(); //lab object
		lab.setScore(80);
		
		PassFailExam activity = new PassFailExam(20, 5, 13); //PassfailExam object
		
		GradedActivity essay = new GradedActivity(); //essay object
		essay.setScore(75);
		
		FinalExam exam = new FinalExam(100, 36); //final exam object
		
		CourseGradesAnalyzable demo = new CourseGradesAnalyzable(); //send object data to CourseGrades object
		demo.setLab(lab);
		demo.setPassFailExam(activity);
		demo.setEssay(essay);
		demo.setFinalExam(exam);
		
		System.out.println(demo.toString()); //output letter grade data
		
		System.out.println(demo.getAverage()); //output average score
		GradedActivity demo2 = new GradedActivity(); //new gradedactivity object
		demo2 = demo.getHighest(); //put highest score into object
		GradedActivity demo3 = new GradedActivity(); //new graded activity object
		demo3 = demo.getLowest(); //put lowest score into object
		System.out.println(demo2.getScore()); //output highest score
		System.out.println(demo3.getScore()); //output lowest score
		
	}
}