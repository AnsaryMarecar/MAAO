package controler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Stair;

public class DAOStair extends DAO<Stair>{	
	
	/** 
	 * <p>constructor of DAOStair</p>
	 * 
	 * @author ansary.marecar
	 */
	public DAOStair(Connection co) throws Exception {
		// TODO Auto-generated constructor stub
		super(co);
	}

	/**
	 * <p>this method create in the database a stair</p>
	 * 
	 * @author ansary.marecar
	 */
	@Override
	public boolean create( Stair obj ) throws SQLException {
		boolean to_return = false	;
		if(!ifFind( obj )) {
			// TODO Auto-generated method stub
			setPreparedStatement(connect
	                .prepareStatement(" insert into  stair "
	                		+ " ( stair_name ) 	"
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
	 * <p>delete in the database</p>
	 * @author ansary.marecar
	 */
	public boolean delete(int id_stair) throws SQLException {
		// TODO Auto-generated method stub
		//Remove
		boolean to_return = false									;
		if(id_stair>=0) {
			setPreparedStatement(connect.prepareStatement("DELETE FROM stair "
					+ " WHERE stair_id = ? ; "))					;
        	getPreparedStatement().setInt(1, id_stair)				;
        	getPreparedStatement().executeUpdate()					;
        	to_return = true										;
		}
		return to_return											;
	}

	@Override
	/**
	 * <p>this method can be used for return a stair</p>
	 * 
	 * @author ansary.marecar
	 */
	public Stair find(int stair_id) throws SQLException {
		// TODO Auto-generated method stub
		Stair stair = new Stair()									;
		return stair												;
	}

	@Override
	/**
	 * <p> used for update in the database</p>
	 *
	 * @author ansary.marecar
	 */
	public boolean update(Stair obj) throws SQLException {
		// TODO Auto-generated method stub
		boolean to_return = false;
		if(!ifFind(obj)) {
			System.out.println("sql update");
			System.out.println("id : "+obj.getStair_id()+" nom : "+obj.getStair_name());
			// TODO Auto-generated method stub
			setPreparedStatement(connect
	                .prepareStatement("UPDATE stair SET "
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
	 * <p>return if a same stair exist in the database</p>
	 * @return to_return
	 * 
	 * @author Ansary.marecar
	 */
	public boolean ifFind(Stair obj) throws SQLException {
		// TODO Auto-generated method stub
		// verification of the presence of the same value in the data base
		boolean to_return = false;
		setPreparedStatement(connect
                .prepareStatement("SELECT count(stair_name) as number "
                		+ "from stair "
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
	 * <p>Selection of all the stair in the database</p>
	 * @author ansary.marecar
	 */
	public ArrayList<Stair> presentData() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet 	resultSet 	= null							 ;
		ArrayList<Stair> table 	= new ArrayList<Stair>()		 ;
		Stair stair				= new Stair()					 ; 
		setPreparedStatement(connect
                .prepareStatement("SELECT * from stair "))	 ;
		resultSet = getPreparedStatement().executeQuery(		);
		while(resultSet.next()) { 
            table.add(new Stair(resultSet.getInt("stair_id"),resultSet.getString("stair_name")) );
		}
		System.out.println(table)								 ;
		return table											 ;
	}
}