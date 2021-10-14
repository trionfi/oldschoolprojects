public class EmptyStackException extends Exception{
	public EmptyStackException(){
		super("Error: Stack is Empty.");
	}
	public EmptyStackException(String input){
		super(input);
	}
}