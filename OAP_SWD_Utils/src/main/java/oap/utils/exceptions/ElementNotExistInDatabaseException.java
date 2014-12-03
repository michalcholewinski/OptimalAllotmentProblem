package oap.utils.exceptions;

public class ElementNotExistInDatabaseException extends MyException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message = null;

	public ElementNotExistInDatabaseException() {
		super();
	}
	
	public ElementNotExistInDatabaseException(String message){
		super();
		this.message=message;
	}
	
	public ElementNotExistInDatabaseException(Throwable cause){
		super(cause);
	}
	
	@Override
	public String toString() {
		return message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
