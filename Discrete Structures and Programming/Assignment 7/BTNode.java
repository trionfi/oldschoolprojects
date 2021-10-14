/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: February 25, 2017
	Course: 62:206 Discrete Structures and Programming
	Instructor: Chenkuan Li
	Program: BTNode
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class BTNode<E> implements BTPosition<E>{
   private E element;
   private BTPosition<E> left, right, parent;
   
   public BTNode(){
	   element = null;
	   parent = null;
	   left = null;
	   right = null;
   }
   public BTNode(E e, BTPosition<E> par, BTPosition<E> inLeft, BTPosition<E> inRight){
      setElement(e);
	  setParent(par);
	  setLeft(inLeft);
	  setRight(inRight);
   }
   public E element( ){ //return element
      return element;
   }
   public BTPosition<E> getParent( ){ //return parent
	   return parent;
   }
   public BTPosition<E> getLeft( ){ //return left
      return left;                                               
   } 
   public BTPosition<E> getRight( ){ //return right
      return right;                                               
   }

   public boolean isExternal( ){ //return whether node is external
      return (left == null) && (right == null);                                               
   } 

   public void setElement(E e){ //set new element
      element = e;
   }                                                               
   public void setLeft(BTPosition<E> newLeft){ //set left
      left = newLeft;
   }
   public void setRight(BTPosition<E> newRight){ //set right       
      right = newRight;
   }
   public void setParent(BTPosition<E> newParent){ //set parent
	   parent = newParent;
   }
}