package edu.utils.errors;

public class JDBCSQLconfigExceptions extends RuntimeException {

		public JDBCSQLconfigExceptions(String message) {
			super(message);
		}
		
		public JDBCSQLconfigExceptions(String message,Throwable cause){
			super(message,cause);
		}
		
		public JDBCSQLconfigExceptions(Throwable cause){
			super(cause);
		}
}
