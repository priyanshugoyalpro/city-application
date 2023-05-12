package com.sg.citylistapp.exception;

/**
 * @author priyanshu.goyal
 *
 */
public class CityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String message;

	public int errorcode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}

	public CityNotFoundException(int errorcode, String message) {
		this.errorcode = errorcode;
		this.message = message;

	}

}
