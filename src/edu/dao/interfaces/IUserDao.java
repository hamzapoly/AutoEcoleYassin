package edu.dao.interfaces;

import java.util.List;

import edu.entities.User;

public interface IUserDao {

	void addUser(User user);

    void updateUser(User user);

    void removeUserByLogin(String login);

    List<User> findAll();

    User findUserByLogin(String login);

}
