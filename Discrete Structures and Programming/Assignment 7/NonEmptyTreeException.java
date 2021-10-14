public class NonEmptyTreeException extends RuntimeException{
	public NonEmptyTreeException(){
		super("Out of Boundry");
	}
	public NonEmptyTreeException(String input){
		super(input);
	}
}