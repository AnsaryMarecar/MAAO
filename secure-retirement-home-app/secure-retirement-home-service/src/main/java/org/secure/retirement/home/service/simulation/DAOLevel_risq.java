/**
 * 
 */
package org.secure.retirement.home.service.simulation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.secure.retirement.home.common.DAOException;
import org.secure.retirement.home.common.Level_risq;
import org.secure.retirement.home.common.Return_information;
import org.secure.retirement.home.service.DAO;
import org.secure.retirement.home.service.DAOFactory;
import org.secure.retirement.home.service.DAOUtility;

/**
 * @author Ansary MARECAR
 *
 */
public class DAOLevel_risq implements DAO<Level_risq> {
	private DAOFactory daofactory;
	
	public DAOLevel_risq(DAOFactory param_daofactory) throws Exception {
		this.daofactory = param_daofactory;
	}

	public Return_information create(Level_risq param_level_risq) throws SQLException {
		// TODO Auto-generated method stub
		int to_return = -5	;
		System.out.println("create");
		try {
			String SQL_INSERT = "INSERT INTO level_risq (level_risq_name, level_risq_color, type_sensor_id) VALUES (  ?, ?, ?  )";
			Connection connexion = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			int status = 0;
			try {
				/* Get connection from the Factory */
				connexion = daofactory.getConnection();
				System.out.println(" execute  ");
				preparedStatement = DAOUtility.initPreparedRequest(
					connexion
					,	SQL_INSERT
					,	true
					,	param_level_risq.getLevel_risq_name()
					,	param_level_risq.getLevel_risq_color()
					,	param_level_risq.getType_sensor().getType_sensor_id()
				);
				System.out.println(" status  ");
				status = preparedStatement.executeUpdate();
				System.out.println("end status ");
				if( status == 0 ) {
					System.out.println("error execute  ");
					throw new DAOException( "Sorry we have problem, we cannot insert" );
				}
				else {
					System.out.println("else");
					/* take the generated id */
					try{
						System.out.println("generate key");
						resultSet = preparedStatement.getGeneratedKeys();
					}
					catch(Exception e) {
						System.out.println("error");
					}
					if ( resultSet.next() ) {
						System.out.println(" to_return = -4  ");
						param_level_risq.setLevel_risq_id(resultSet.getInt( 1 ));
						to_return = -4;
					} 
					else {
						System.out.println(" insertion id is not return to us  ");
						throw new DAOException( "insertion id is not return to us" );
					}
				}
				} catch ( SQLException e ) {
					throw new DAOException( e );
				} finally {
					DAOUtility.closeAll(preparedStatement, connexion,   resultSet );
				}
		}catch(Exception e) {
		}
		return null;
	}

	public Return_information delete(Level_risq obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Return_information update(Level_risq obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean ifFind(Level_risq obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public Level_risq find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Level_risq> presentData() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Return_information select(Level_risq obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
