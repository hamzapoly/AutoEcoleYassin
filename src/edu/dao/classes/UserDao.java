package edu.dao.classes;

import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.dao.interfaces.IUserDao;
import edu.entities.User;
import edu.technique.DataSource;

public class UserDao implements IUserDao {

    private Connection connection;

    public UserDao() {
    	 connection = DataSource.getInstance().getConnection();
    	 System.out.println("Connextion établie");
    	 }
    
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
	try {
		String req = "insert into user values (?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1, user.getId());
        ps.setString(2, user.getNom());
        ps.setString(3, user.getPrenom());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getLogin());
        ps.setString(6, String.valueOf(user.getPassword()));
        ps.executeUpdate();

	} catch (Exception e) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
	}	
	}

	@Override
	public boolean authentification (String login,String password) {
		try {
			String req = "select * from user where login =? and password =?";
			PreparedStatement ps;			
			ps = connection.prepareStatement(req);
	        ps.setString(1, login);
	        ps.setString(2,password);
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
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
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
		return null;
	}

}
