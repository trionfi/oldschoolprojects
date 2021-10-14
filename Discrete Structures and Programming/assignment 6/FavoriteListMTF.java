import java.util.Iterator;
import java.lang.Iterable;
public class FavoriteListMTF<E> extends FavoriteList<E>{
	protected void moveUp(Position<Entry<E>> cur) {
		fList.addFirst(fList.remove(cur));
	}

		/** Returns the k most accessed elements, for a given k; O(k) time */
	public NodePositionList<E> top(int k) {
		if (k < 0 || k > size())
			throw new IllegalArgumentException("Invalid argument");
		NodePositionList<E> T = new NodePositionList<E>(); // top-k list
		NodePositionList<Entry<E>> C = new NodePositionList<Entry<E>>();
			for(Position<Entry<E>> e : fList.positions())
				C.addLast(e.element()); // add one entry to the list
			for(int j = 0; j<k; j++){
				Position<Entry<E>> maxPos = C.first();
				Position<Entry<E>> walk = C.next(maxPos);
				while (walk != null){
					if(count(walk) > count(maxPos))
						maxPos = walk;
					if (walk != C.last())
						walk = C.next(walk);
					else
						walk = null;
				}
				T.addLast(value(maxPos));
				C.remove(maxPos);
			}
		return T;
	}
		public static void main(String[] args){
		FavoriteListMTF<String> test = new FavoriteListMTF();
		
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