/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: October 28, 2016
	Course: 62:206 Discrete Structures and Programming
	Instructor: Chenkuan Li
	Program: stack array, and reverse
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything
import java.lang.*;

public class ArrayStack<E> implements Stack<E>{
	protected int capacity; //actual capacity of the stack array
	public static final int CAPACITY = 1000; //default array capacity
	protected E[] S; //Generic array used to implement the stack
	protected int top = -1; //index for the top of the stack
	@SuppressWarnings("unchecked")
	public ArrayStack(){
		this(CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public ArrayStack(int input){
		capacity = input;
		S = (E[]) new Object[capacity];
	}
	public boolean isEmpty(){
		return top == -1;
	}
	public E peek() throws EmptyStackException{
		if(isEmpty())
			throw new EmptyStackException("Stack is Empty");
		return S[top];
	}
	public E pop() throws EmptyStackException{
		E element;
		if(isEmpty())
			throw new EmptyStackException("Stack is Empty");
		
		element = S[top];
		S[top--] = null;
		
		return (E)element;
		
	}
	public void push(E element){
		if(size() == S.length)
			expandCapacity();
		
		S[++top] = element;
		
	}
	public int size(){
		return (top + 1);
	}
	
	public String toString(){
		String output = "";
		
		for (int i = 0; i <= top; i++){
			output = output + S[i] + "\n";
		}
		
		return output;
	}
	
	private void expandCapacity(){
		E[] expand = (E[]) new Object[S.length * 2];
		
		for(int i = 0; i < S.length; i++){
			expand[i] = S[i];
		}
		
		S = expand;
	}
	
	private void reverseStackRecusion() throws EmptyStackException{
		if(isEmpty()) //when stack is empty, end recusion
			return;
		
		E bottom = placeBottom(); //get the bottom element of the stack
		
		reverseStackRecusion(); //reverse the rest of the stack
		
		push(bottom); //place found bottom element on top of reversed stack
	}
	private E placeBottom() throws EmptyStackException{
		E top = pop(); //remove top element from stack and store
		if (isEmpty())
			return top; //if stack is empty (after pop), return the found top
		else{
			E bottom = placeBottom(); //find bottom element of stack
			push(top); //put top element back where it was originally
			return bottom; //return bottom element
		}
	}
	public static<E> E[] reverse(E[] array) throws EmptyStackException{
		ArrayStack<E> S = new ArrayStack<E>();
		E[] A = (E[]) new Object[array.length];
		for(int i = 0; i < array.length; i++){
			S.push(array[i]);
		}
		
		for(int i = 0; i < array.length; i++){
			A[i] = S.pop();
		}
		return A;
	}
	public static<E> String toString(E[] input){
		String output = "";
		for(int i = 0; i < input.length; i++)
			output = output + input[i] + "\n";
		
		return output;
		
	}
	
	public static void main(String[] args) throws EmptyStackException{
		/*ArrayStack<Integer> intArray = new ArrayStack<Integer>();
		ArrayStack<String> strArray = new ArrayStack<String>();
		
		intArray.push(1);
		intArray.push(2);
		intArray.push(3);
		intArray.push(4);
		intArray.push(5);
		
		System.out.println(intArray.toString());
		
		intArray.reverseStackRecusion();
		
		System.out.println(intArray.toString());
		
		strArray.push("Hello");
		strArray.push("How");
		strArray.push("Are");
		strArray.push("You");
		
		System.out.println(strArray.toString());
		
		strArray.reverseStackRecusion();
		
		System.out.println(strArray.toString());*/
		
		Integer[] intArray = {1, 2, 3, 4, 5};
		String[] strArray = {"Hello", "How", "Are", "You"};
		
		
		System.out.println(toString(strArray));
		
		System.out.println(toString(reverse(strArray)));
		
	}
	

}