package dao.entities;

import java.io.File;
import java.util.List;

import oap.utils.exceptions.CannotAddElementException;
import oap.utils.exceptions.ElementExistInDatabaseException;
import oap.utils.exceptions.ElementNotExistInDatabaseException;
import oap.utils.exceptions.NonUniqueDataException;
import oap.utils.exceptions.NotCompleteDataException;
import oap.utils.xml.enums.DatabaseName;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import db.dao.DbDao;
import db.structure.items.implementation.User;

public class UserDaoImplTest {

	private UserDao userDao;


	@Before
	public void setup() {
		if (new File(DatabaseName.TEST_DB.getFileName()).exists()) {
			new File(DatabaseName.TEST_DB.getFileName()).delete();
		}

		userDao = new UserDaoImpl(DatabaseName.TEST_DB);
	}

	
	@After
	public void reset(){
		DbDao.resetInstance();
	}

	@Test
	public void shouldCreateUser() {
		User user = new User();
		user.setName("Michal");
		user.setSurname("Cholewinski");
		user.setLogin("Michal");
		user.setPassword("*****");
		User userFromDb = null;
		try {
			userFromDb = userDao.createUser(user);
		} catch (Exception e) {
		} finally {

		}
		Assert.assertEquals(user, userFromDb);
	}

	@Test(expected = NonUniqueDataException.class)
	public void shouldCreateUserThrowUniqueConstraintException()
			throws NonUniqueDataException, ElementExistInDatabaseException,
			CannotAddElementException,NotCompleteDataException {
		User user = new User();
		user.setName("Michal");
		user.setSurname("Cholewinski");
		user.setLogin("Michal");
		user.setPassword("*****");
		User user2 = new User();
		user2.setName("Michal");
		user2.setSurname("Cholewinski");
		user2.setLogin("Michal");
		user2.setPassword("*****");
		User userFromDb = null;
		User userFromDb1 = null;
		userFromDb = userDao.createUser(user);
		userFromDb1 = userDao.createUser(user2);

	}

	@Test(expected = ElementExistInDatabaseException.class)
	public void shouldCreateUserThrowElementExistInDatabaseException()
			throws NonUniqueDataException, ElementExistInDatabaseException,
			CannotAddElementException,NotCompleteDataException{
		User user = new User();
		user.setName("Michal");
		user.setSurname("Cholewinski");
		user.setLogin("Michal");
		user.setPassword("*****");
		User userFromDb = null;

		userFromDb = userDao.createUser(user);
		User userFromDb1 = null;
		userFromDb1 = userDao.createUser(user);
	}

	@Test
	public void shouldUpdateUser() {
		User user = new User();
		user.setName("Michal");
		user.setSurname("Cholewinski");
		user.setLogin("Michal");
		user.setPassword("*****");
		User userFromDb = null;
		try {
			userFromDb = userDao.createUser(user);
		} catch (Exception e) {
		} finally {

		}
		Assert.assertEquals(user, userFromDb);
		user.setName("Michal");

		try {
			userFromDb = userDao.updateUser(user);
		} catch (NonUniqueDataException e) {
		}
		Assert.assertEquals(user, userFromDb);

	}

	@Test(expected = NonUniqueDataException.class)
	public void shouldUpdateUserThrowNonUniqueDataException()
			throws NonUniqueDataException {
		User user = new User();
		user.setName("Michal");
		user.setSurname("Cholewinski");
		user.setLogin("Michal");
		user.setPassword("*****");
		User userFromDb = null;
		try {
			userFromDb = userDao.createUser(user);
		} catch (Exception e) {
		} finally {

		}
		
		User user0 = new User();
		user0.setName("Michal0");
		user0.setSurname("Cholewinski0");
		user0.setLogin("Michal0");
		user0.setPassword("*****");
		User userFromDb0 = null;
		try {
			userFromDb0 = userDao.createUser(user0);
		} catch (Exception e) {
		} finally {

		}
		
		user0.setName("Michal");
		userFromDb = userDao.updateUser(user0);

	}

	@Test
	public void shouldDeleteUser() throws ElementNotExistInDatabaseException{
		User user = new User();
		user.setName("Michal");
		user.setSurname("Cholewinski");
		user.setLogin("Michal");
		user.setPassword("*****");
		User userFromDb = null;
		try {
			userFromDb = userDao.createUser(user);
		} catch (Exception e) {
		} finally {

		}
		
		userDao.deleteUser(user);
		
		User foundedUser = userDao.findUserByLogin(user.getLogin());
		
		Assert.assertNull(foundedUser);
		
	}
	
	@Test(expected=ElementNotExistInDatabaseException.class)
	public void shouldDeleteUserThrowException() throws ElementNotExistInDatabaseException{
		User user = new User();
		user.setName("Michal");
		user.setSurname("Cholewinski");
		user.setLogin("Michal");
		user.setPassword("*****");
		User userFromDb = null;
		try {
			userFromDb = userDao.createUser(user);
		} catch (Exception e) {
		} finally {

		}
		User user1=new User();
		user.setName("Michalwfwsed");
		user.setSurname("Cholewinskifeas");
		user.setLogin("Michalfesd");
		user.setPassword("*****");
		userDao.deleteUser(user1);
		
		
		
	}


	@Test
	public void shouldFindUserByName() {
		User user = new User();
		user.setName("Michal");
		user.setSurname("Cholewinski");
		user.setLogin("Michal");
		user.setPassword("*****");
		User userFromDb = null;
		try {
			userFromDb = userDao.createUser(user);
		} catch (Exception e) {
		} finally {

		}
		
		
		List<User> foundedUsers = userDao.findUserByName(user.getName());
		
		Assert.assertEquals(1, foundedUsers.size());
	}

	@Test
	public void shouldFindUserBySurname() {
		User user = new User();
		user.setName("Michal");
		user.setSurname("Cholewinski");
		user.setLogin("Michal");
		user.setPassword("*****");
		User userFromDb = null;
		try {
			userFromDb = userDao.createUser(user);
		} catch (Exception e) {
		} finally {

		}
		List<User> foundedUsers = userDao.findUserBySurname(user.getSurname());
		
		Assert.assertEquals(1, foundedUsers.size());
	}

	@Test
	public void shouldFindUserByNameAndSurname() {
		User user = new User();
		user.setName("Michal");
		user.setSurname("Cholewinski");
		user.setLogin("Michal");
		user.setPassword("*****");
		User userFromDb = null;
		try {
			userFromDb = userDao.createUser(user);
		} catch (Exception e) {
		} finally {

		}
		List<User> foundedUsers = userDao.findUserByNameAndSurname(user.getName(),user.getSurname());
		
		Assert.assertEquals(1, foundedUsers.size());
	}

	@Test
	public void shouldFindUserByLogin() {
		User user = new User();
		user.setName("Michal");
		user.setSurname("Cholewinski");
		user.setLogin("Michal");
		user.setPassword("*****");
		User userFromDb = null;
		try {
			userFromDb = userDao.createUser(user);
		} catch (Exception e) {
		} finally {

		}
		User foundedUser = userDao.findUserByLogin(user.getLogin());
		
		Assert.assertEquals(user, foundedUser);
	}

	@Test
	public void shouldCheckIfCorrectLogonData() {
		User user = new User();
		user.setName("Michal");
		user.setSurname("Cholewinski");
		user.setLogin("Michal");
		user.setPassword("*****");
		User userFromDb = null;
		try {
			userFromDb = userDao.createUser(user);
		} catch (Exception e) {
		} finally {

		}
		User foundedUser = userDao.checkIfCorrectLogonData(user.getLogin(), user.getPassword());
		
		Assert.assertEquals(user, foundedUser);
	}

}
