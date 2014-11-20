package dao.entities;

import java.util.List;

import db.structure.items.implementation.User;

/**
 * @author Michal
 *
 */
public interface UserDao {
	public User getUserById(Long id);
	public User createUser(User user);
	public User updateUser(User user);
	public void deleteUser(User user);
	
	public List<User> findUserByName(String name);
	public List<User> findUserBySurname(String surname);
	public List<User> findUserByNameAndSurname(String name, String surname);
	public List<User> findUserByLogin(String login);
	
	/**
	 * 
	 * @param login
	 * @param password
	 * @return User in case correct data to login, null when noone User was found
	 */
	public User checkIfCorrectLogonData(String login, String password);
	
}
