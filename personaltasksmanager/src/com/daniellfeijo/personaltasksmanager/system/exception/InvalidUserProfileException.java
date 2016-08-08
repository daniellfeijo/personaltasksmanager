package com.daniellfeijo.personaltasksmanager.system.exception;

public class InvalidUserProfileException extends Exception {
	 private static final long serialVersionUID = 2349371042423861915L;

	    // constrói um objeto NumeroNegativoException com a mensagem passada por parâmetro
	    public InvalidUserProfileException(String msg){
	        super(msg);
	    }

	    // contrói um objeto NumeroNegativoException com mensagem e a causa dessa exceção, utilizado para encadear exceptions
	    public InvalidUserProfileException(String msg, Throwable cause){
	        super(msg, cause);
	    }

}
