package lib.exceptions;

public class SimboloNoEncontradoException extends Exception { 
	private static final long serialVersionUID = 1L;

	public SimboloNoEncontradoException(String errorMessage) {
        super(errorMessage);
    }
}