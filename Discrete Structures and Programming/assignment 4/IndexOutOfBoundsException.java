public class IndexOutOfBoundsException extends Exception{
	public IndexOutOfBoundsException(){
		super("Out of Index Boundries");
	}
	public IndexOutOfBoundsException(String input){
		super(input);
	}
}