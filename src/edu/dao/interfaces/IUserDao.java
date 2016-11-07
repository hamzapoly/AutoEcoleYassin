package edu.dao.interfaces;

import java.util.List;
import edu.entities.User;


public interface IUserDao {

	void addUser(User user);

    void updateUserInfo(User user);
 
    void updateProfilePic(User user,String path);

    void removeUserByLogin(String login);

    boolean authentification (String login,String password);
    
    List<User> findAll();

    User findUserByLogin(String login);

}
