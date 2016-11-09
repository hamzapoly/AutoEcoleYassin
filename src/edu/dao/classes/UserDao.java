package edu.dao.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Statement;

import edu.dao.interfaces.IUserDao;
import edu.entities.User;
import edu.gui.Home;
import edu.technique.DataSource;
import edu.utils.errors.JDBCSQLExceptions;

public class UserDao implements IUserDao {

    private Connection connection;
    private DataSource datasource;
    

	public UserDao(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		this.datasource = dataSource;
	}

	
	private static final String SQL_UPDATE_INFO = "updated user set Nom=? , Prenom=? ,email=? ,login =?" ;
	private static final String SQL_CREATE_USER = "insert into user values (?,?,?,?,?,?)";
	private static final String SQL_AUTH_CHECK = "select * from user where login =? and password =?";
	private static final String SQL_FIND_BY_LOGIN = "select * from user where login =? ";


	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Connection connection = null;
	    PreparedStatement ps = null;
	    ResultSet valeursAutoGenerees = null;
	try {
		connection = datasource.getConnection();
		ps = InitialisePreparedStatement(connection, SQL_CREATE_USER, true,user.getId(), user.getNom(),user.getPrenom(), user.getEmail(),user.getLogin(),String.valueOf(user.getPassword()));
		int statut = ps.executeUpdate();
		if (statut ==0){
			throw new JDBCSQLExceptions("Echec lors de la création de l'utilisateur, aucune ligne n'et ajouté à la table" );
		}
 
	} catch (Exception e) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
	}	
	}

	@Override
    public boolean authentification (String login,String password) {
		PreparedStatement ps = null; 
		Connection connection = null;
		try {
			connection = datasource.getConnection();
			ps = InitialisePreparedStatement(connection, SQL_AUTH_CHECK, true, login,password);
	        ResultSet res = ps.executeQuery();
	        if (res.next()) {
	        	return true;
	        }
	        else {
	        	return false;
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void updateUserInfo(User user) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null; 
		Connection connection = null;
		try {
			connection = datasource.getConnection();
			ps = InitialisePreparedStatement(connection, SQL_UPDATE_INFO, true, user.getNom(),user.getPrenom(),user.getEmail(),user.getLogin());
			int res  = ps.executeUpdate();
			if (res==0) {
				throw new RuntimeException("La mise à jours n'a pas été effectué");
			}
			} catch (SQLException e) {
					// TODO: handle exception
				throw new RuntimeException(e);
				}
	}
	
	public static PreparedStatement InitialisePreparedStatement(Connection cnx,String req,boolean returnGeneratedKeys, Object...objects) throws SQLException{
		PreparedStatement ps = cnx.prepareStatement(req, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		for (int i=0;i<objects.length;i++){
			ps.setObject(i+1, objects[i]);
				}
		return ps;
	}
	
	public void updateProfilePic(User user,String path) {
		try {
			String req = "update user set profilepic =? where login=?";
			PreparedStatement ps;			
			ps = connection.prepareStatement(req);
	        ps.setString(1, path);
	        ps.setString(2, user.getLogin());
	        ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	@Override
	public void removeUserByLogin(String login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByLogin(String login) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null; 
		Connection connection = null;
		try {
			connection = datasource.getConnection();
			ps = InitialisePreparedStatement(connection, SQL_FIND_BY_LOGIN, true, login);
	        ResultSet res = ps.executeQuery();

	        if (res.next()) {
		       User user = new User(res.getInt("id"),res.getString("nom"),res.getString("prenom"),res.getString("email"),res.getString("login"),res.getString("profilepic"));
		       System.out.println(user.getNom());
		       return user;
		       	        }
	        else {
	        	return null;
	        }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}


/*public static void main(String[] args) {
			try {
				UserDao userDao = new UserDao();
				userDao.findUserByLogin("BYassin");
			} catch (Exception e) {
				e.printStackTrace();
			}
}*/
}

