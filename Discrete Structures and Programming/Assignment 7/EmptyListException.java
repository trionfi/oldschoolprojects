public class EmptyListException extends RuntimeException{
	public EmptyListException(){
		super("List is Empty");
	}
	public EmptyListException(String input){
		super(input);
	}
}