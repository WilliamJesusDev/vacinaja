package io.github.williamjesusdev.vacinaja.exception;

public class DuplicateKeyException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DuplicateKeyException(String message){
        super(message);
    }

    public DuplicateKeyException(String message, Throwable cause){
        super(message,cause);
    }

}
