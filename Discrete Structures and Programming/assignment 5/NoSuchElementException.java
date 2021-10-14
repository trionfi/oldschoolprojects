public class NoSuchElementException extends RuntimeException{
	public NoSuchElementException(){
		super("No such element");
	}
	public NoSuchElementException(String input){
		super(input);
	}
}