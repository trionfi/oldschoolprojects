public interface Sequence<E> extends Deque<E>, IndexList<E>, PositionList<E>{
	public Position<E> atIndex(int r) throws BoundaryViolationException;
	public int indexOf(Position<E> p) throws InvalidPositionException;
}