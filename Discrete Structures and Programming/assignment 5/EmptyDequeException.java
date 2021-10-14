public class EmptyDequeException extends RuntimeException{
	public EmptyDequeException(){
		super("Deque is Empty");
	}
	public EmptyDequeException(String input){
		super(input);
	}
}