/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: March 09, 2016
	Course: 62:161 Computer Science II
	Instructor: Ashraf Abdelbar
	Program: Course Grades program
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class CourseGradesAnalyzable implements Analyzable{ //imports the Analyzable interface
	private GradedActivity[] grades = new GradedActivity[4]; //grades array, holding grades for 4 activities
	public CourseGradesAnalyzable(){
		grades[0] = new GradedActivity(); //initialize first array object
		grades[1] = new GradedActivity(); //initalize second array object
		grades[2] = new GradedActivity(); //initialize third array object
		grades[3] = new GradedActivity(); //initialize fourth array object
	}
	public void setLab(GradedActivity object){
		grades[0].setScore(object.getScore()); //set score for Lab object
	}
	public void setPassFailExam(GradedActivity object){ //set score for Pass/Fail exam object
		grades[1].setScore(object.getScore());
	}
	public void setEssay(GradedActivity object){ //set score for essay object
		grades[2].setScore(object.getScore());
	}
	public void setFinalExam(GradedActivity object){ //set score for final exam object
		grades[3].setScore(object.getScore());
	}
	public String toString(){ //return letter grades as string
		return "Lab Grade: " + grades[0].getGrade() + "\nPass/Fail Exam Grade: " + grades[1].getGrade() + "\nEssay Grade: " 
				+ grades[2].getGrade() + "\nFinal Exam Grade: " + grades[3].getGrade();
	}
	public double getAverage(){ //get average of all scores
		return (grades[0].getScore() + grades[1].getScore() + grades[2].getScore() + grades[3].getScore()) / grades.length;
	}
	public GradedActivity getHighest(){ //find object with highest score object
		int index = 0;
		for(int i = 1; i < grades.length; i++){
			if (grades[index].getScore() < grades[i].getScore())
				index = i;
		}
		
		return grades[index];
	}
	public GradedActivity getLowest(){ //find object with lowest score object
		int index = 0;
		for(int i = 1; i < grades.length; i++){
			if (grades[index].getScore() > grades[i].getScore())
				index = i;
		}
		
		return grades[index];
	}
}