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


 /** Returns an iterator of all the elements in the list. */
  public Iterator<E> iterator() { return new ElementIterator<E>(this); }

  /** Returns an iterable collection of all the nodes in the list. */
  public Iterable<Position<E>> positions()
  {  // create a list of positions
    PositionList<Position<E>> P = new NodePositionList<Position<E>>();

    if (!isEmpty())
    {
      Position<E> p = first();
      while (true)
      {
        P.addLast(p); // add position p as the last element of list P
        if (p == last())
          break;
        p = next(p);
      }
    }
    return P; // return P as our Iterable object
  }
	
  /** Swap the elements at two given positions;  O(1) time */
  public void swapElements(Position<E> a, Position<E> b)
      throws InvalidPositionException
  {
    DNode<E> pA = checkPosition(a);
    DNode<E> pB = checkPosition(b);
    E temp = pA.element();
    pA.setElement(pB.element());
    pB.setElement(temp);
  }

  public static void main(String[] args){
	  NodePositionList<String> test = new NodePositionList<String>();
	  for(int i = 0; i < 20; i++){
		  String m = "" + i;
		  test.addLast(m);
	  }
	  
	  for(String e: test)
		System.out.println(e);
		  
  }
}