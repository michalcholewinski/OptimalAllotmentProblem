package oap.utils.exceptions;

public class NonUniqueDataException extends MyException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message = null;

	public NonUniqueDataException() {
		super();
	}
	
	public NonUniqueDataException(String message){
		super();
		this.message=message;
	}
	
	public NonUniqueDataException(Throwable cause){
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
