public interface IndexList<E>{
	public void add(int i, E e) throws IndexOutOfBoundsException; //insert element at index i, shift all elements after this
	public E get(int i) throws IndexOutOfBoundsException; //returns the element at index i, without removing it
	public boolean isEmpty(); //returns whether the list is empty
	public int size(); //returns the number of elements in the list
	public E remove(int i) throws IndexOutOfBoundsException; //removes and returns the element at index i, shifting the elements after this
	public E set(int i, E e) throws IndexOutOfBoundsException; //replaces the element at index i with e, returning the previous element at i
	
}