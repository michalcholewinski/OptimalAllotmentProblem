package oap.utils.exceptions;

public class CannotAddElementException extends MyException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message = null;

	public CannotAddElementException() {
		super();
	}

	public CannotAddElementException(String message) {
		super();
		this.message = message;
	}

	public CannotAddElementException(Throwable cause) {
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
