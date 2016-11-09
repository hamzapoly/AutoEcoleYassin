package edu.dao.interfaces;

import java.util.List;
import edu.entities.User;
import edu.utils.errors.JDBCSQLExceptions;


public interface IUserDao {

	void addUser(User user) throws JDBCSQLExceptions;

    void updateUserInfo(User user) throws JDBCSQLExceptions;
 
    void removeUserByLogin(String login) throws JDBCSQLExceptions;

    boolean authentification (String login,String password) throws JDBCSQLExceptions;
    
    List<User> findAll();

    User findUserByLogin(String login) throws JDBCSQLExceptions;

}
