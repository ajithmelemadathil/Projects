package exception;

public class DataNotFoundException extends RuntimeException{
	String message;

	public DataNotFoundException(String message) {
		
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	

}
