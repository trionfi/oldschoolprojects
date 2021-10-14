public class EmptyTreeException extends RuntimeException{
	public EmptyTreeException(){
		super("Empty Tree");
	}
	public EmptyTreeException(String input){
		super(input);
	}
}