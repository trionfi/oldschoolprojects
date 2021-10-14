import java.util.Iterator;

public class NodePositionList<E> implements PositionList<E>
{
  protected int numElts;               // Number of elements in the list
  protected DNode<E> header, trailer;  // Special sentinels

  /** Constructor that creates an empty list*/
  public NodePositionList()
  {
    numElts = 0;
    header = new DNode<E>(null, null, null); // create header
    trailer = new DNode<E>(header, null, null); // create trailer
    header.setNext(trailer);  // make header and trailer point to each other
  }

  /** Checks if position is valid for this list and converts it to
    *  DNode if it is valid*/
  protected DNode<E> checkPosition(Position<E> p) throws InvalidPositionException
  {
    if (p == null)
      throw new InvalidPositionException("Null position passed to NodeList");

    if (p == header)
      throw new InvalidPositionException("The header node is not a valid position");

    if (p == trailer)
      throw new InvalidPositionException("The trailer node is not a valid position");

    try
    {
      DNode<E> temp = (DNode<E>) p;
      if ((temp.getPrev() == null) || (temp.getNext() == null))
        throw new InvalidPositionException("Position does not belong to a valid NodeList");
      return temp;
    }
    catch (ClassCastException e)
    {
      throw new InvalidPositionException("Position is of wrong type for this list");
    }
  }

  /** Returns the number of elements in the list*/
  public int size(){ 
  return numElts; }

  /** Returns whether the list is empty*/
  public boolean isEmpty(){
	  return (numElts == 0); }

  /** Returns the first position in the list*/
  public Position<E> first() throws EmptyListException{
    if(isEmpty())
      throw new EmptyListException("List is empty");
    return header.getNext();
  }
	/** Returns the last position in the list*/
  public Position<E> last() throws EmptyListException{
	  if(isEmpty())
		  throw new EmptyListException("List is Empty");
	  return trailer.getPrev();
	  
  }

  /** Returns the position before the given one*/
  public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
    DNode<E> v = checkPosition(p);
    DNode<E> prev = v.getPrev();
    if (prev == header)
      throw new BoundaryViolationException("Cannot advance past the beginning of the list");
    return prev;
  }

  /** Returns the position after the given one*/
  public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
	  DNode<E> v = checkPosition(p);
	  DNode<E> next = v.getNext();
	  if (next == trailer)
		  throw new BoundaryViolationException("Cannot advance past ending of the list");
	  return next;
  }

  /** Insert the given element before the given position;*/
  public void addBefore(Position<E> p, E element) throws InvalidPositionException{
    DNode<E> v = checkPosition(p);
    numElts++;
    DNode<E> newNode = new DNode<E>(v.getPrev(), v, element);
    v.getPrev().setNext(newNode);
    v.setPrev(newNode);
  }

  /** Insert the given element after the given position;*/
  public void addAfter(Position<E> p, E element) throws InvalidPositionException{
    DNode<E> v = checkPosition(p);
    numElts++;
    DNode<E> newNode = new DNode<E>(v.getNext(), v, element);
    v.getNext().setPrev(newNode);
    v.setNext(newNode);
  }

  /** Insert the given element at the beginning of the list, returning
    * the new position*/
  public void addFirst(E element)
  {
    numElts++;
    DNode<E> newNode = new DNode<E>(header, header.getNext(), element);
    header.getNext().setPrev(newNode);
    header.setNext(newNode);
  }

  /** Insert the given element at the ending of the list, returning
    * the new position*/
  public void addLast(E element)
  {
	  if(isEmpty())
		  addFirst(element);
	  else{
		  numElts++;
		DNode<E> newNode = new DNode<E>(trailer.getPrev(), trailer, element);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
	  }
  }

  /** Remove the given position from the list*/
  public E remove(Position<E> p) throws InvalidPositionException{
    DNode<E> v = checkPosition(p);
    numElts--;
    DNode<E> vPrev = v.getPrev();
    DNode<E> vNext = v.getNext();
    vPrev.setNext(vNext);
    vNext.setPrev(vPrev);
    E vElem = v.element();
    // unlink the position from the list and make it invalid
    v.setNext(null);
    v.setPrev(null);
    return vElem;
  }

  /** Replace the element at the given position with the new element
    * and return the old element*/
  public E set(Position<E> p, E element) throws InvalidPositionException{
    DNode<E> v = checkPosition(p);
    E oldElt = v.element();
    v.setElement(element);
    return oldElt;
  }

  //toString method
public String toString() {
    StringBuilder sb = new StringBuilder("(");
    DNode<E> walk = header.getNext();
    while (walk != trailer) {
      sb.append(walk.element());
      walk = walk.getNext();
      if (walk != trailer)
        sb.append(", ");
    }
    sb.append(")");
    return sb.toString();
  }
  
  // support for iterating either positions and elements
  //---------------- nested PositionIterator class ----------------
  /**
   * A (nonstatic) inner class. Note well that each instance
   * contains an implicit reference to the containing list,
   * allowing us to call the list's methods directly.
   */
  private class PositionIterator implements Iterator<Position<E>> {

    /** A Position of the containing list, initialized to the first position. */
    private Position<E> cursor = first();   // position of the next element to report
    /** A Position of the most recent element reported (if any). */
    private Position<E> recent = null;       // position of last reported element

    /**
     * Tests whether the iterator has a next object.
     * @return true if there are further objects, false otherwise
     */
    public boolean hasNext() { return (cursor != null);  }

    /**
     * Returns the next position in the iterator.
     *
     * @return next position
     * @throws NoSuchElementException if there are no further elements
     */
    public Position<E> next() throws NoSuchElementException {
      if (cursor == null) throw new NoSuchElementException("nothing left");
      recent = cursor;           // element at this position might later be removed
      cursor = checkPosition(cursor).getNext();
      return recent;
    }

    /**
     * Removes the element returned by most recent call to next.
     * @throws IllegalStateException if next has not yet been called
     * @throws IllegalStateException if remove was already called since recent next
     */
    public void remove() throws IllegalStateException {
      if (recent == null) throw new IllegalStateException("nothing to remove");
      NodePositionList.this.remove(recent);         // remove from outer list
      recent = null;               // do not allow remove again until next is called
    }
  } //------------ end of nested PositionIterator class ------------

  //---------------- nested PositionIterable class ----------------
  private class PositionIterable implements Iterable<Position<E>> {
    public Iterator<Position<E>> iterator() { return new PositionIterator(); }
  } //------------ end of nested PositionIterable class ------------

  /**
   * Returns an iterable representation of the list's positions.
   * @return iterable representation of the list's positions
   */
  public Iterable<Position<E>> positions() {
    return new PositionIterable();       // create a new instance of the inner class
  }

  //---------------- nested ElementIterator class ----------------
  /* This class adapts the iteration produced by positions() to return elements. */
  public class ElementIterator implements Iterator<E> {
    Iterator<Position<E>> posIterator = new PositionIterator();
    public boolean hasNext() { return posIterator.hasNext(); }
    public E next() { return posIterator.next().element(); } // return element!
    public void remove() { posIterator.remove(); }
  }

  /**
   * Returns an iterator of the elements stored in the list.
   * @return iterator of the list's elements
   */
  public Iterator<E> iterator() { return new ElementIterator(); }

  // 

  public static void main(String[] args){
	  NodePositionList<Integer> test = new NodePositionList();
	  for(int i = 0; i < 20; i++){
		  test.addLast(i);
	  }
	  
	  System.out.println(test.toString());
		  
  }
}