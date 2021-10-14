import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ArrayListCompleteBinaryTree<E> extends LinkedBinaryTree<E> implements CompleteBinaryTree<E> {
	protected ArrayList<Position<E>> Q; //indexed list of Linked Binary Tree positions
	protected ArrayList<BTPos<E>> T;  // indexed list of tree positions

  /** Nested class for a index list-based complete binary tree node. */

  protected static class BTPos<E> implements Position<E> {
    E element; // element stored at this position
    int index;      // index of this position in the array list
    public BTPos(E elt, int i) {
      element = elt;
      index = i;
    }
    public E element() { return element; }
    public int index() { return index; }
    public E setElement(E elt) {
      E temp = element;
      element = elt;
      return temp;
    }
  }
  /** default constructor */
  public ArrayListCompleteBinaryTree() {
    T = new ArrayList<BTPos<E>>();
    T.add(0, null); // the location at rank 0 is deliberately empty
	Q = new ArrayList<Position<E>>();
	Q.add(0, null);
  }
  /** Returns the number of (internal and external) nodes. */
  public int size() { return T.size() - 1; }
  /** Returns whether the tree is empty. */
  public boolean isEmpty() { return (size() == 0); }
  /** Returns whether v is an internal node. */

  public boolean isInternal(Position<E> v) throws InvalidPositionException {
    return hasLeft(v);  // if v has a right child it will have a left child
  }

  /** Returns whether v is an external node. */
  public boolean isExternal(Position<E> v) throws InvalidPositionException {
     return !isInternal(v);
  }
  public Position<E> add(E elem){
		int i = size() + 1;
		BTPos<E> pos = new BTPos<E>(elem, i);
		insert(elem);
		T.add(i, pos);
		return pos;
  }
  
  public void insert(E elem) throws InvalidPositionException{
	  int i = size() + 1;
	  if(isEmpty()){
		  addRoot(elem);
		  Q.add(root());
	  }
	  else{
		  if((i % 2) == 0){
			  insertLeft(Q.get(i / 2), elem);
			  Q.add(i, left(Q.get(i / 2)));
		  }
		  else{
			  insertRight(Q.get((i) / 2), elem);
			  Q.add(i, right(Q.get(i / 2)));
		  }
	  }
  }

  public E remove(){
	  if(isEmpty())
		  throw new EmptyTreeException("Tree is Empty");
	  remove(Q.remove(size()));
	  return T.remove(size()).element();
  }
// complete the code here and provide a main function to test add and remove methods.
  public static void main(String[] args) {
                  ArrayListCompleteBinaryTree<Integer> T = new ArrayListCompleteBinaryTree<Integer>();
                  //Random rand = new Random();
                  int n = 7;
                  int j;
				  for (int i = 0; i < n; i++){
					  //j = rand.nextInt(1000);
					  T.add(i);
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
                  int count = 0;
                  for (Integer in: T.iterator()) {
 
                      System.out.print(in + " ");
                      ++count;
                      if(count % 10==0)
                        System.out.println();
                                }
         System.out.println();
					System.out.println("We remove the last four elements and print out the tree");
					T.remove();
					T.remove();
					T.remove();
					T.remove();
                  count = 0;
                  for (Integer in: T.iterator()) {
 
                      System.out.print(in + " ");
                      ++count;
                      if(count % 10==0)
                        System.out.println();
                                }
                     System.out.println();
  }
}