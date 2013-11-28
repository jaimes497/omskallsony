package co.com.kallsony.exception;

public class DALException extends Exception {

	private static final long serialVersionUID = -2424921044728010255L;
	private	String mensaje;
	
	public DALException(){
		super();
		mensaje = "Error del Sistema";
	}
	
	public DALException(String error){
		super(error);
		mensaje = error;
	}
	
	public String getError(){
		return mensaje;
	}

}
