/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: November 24, 2016
	Course: 62:206
	Instructor: Dr. Li
	Program: Stack made from Vector class
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class VectorStack<E> extends IndexList<E> implements Stack<E>{
	public VectorStack(){
		super(CAPACITY); //use capacity and constructor in IndexList
	}
	public VectorStack(int cap){ //use capacity and constructor in IndexList
		super(cap);
	}
	public E peek() throws EmptyStackException{ //also known as top. turn element on top
		if(isEmpty())
			throw new EmptyStackException("Stack is Empty");
		try{
			return get(size() - 1);
		}
		catch(IndexOutOfBoundsException e){
			return null;
		}
	}
	public void push(E element){ //add element to top of stack. uses add from IndexList and current size.
		try{
			add(size(), element);
		}
		catch(IndexOutOfBoundsException e){
			
		}
	}
	public E pop() throws EmptyStackException{ //remove top element.
		if(isEmpty())
			throw new EmptyStackException("Stack is Empty");
		try{
			return remove(size() - 1); //since IndexList uses an array, the top element is the current size - 1 to get the correct index
		}
		catch(IndexOutOfBoundsException e){
			return null;
		}
	}
	public static void main(String[] args) throws IndexOutOfBoundsException, EmptyStackException{ //testing shenanigans
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
		VectorStack<Integer> test = new VectorStack();
		for(int i = 0; i < array.length; i++)
			test.push((Integer) array[i]);
		System.out.println(test.toString());
		/*test.add(3, 4);
		System.out.println(test.toString());
		System.out.println(test.remove(5));
		System.out.println(test.toString());
		System.out.println(test.get(4));
		System.out.println(test.set(4, 6));
		System.out.println(test.toString());*/
		
	}
}