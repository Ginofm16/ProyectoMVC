package com.tcs.app.utilitario;

import java.io.Serializable;


public class Response implements Serializable{
	/*esta clase nos ayudara a encapsular la respuesta de nuestros servicios
	 * La respuesta se pondra en el atributo body*/

	private static final long serialVersionUID = 1L;
	
	private Error error;
	
	private Object body;

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}
		
	

}
