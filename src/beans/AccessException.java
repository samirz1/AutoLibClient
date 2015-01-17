package beans;

public class AccessException extends Exception {
	private static final long serialVersionUID = 1L;

	public AccessException(String message) {
		super(message);
	}
	
	public AccessException(String message, Exception e) {
		super(message, e);
	}
}
