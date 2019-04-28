/**
 * 
 */
package org.secure.retirement.home.common;

/**
 * @author Ansary MARECAR
 *
 */
public class Send_information {
	


	

	private String  send_information_table;
	private String	send_information_crud_action;
	
	/**
	 * 
	 */
	public Send_information() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param send_information_table
	 * @param send_information_crud_action
	 */
	public Send_information(String send_information_table, String send_information_crud_action) {
		super();
		this.send_information_table = send_information_table;
		this.send_information_crud_action = send_information_crud_action;
	}
	
	/**
	 * @return the send_information_table
	 */
	public String getSend_information_table() {
		return send_information_table;
	}

	/**
	 * @param send_information_table the send_information_table to set
	 */
	public void setSend_information_table(String send_information_table) {
		this.send_information_table = send_information_table;
	}

	/**
	 * @return the send_information_crud_action
	 */
	public String getSend_information_crud_action() {
		return send_information_crud_action;
	}

	/**
	 * @param send_information_crud_action the send_information_crud_action to set
	 */
	public void setSend_information_crud_action(String send_information_crud_action) {
		this.send_information_crud_action = send_information_crud_action;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Send_information [getSend_information_table()=" + getSend_information_table()
				+ ", getSend_information_crud_action()=" + getSend_information_crud_action() + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
