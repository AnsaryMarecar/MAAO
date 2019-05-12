package org.secure.retirement.home.common.exception;

/**
 * <p> manage Configuration exception </p>
 * 
 * @author ansary.marecar
 *
 */
public class DAOConfigurationException extends RuntimeException {
	/**
	 * <p>Constructor</p>
	 * 
	 * @param 	param_message
	 * @return
	 * @author 	ansary.marecar
	 */
	public DAOConfigurationException(String param_message) {
		super(param_message);
	}
	
	/**
	 * <p>Constructor</p>
	 * 
	 * @param 	param_message
	 * @param 	param_cause
	 * @author 	ansary.marecar
	 */
	public DAOConfigurationException(String param_message, Throwable param_cause) {
		super(param_message, param_cause);
	}
	
	/**
	 * <p>Constructor</p>
	 * 
	 * @param 	param_cause
	 * @return
	 * @author 	ansary.marecar
	 */
	public DAOConfigurationException(Throwable param_cause) {
		super(param_cause);
	}
}