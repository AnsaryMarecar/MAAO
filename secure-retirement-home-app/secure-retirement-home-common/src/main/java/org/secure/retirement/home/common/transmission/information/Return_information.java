/**
 * 
 */
package org.secure.retirement.home.common.transmission.information;

/**
 * @author Ansary MARECAR
 *
 */
@AllArgsConstructor

public enum Return_information {
		att_success				(1,"The request was realized successfully")
	,	att_number_connection	(2,"Please try later, the network is bussy")
	,	att_notfoud				(3,"Error : Not found")
	,	att_db_not_return		(4,"Error : Insertion in the database is not return to us")
	,	att_db_cannot_insert	(5,"Error : Cannot insert data")
	,	att_intern_transmission	(6,"Error : Intern transmission")
	,	att_db_error			(7,"Error : DB Problem")
	,	att_db_cannot_delete	(8,"Error : Cannot delete data")
	,	att_db_cannot_update	(9,"Error : Cannot update data")
	,   att_db_cannot_select	(10,"Error : Cannot select data")
	
	;
	
	private int 	return_information_id	;
	private String	return_information_name	;

	/**
	 * 
	 */
	Return_information() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param return_information_id
	 * @param return_information_name
	 */
	Return_information(int return_information_id, String return_information_name) {
		this.return_information_id = return_information_id;
		this.return_information_name = return_information_name;
	}
	
	/**
	 * @return the return_information_id
	 */
	public int getReturn_information_id() {
		return return_information_id;
	}

	/**
	 * @param return_information_id the return_information_id to set
	 */
	public void setReturn_information_id(int return_information_id) {
		this.return_information_id = return_information_id;
	}
	
	/**
	 * @return the return_information_name
	 */
	public String getReturn_information_name() {
		return return_information_name;
	}

	/**
	 * @param return_information_name the return_information_name to set
	 */
	public void setReturn_information_name(String return_information_name) {
		this.return_information_name = return_information_name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Return_information [getReturn_information_id()=" + getReturn_information_id()
				+ ", getReturn_information_name()=" + getReturn_information_name() + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Return_information ri = Return_information.att_success;
		System.out.println(ri.toString());
	}

}
