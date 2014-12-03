package oap.utils.exceptions;

public class NotCompleteDataException extends MyException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message = null;

	public NotCompleteDataException() {
		super();
	}

	public NotCompleteDataException(String message) {
		super();
		this.message = message;
	}

	public NotCompleteDataException(Throwable cause) {
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
