/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 24, 2016
	Course: 62:206
	Instructor: Dr. Li
	Program: array implementation of Vector
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class IndexList<E> implements Vector<E>{
	protected E[] S;
	protected int size = 0;
	public static final int CAPACITY = 16;
	protected int capacity;
	public IndexList(){
		this(CAPACITY);
	}
	public IndexList(int x){
		capacity = x;
		S = (E[]) new Object[capacity];
		
	}
	
	public int size(){
		return size;
	}

/** Returns whether the list is empty. */

	public boolean isEmpty(){
		return size() == 0;
	}

/** Inserts an element e to be at index i, shifting all elements after this. */

	public void add(int i, E e) throws IndexOutOfBoundsException{
		checkIndex(i, size() + 1);
		if (size() == capacity){
			capacity = capacity * 2;
			E[] B = (E[]) new Object[capacity];
			for(int r = 0; r < size; r++)
				B[r] = S[r];
			S = B;
		}
		for(int t = size() - 1; t >= i; t--)
			S[t+1] = S[t];
		S[i] = e;
		size++;
		}
			

/** Returns the element at index i, without removing it. */

	public E get(int i) throws IndexOutOfBoundsException{
		checkIndex(i, size());
		return S[i];
	}

/** Removes and returns the element at index i, shifting the elements after this. */

	public E remove(int i) throws IndexOutOfBoundsException{
		checkIndex(i, size());;
		E temp = S[i];
		E[] Stemp = (E[]) new Object[S.length];
		for (int j = 0; j < i; j++)
			Stemp[j] = S[j];
		for (int j = i + 1; j < size; j++)
			Stemp[j - 1] = S[j];
		size--;
		S = Stemp;
		return temp;
	}
		

/** Replaces the element at index i with e, returning the previous element at i. */

	public E set(int i, E e) throws IndexOutOfBoundsException{
		checkIndex(i, size());;
		E temp = S[i];
		S[i] = e;
		return temp;
	}
	
	private void checkIndex(int r, int s) throws IndexOutOfBoundsException{
		if(r < 0 || r > s - 1) throw new IndexOutOfBoundsException("Out of range of Index");
	}
	public String toString(){
		String output = "" + S[0];
		for(int i = 1; i < size(); i++)
			output = output + ", " + S[i];
		return output;
	}
	/*public static void main(String[] args) throws IndexOutOfBoundsException{
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
		IndexList<Integer> test = new IndexList();
		for(int i = 0; i < array.length; i++)
			test.add(i, (Integer) array[i]);
		System.out.println(test.toString());
		test.add(3, 4);
		System.out.println(test.toString());
		System.out.println(test.remove(5));
		System.out.println(test.toString());
		System.out.println(test.get(4));
		System.out.println(test.set(4, 6));
		System.out.println(test.toString());
		
	}*/
}