public class InvalidPositionException extends RuntimeException{
	public InvalidPositionException(){
		super("Invalid Position");
	}
	public InvalidPositionException(String input){
		super(input);
	}
}