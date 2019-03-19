package dao;

import javax.swing.JOptionPane;

/**
 * <p> manage Configuration exception </p>
 * 
 * @author ansary.marecar
 * @author : amine.maza
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
	
	private JOptionPane jo1;
	
	public DAOConfigurationException(String param_message) {
		super(param_message);
		jo1 = new JOptionPane();
		jo1.showMessageDialog(null, "Error while connecting to database", "Error", JOptionPane.ERROR_MESSAGE);
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
		jo1 = new JOptionPane();
		jo1.showMessageDialog(null, "Error while connecting to database", "Error", JOptionPane.ERROR_MESSAGE);
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
		jo1 = new JOptionPane();
		jo1.showMessageDialog(null, "Error while connecting to database", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
