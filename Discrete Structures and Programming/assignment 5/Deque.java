public interface Deque<E> {
  public int size(); //size of deque
  public boolean isEmpty(); //return whether deque is empty
  public E getFirst(); //return first element
  public E getLast(); //return last element
  public void addFirst(E e); //add element at beginning
  public void addLast(E e); //add element at end
  public E removeFirst(); //remove element at beginning
  public E removeLast(); //remove element at end
}
