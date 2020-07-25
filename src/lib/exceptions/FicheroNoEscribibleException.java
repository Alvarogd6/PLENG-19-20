package lib.exceptions;

public class FicheroNoEscribibleException extends Exception { 
	private static final long serialVersionUID = 1L;

	public FicheroNoEscribibleException(String errorMessage) {
        super(errorMessage);
    }
}