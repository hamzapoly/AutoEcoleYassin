package edu.dao.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import edu.dao.interfaces.IUserDao;
import edu.entities.User;

public class UserDao implements IUserDao {

    private Connection connection;

    public UserDao() {
		// TODO Auto-generated constructor stub
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
		// TODO: handle exception
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
