import java.util.Iterator;
public class FavoriteList<E>  {

  protected PositionList<Entry<E>> fList;               // List of entries

  /** Constructor; O(1) time */

  public FavoriteList() { fList = new NodePositionList<Entry<E>>(); }
  
  public int size(){
	  return fList.size();
  }
  public boolean isEmpty(){
	  return fList.isEmpty();
  }
  public void remove(E e){
	  Position<Entry<E>> p = find(e);
	  if (p != null)
		  fList.remove(p);
	  
  }
 
 	/**
	 * Increments the access count for the given element and inserts it if it is
	 * not already present;
	 */
	public void access(E e) {
		Position<Entry<E>> p = find(e); // find the position of obj
		if (p != null) {
			p.element().incrementCount(); // increment access count
		} else {
			fList.addLast(new Entry<E>(e)); // add the new entry at the end
			p = fList.last();
		}
		moveUp(p); // moves the entry to its final position
	}
  
  protected Position<Entry<E>> find(E e) {
	  if(fList.isEmpty())
		  return null;
	  else{
	  Position<Entry<E>> p = fList.first();
	 // Iterator<E> it = fList.iterator();
	//for(int i = 0; i < fList.size() - 1; i++){
		int i = 1;
	while(fList.iterator().hasNext()){
		if (value(p).equals(e))
			return p; // found at position p
		else{
			if(i == fList.size())
				return null;
			else
			p = fList.next(p);
		}
		i++;
	}
	  }
	return null; // not found
	}
	/** Moves up an entry to its correct position in the list; O(n) time */
	protected void moveUp(Position<Entry<E>> cur) {
		Entry<E> e = cur.element();
		int c = count(cur);
		while (cur != fList.first()) {
			Position<Entry<E>> prev = fList.prev(cur); // previous position
			if (c <= count(prev))
				break; // entry is at correct position
			fList.set(cur, prev.element()); // move down previous entry
			cur = prev;
		}
		fList.set(cur, e); // store the entry in its final position
	}

	/** Returns the k most accessed elements, for a given k; O(k) time */
	public NodePositionList<E> top(int k) {
		if (k < 0 || k > size())
			throw new IllegalArgumentException("Invalid argument");
		NodePositionList<E> T = new NodePositionList<E>(); // top-k list
		int i = 0; // counter of the entries added to the list
		//Position<Entry<E>> e = fList.first();
		for(Position<Entry<E>> e : fList.positions()) {
			if (i++ >= k)
				break; // all the k entries have been added
			T.addLast(e.element().value()); // add one entry to the list
		}
		return T;
	}

	/** String representation of the favorite list */
	public String toString() {
		return fList.toString();
	}
	public String toString(NodePositionList<E> e){
		return e.toString();
	}

	/** Helper method that extracts the value of the entry at a given position */
	protected E value(Position<Entry<E>> p) {
		return (p.element()).value();
	}

	/** Helper method that extracts the counter of the entry at a given position */
	protected int count(Position<Entry<E>> p) {
		return (p.element()).count();
	}
	
	
	
	/** Inner class storing elements and their access counts. */
	protected static class Entry<E> {
		private E value; // element

		private int count; // access count

		/** Constructor */
		Entry(E v) {
			count = 1;
			value = v;
		}

		/** Returns element */
		public E value() {
			return value;
		}

		/** return count */
		public int count() {
			return count;
		}

		/** add to the count */
		public int incrementCount() {
			return ++count;
		}

		/** String of entry */
		public String toString() {
			return "[" + count + "," + value + "]";
		}
	}
	public static void main(String[] args){
		FavoriteList<String> test = new FavoriteList();
		
		test.access("1");
		test.access("2");
		test.access("3");
		test.access("5");
		test.access("6");
		test.access("4");
		test.access("1");
		test.access("1");
		test.access("2");
		
		System.out.println(test.toString());
		System.out.println(test.toString(test.top(3)));
		
		test.access("3");
		test.access("5");
		test.access("1");
		test.remove("2");
		
		System.out.println(test.toString());
		System.out.println(test.toString(test.top(3)));
	}
}