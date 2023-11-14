package exception;

public class EmployeeNotFoundException extends RuntimeException{
	String message;

	public EmployeeNotFoundException(String message) {
	
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	

}
