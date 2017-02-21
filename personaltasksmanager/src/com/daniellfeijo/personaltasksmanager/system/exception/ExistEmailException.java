package com.daniellfeijo.personaltasksmanager.system.exception;

public class ExistEmailException extends Exception {
	 private static final long serialVersionUID = 1149241039423861915L;

	    // 
	    public ExistEmailException(String msg){
	        super(msg);
	    }

	    // 
	    public ExistEmailException(String msg, Throwable cause){
	        super(msg, cause);
	    }

}
