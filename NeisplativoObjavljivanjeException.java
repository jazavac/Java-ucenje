package hr.tvz.java.vjezbe.iznimke;

public class NeisplativoObjavljivanjeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3898233392060588155L;

	public NeisplativoObjavljivanjeException() {
		super("Neisplativo objavljivanje!");
	}
	
	public NeisplativoObjavljivanjeException(String message) {
		super(message);
	}
	
	public NeisplativoObjavljivanjeException(Throwable cause) {
		super(cause);
	}
	
	public NeisplativoObjavljivanjeException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
