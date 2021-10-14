/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 24, 2016
	Course: 62:206
	Instructor: Dr. Li
	Program: span2 made from Stack made from array Vector
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class VectorSpan{
	public static int[] span2(double[] x, int n) throws EmptyStackException{
		int[] S = new int[n];
		VectorStack<Integer> A = new VectorStack();
		for(int i = 0; i <= n - 1; i++){
			while(!(A.isEmpty()) && x[A.peek()] <= x[i]){ //if stack is not empty, and elements before current element is smaller than current element
				A.pop(); //remove element
			}
			S[i] = (A.isEmpty())? (i + 1) : (i - A.peek()); //if stack is empty, return i + 1 (current "day"), 
															//else return current day minus number of days before it that elements were less than current element
			A.push(i);
		}
		return S;
	}
	public static void main(String[] args) throws EmptyStackException{
		Random rand = new Random();
		
		double[] test = new double[100]; //for testing run time, change number here
		for(int i = 0; i < test.length; i++)
			test[i] = 1.0 + (50.0 - 1.0) * rand.nextDouble();
		System.out.println(Arrays.toString(test));
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		System.out.println(Arrays.toString(span2(test, test.length)));
		//span2(test, test.length); //testing sequence, as printing out 1000000 array elements is long, and takes up computing time
		long endTime = System.currentTimeMillis();
		System.out.println(endTime);
		long t = endTime - startTime;
		System.out.println(t);
		
		//with a really large number for my starting array (57474836), computing time was 10283 (on my laptop, which runs an i3-5010U, 2.1GHz)
		
	}
	
}