package controler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Stair;

/**
 * @author Ansary & Amine
 *
 */
public class DAOStair extends DAO<Stair>{	
	
	/** 
	 * object method : constructor of DAOStair
	 */
	public DAOStair(Connection co) throws Exception {
		// TODO Auto-generated constructor stub
		super(co);
	}

	/**
	 * object method : this method create in the database a stair
	 */
	@Override
	public boolean create(Stair obj) throws SQLException {
		boolean to_return = false	;
		if(!ifFind(obj)) {
			// TODO Auto-generated method stub
			setPreparedStatement(connect
	                .prepareStatement("insert into  maao.stair "
	                		+ " (stair_name) 	"
	                		+ " values (?) 		"));
	       // Parameter name
	        getPreparedStatement().setString(1, obj.getStair_name());
	        getPreparedStatement().executeUpdate()					;
			to_return = true										;
		}
		return to_return											;
	}

	@Override
	/**
	 * object method : this method delete in the database
	 */
	public boolean delete(int id_stair) throws SQLException {
		// TODO Auto-generated method stub
		//Remove
		boolean to_return = false									;
		if(id_stair>=0) {
			setPreparedStatement(connect.prepareStatement("DELETE FROM maao.stair "
					+ " WHERE stair_id = ? ; "))					;
        	getPreparedStatement().setInt(1, id_stair)				;
        	getPreparedStatement().executeUpdate()					;
        	to_return = true										;
		}
		return to_return											;
	}

	@Override
	/**
	 * method object : this method can be used for return a stair
	 */
	public Stair find(int stair_id) throws SQLException {
		// TODO Auto-generated method stub
		Stair stair = new Stair()									;
		return stair												;
	}

	@Override
	/**
	 * object method : this method is used for update in the database
	 */
	public boolean update(Stair obj) throws SQLException {
		// TODO Auto-generated method stub
		boolean to_return = false;
		if(!ifFind(obj)) {
			System.out.println("sql update");
			System.out.println("id : "+obj.getStair_id()+" nom : "+obj.getStair_name());
			// TODO Auto-generated method stub
			setPreparedStatement(connect
	                .prepareStatement("UPDATE maao.stair SET "
	                		+ " stair_name = ? "
	                		+ " WHERE stair_id = ? "));
	       // Parameter name
	        getPreparedStatement().setString(1, obj.getStair_name()	);
	        getPreparedStatement().setInt	(2, obj.getStair_id()	);
	        getPreparedStatement().executeUpdate()					 ;
			to_return = true;
		}
		return to_return;
	}

	@Override
	/**
	 * object method : this method return if a same stair exist in the database
	 */
	public boolean ifFind(Stair obj) throws SQLException {
		// TODO Auto-generated method stub
		// verification of the presence of the same value in the data base
		boolean to_return = false;
		setPreparedStatement(connect
                .prepareStatement("SELECT count(stair_name) as number "
                		+ "from maao.stair "
                		+ "where stair_name= ?"));
		getPreparedStatement().setString(1, obj.getStair_name())	;
		ResultSet resultSet = getPreparedStatement().executeQuery()	;
		resultSet.next();
		if (resultSet.getInt("number") != 0) {
        	to_return = true;
        }
		return to_return;
	}

	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * object method : Selection of all the stair in the database
	 */
	public ArrayList<Stair> presentData() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet 	resultSet 	= null							 ;
		ArrayList<Stair> table 	= new ArrayList<Stair>()		 ;
		Stair stair				= new Stair()					 ; 
		setPreparedStatement(connect
                .prepareStatement("SELECT * from maao.stair "))	 ;
		resultSet = getPreparedStatement().executeQuery(		);
		while(resultSet.next()) { 
            table.add(new Stair(resultSet.getInt("stair_id"		),resultSet.getString("stair_name")) );
		}
		System.out.println(table)								 ;
		return table											 ;
	}
}