import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class BinarySearchSort<E extends Comparable<E>> extends LinkedBinaryTree<E>{
	public BinarySearchSort(){
		super();
	}
	
	public void add(E e){ //add elements
		if(isEmpty())
			addRoot(e);
		else{
			add(root(), e);
		}
	}
	
	public void add(Position<E> v, E e){ //add elements that are not the root
		if(e.compareTo(v.element()) < 0){
			if(!(hasLeft(v)))
				insertLeft(v, e);
			else
				add(left(v), e);
		}
		else{
			if(!(hasRight(v)))
				insertRight(v, e);
			else
				add(right(v), e);
		}
	}
	
  public String toString(){ //print out all elements in order
	  String s = "[";
	  
	  
	  for(E e : iterator()){ //iterate in order
		  s = s + e + ", ";
	  }
	  
	  s = s + "]";
	  return s;
  }
	

  public static void main(String[] args) {
                  BinarySearchSort<Integer> T = new BinarySearchSort<Integer>();
				  ArrayList<Integer> V = new ArrayList<Integer>();
                  Random rand = new Random();
                  int n = 100;
				  int j;
				  for(int i = 0; i < n; i++){
					  j = rand.nextInt(1000);
					  V.add(j);
					  T.add(j);
				  }
					
 
                  System.out.println("The size of tree is " + T.size());
                  System.out.println();
                  System.out.println("The height1 is " + T.height1(T));
                  System.out.println();
                  System.out.println("The height2 is " + T.height2(T, T.root()));
                  System.out.println();
                  System.out.println("The depth of the root is " + T.depth(T, T.root()));
                  System.out.println();
                  System.out.println("We print all elements in the tree");
                  System.out.println(V.toString());
				System.out.println("We print all the elements in order");
				System.out.println(T.toString());
         System.out.println();
                     System.out.println();
 
 
  }
}