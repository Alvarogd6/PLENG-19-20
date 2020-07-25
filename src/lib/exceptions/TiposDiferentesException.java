package lib.exceptions;

public class TiposDiferentesException extends Exception { 
	private static final long serialVersionUID = 1L;

	public TiposDiferentesException(String errorMessage) {
        super(errorMessage);
    }
}