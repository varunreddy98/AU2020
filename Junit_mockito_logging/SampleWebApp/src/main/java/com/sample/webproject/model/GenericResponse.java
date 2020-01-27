package com.sample.webproject.model;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "response")
public class GenericResponse {

	private boolean status;
	private String message;
	private String errorCode;
	static final Logger logger = Logger.getLogger(GenericResponse.class);

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		if(errorCode=="404")
		{
			logger.warn("page not found exception is thrown");
		}
		if(errorCode=="424")
		{
			logger.info("operation not performed correctly");
		}
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return status + "|" + message + "|" + errorCode;
	}
}