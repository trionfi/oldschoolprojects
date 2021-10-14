/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: January 12, 2016
	Course: 62:206
	Instructor: Dr. Li
	Program: NodeSequence main program
	*~*~*~*~*~*~*~* */
import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class NodeSequence<E extends Comparable<? super E>> extends NodePositionList<E> implements Sequence<E> {

 

  /**
   * Default Constructor
   */
   public NodeSequence() {
      super();
   }
   protected void checkIndex(int i)
          throws IndexOutOfBoundsException {
      if (i < 0 || i >= size())
         throw new IndexOutOfBoundsException("Index " + i + " is out of bounds!");
   }
// from interface Sequence
  /**
   * Returns the position containing the element at the given index.
   */

   public Position<E> atIndex(int index)
          throws BoundaryViolationException {
			  checkIndex(index);
		Position<E> newPos = checkPosition(first()).getNext();
		if(index == 0)
			return first();
      for(int i = 1; i < index; i++){
		  newPos = next(newPos);
	  }
	  return newPos;
		  
		  
   }
  /**

   * Returns the index of the element stored at the given position.

   */
   public int indexOf(Position<E> p)

          throws InvalidPositionException {

    checkPosition(p);
	
	int count = 0;
	DNode current = header.getNext();
	if (current == p)
		return count;
	else{
	while(current != p){
		count++;
		current = current.getNext();
	}
	return count;
	}
   }

 

 

 

// from interface Deque

 

  /**

   * Returns the first element; an exception is thrown if sequence is empty.

   */

   public E getFirst()

          throws EmptyDequeException {

      return first().element();

   }

 

  /**

   * Returns the last element; an exception is thrown if sequence is empty.

   */

   public E getLast()

          throws EmptyDequeException {

      return last().element();

   }

 

  /**

   * Removes the first element; an exception is thrown if sequence is empty.

   */

   public E removeFirst()

          throws EmptyDequeException {

      return remove(first());

   }

 

  /**

   * Removes the last element; an exception is thrown if sequence is empty.

   */

   public E removeLast()

          throws EmptyDequeException {

      return remove(last());

   }

 

 

 

// from interface IndexList

 

  /**

   * Inserts an element e to be at index i, shifting all elements after this.

   */

   public void add(int i, E e)

          throws IndexOutOfBoundsException {

      checkIndex(i);

 

      if (i == numElts) {

         addLast(e);

      } else {

                                addBefore(atIndex(i), e);

                  }

   }

 

  /**

   * Returns the element at index i, without removing it.

   */

   public E get(int i)

          throws IndexOutOfBoundsException {

      checkIndex(i);

 

      return atIndex(i).element();

   }

 

  /**

   * Removes and returns the element at index i, shifting the elements after this.

   */

   public E remove(int i)

          throws IndexOutOfBoundsException {

      checkIndex(i);

 

      return remove(atIndex(i));

   }

 

  /**

   * Replaces the element at index i with e, returning the previous element at i.

   */

   public E set(int i, E e)

          throws IndexOutOfBoundsException {

      checkIndex(i);

      return set(atIndex(i), e);

   }
// from interface iterable

   public java.util.Iterator<E> iterator() {
      return new ElementIterator();

   } 

// other fuctions

//   public String toString() {

//     return this.toString();

 //  }

	private void bubbleSort(NodeSequence<E> input) {
		int n = input.size();
		E temp = null;
		E compare1 = null;
		E compare2 = null;
		for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
				compare1 = input.atIndex(j - 1).element();
				compare2 = input.atIndex(j).element();
                if(compare1.compareTo(compare2) > 0){
                 //swap the elements!
                    temp = input.set(input.atIndex(j -1), input.atIndex(j).element());
                    temp = input.set(input.atIndex(j), temp);
					}
					}
                }
        }
	public void mergeSort(NodeSequence<E> numbers) {
		if (size() < 2)
			return;
		NodeSequence<E> temp = new NodeSequence();
		for(int i = 0; i < numbers.size(); i++)
			temp.addLast(null);
		m_sort(numbers, temp, 0, size() - 1); 
		}
	public void m_sort(NodeSequence<E> numbers, NodeSequence<E> temp, int left, int right) {
		int mid;
		if (right > left){
			mid = (right + left) / 2;
		m_sort(numbers, temp, left, mid);
		m_sort(numbers, temp, mid+1, right);
		merge(numbers, temp, left, mid+1, right);
		}
	}

	public void merge(NodeSequence<E> numbers, NodeSequence<E> temp, int left, int mid, int right) {
		int i, left_end, num_elements, tmp_pos;
		left_end = mid - 1;
		tmp_pos = left;
		num_elements = right - left + 1;
		while ((left <= left_end) && (mid <= right)){
			E compare1 = numbers.atIndex(left).element();
			E compare2 = numbers.atIndex(mid).element();
			if ((compare1.compareTo(compare2)) <= 0){
				E temp1 = numbers.atIndex(left).element();
				temp.set(tmp_pos, temp1);
				tmp_pos = tmp_pos + 1;
				left = left +1;
				}
			else{
				E temp2 = numbers.atIndex(mid).element();
					temp.set(tmp_pos, temp2);
				tmp_pos = tmp_pos + 1;
				mid = mid + 1;
				}
		}
		while (left <= left_end){
			E temp3 = numbers.atIndex(left).element();
			temp.set(tmp_pos, temp3);
			left = left + 1;
			tmp_pos = tmp_pos + 1;
			}
		while (mid <= right){
			E temp4 = numbers.atIndex(mid).element();
			temp.set(tmp_pos, temp4);
			mid = mid + 1;
			tmp_pos = tmp_pos + 1;
		}
		for (i=0; i <= num_elements; i++){
			if(right > -1){
			E temp5 = temp.atIndex(right).element();
			numbers.set(right, temp5);
			right = right - 1;
			}
		}
	}
	

   
     public static void main(String[] args){
	  NodeSequence<Integer> test = new NodeSequence();
	  Random rand = new Random();
	for(int i = 0; i < 1000; i++)
			test.addLast((rand.nextInt(50 - 1)) + 1);
		
	//	System.out.println(test.atIndex(0).element() + " " + test.atIndex(1).element());
	long startTime = System.currentTimeMillis();
	System.out.println(startTime);
	  
	  //System.out.println(test.toString());
	//  test.bubbleSort(test);  //run timing: 1967
	 test.mergeSort(test); //running time: 128
	  //System.out.println(test.toString());
	  	long endTime = System.currentTimeMillis();
		System.out.println(endTime);
		long t = endTime - startTime;
		System.out.println(t);
	  
	  //System.out.println(test.atIndex(5).element());
	  
	  //Position<Integer> pos = test.atIndex(11);
	//  System.out.println(pos.element());
	  
	  //System.out.println(test.indexOf(pos));
		  
  }

}