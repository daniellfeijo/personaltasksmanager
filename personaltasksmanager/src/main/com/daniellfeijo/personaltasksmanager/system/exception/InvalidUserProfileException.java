package main.com.daniellfeijo.personaltasksmanager.system.exception;

public class InvalidUserProfileException extends Exception {
	 private static final long serialVersionUID = 2349371042423861915L;

	    // 
	    public InvalidUserProfileException(String msg){
	        super(msg);
	    }

	    //
	    public InvalidUserProfileException(String msg, Throwable cause){
	        super(msg, cause);
	    }

}
