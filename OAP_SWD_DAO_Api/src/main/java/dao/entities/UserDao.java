package dao.entities;

import java.util.List;

import oap.utils.exceptions.CannotAddElementException;
import oap.utils.exceptions.ElementExistInDatabaseException;
import oap.utils.exceptions.ElementNotExistInDatabaseException;
import oap.utils.exceptions.NonUniqueDataException;
import oap.utils.exceptions.NotCompleteDataException;
import db.structure.items.implementation.User;

/**
 * @author Michal
 *
 */
public interface UserDao {
	public User getUserById(Long id);

	public User createUser(User user) throws NonUniqueDataException,ElementExistInDatabaseException,CannotAddElementException,NotCompleteDataException;

	public User updateUser(User user) throws NonUniqueDataException,ElementNotExistInDatabaseException;

	public void deleteUser(User user) throws ElementNotExistInDatabaseException;

	public List<User> findUserByName(String name);

	public List<User> findUserBySurname(String surname);

	public List<User> findUserByNameAndSurname(String name, String surname);

	public User findUserByLogin(String login);
	public List<User> getAllUsers();

	/**
	 * 
	 * @param login
	 * @param password
	 * @return User in case correct data to login, null when noone User was
	 *         found
	 */
	public User checkIfCorrectLogonData(String login, String password);

}
