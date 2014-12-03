package oap.utils.exceptions;

public class ElementExistInDatabaseException extends MyException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message = null;

	public ElementExistInDatabaseException() {
		super();
	}
	
	public ElementExistInDatabaseException(String message){
		super();
		this.message=message;
	}
	
	public ElementExistInDatabaseException(Throwable cause){
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
