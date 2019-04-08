package org.secure.retirement.home.common;


/**
 * @author ansary.marecar
 *
 */

public class DAOException extends RuntimeException {
	
	/**
	 * <p>Constructor</p>
	 * 
	 * @param param_message
	 * @return
	 * @author Ansary MARECAR
	 */
	public DAOException(String param_message) {
		super(param_message);
	}
    
	/**
     * <p>Constructor</p>
     * 
     * @param param_message
     * @param param_cause
     */
	public DAOException(String param_message, Throwable param_cause) {
		super(param_message, param_cause);
    }

	/**
     * <p>Constructor</p>
     * 
     * @param param_cause
     * @return
     * @author ansary.marecar 
     */
    public DAOException(Throwable param_cause) {
        super(param_cause);
    }
}