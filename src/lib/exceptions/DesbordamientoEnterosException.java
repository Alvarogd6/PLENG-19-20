package lib.exceptions;

public class DesbordamientoEnterosException extends Exception { 
	private static final long serialVersionUID = 1L;

	public DesbordamientoEnterosException(String errorMessage) {
        super(errorMessage);
    }
}