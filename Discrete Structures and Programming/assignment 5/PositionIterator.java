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
      cursor = after(cursor);
      return recent;
    }

    /**
     * Removes the element returned by most recent call to next.
     * @throws IllegalStateException if next has not yet been called
     * @throws IllegalStateException if remove was already called since recent next
     */
    public void remove() throws IllegalStateException {
      if (recent == null) throw new IllegalStateException("nothing to remove");
      LinkedPositionalList.this.remove(recent);         // remove from outer list
      recent = null;               // do not allow remove again until next is called
    }
  } //------------ end of nested PositionIterator class ------------

  //---------------- nested PositionIterable class ----------------
  private class PositionIterable implements Iterable<Position<E>> {
    public Iterator<Position<E>> iterator() { return new PositionIterator(); }
  } //------------ end of nested PositionIterable class ------------
  //---------------- nested ElementIterator class ----------------
  /* This class adapts the iteration produced by positions() to return elements. */
  private class ElementIterator implements Iterator<E> {
    Iterator<Position<E>> posIterator = new PositionIterator();
    public boolean hasNext() { return posIterator.hasNext(); }
    public E next() { return posIterator.next().getElement(); } // return element!
    public void remove() { posIterator.remove(); }
  }