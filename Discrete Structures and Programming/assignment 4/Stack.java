interface Stack<E>{
	public boolean isEmpty();
	public E pop() throws EmptyStackException;
	public void push(E element);
	public int size();
	public E peek() throws EmptyStackException;
}