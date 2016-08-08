package com.daniellfeijo.personaltasksmanager.system.exception;

public class ExistEmailException extends Exception {
	 private static final long serialVersionUID = 1149241039423861915L;

	    // constrói um objeto NumeroNegativoException com a mensagem passada por parâmetro
	    public ExistEmailException(String msg){
	        super(msg);
	    }

	    // contrói um objeto NumeroNegativoException com mensagem e a causa dessa exceção, utilizado para encadear exceptions
	    public ExistEmailException(String msg, Throwable cause){
	        super(msg, cause);
	    }

}
