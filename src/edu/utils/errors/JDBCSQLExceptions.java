package edu.utils.errors;

public class JDBCSQLExceptions extends RuntimeException {

	public JDBCSQLExceptions(String message) {
		super(message);
	}
	
	public JDBCSQLExceptions(String message,Throwable cause){
		super(message,cause);
	}
	
	public JDBCSQLExceptions(Throwable cause){
		super(cause);
	}
	
	
}
