public class BoundaryViolationException extends RuntimeException{
	public BoundaryViolationException(){
		super("Out of Boundry");
	}
	public BoundaryViolationException(String input){
		super(input);
	}
}