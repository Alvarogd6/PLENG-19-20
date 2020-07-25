package lib.exceptions;

public class ModuloDeCeroException extends Exception { 
	private static final long serialVersionUID = 1L;

	public ModuloDeCeroException(String errorMessage) {
        super(errorMessage);
    }
}