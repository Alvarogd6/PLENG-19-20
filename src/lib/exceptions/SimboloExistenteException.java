package lib.exceptions;

public class SimboloExistenteException extends Exception { 
	private static final long serialVersionUID = 1L;

	public SimboloExistenteException(String errorMessage) {
        super(errorMessage);
    }
}