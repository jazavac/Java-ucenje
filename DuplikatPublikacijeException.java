package hr.tvz.java.vjezbe.iznimke;

public class DuplikatPublikacijeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6136110900989839835L;

	public DuplikatPublikacijeException() {
		super("Duplikat publikacije!");
	}
	
	public DuplikatPublikacijeException(String message) {
		super(message);
	}
	
	public DuplikatPublikacijeException(Throwable cause) {
		super(cause);
	}
	
	public DuplikatPublikacijeException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
