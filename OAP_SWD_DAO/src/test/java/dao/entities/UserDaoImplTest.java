package dao.entities;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import db.structure.items.implementation.User;

public class UserDaoImplTest {

	private UserDao userDao;
	private String testDBFileName ="testDb.xml";
	
	@Before
	public void setup(){
		new File("testDBFileName").delete();
		
		userDao=new UserDaoImpl();
		userDao.setTestDataFileName(testDBFileName);
	}
	
	
	@Test
	public void shouldGetUserById() {
		fail("Not yet implemented");
	}

	@Test
	public void shouldCreateUser() {
		User user=new User();
		User userFromDb = userDao.createUser(user);
		
		Assert.assertEquals(user, userFromDb);
	}

	@Test
	public void shouldCreateUserThrowUniqueConstraintException() {
		fail("Not yet implemented");
	}

	@Test
	public void shouldCreateUserThrowDuplicateEntityException() {
		fail("Not yet implemented");
	}

	@Test
	public void shouldCreateUserThrowNotAddedException() {
		fail("Not yet implemented");
	}

	@Test
	public void shouldUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void shouldDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	public void shouldFindUserByName() {
		fail("Not yet implemented");
	}

	@Test
	public void shouldFindUserBySurname() {
		fail("Not yet implemented");
	}

	@Test
	public void shouldFindUserByNameAndSurname() {
		fail("Not yet implemented");
	}

	@Test
	public void shouldFindUserByLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void shouldCheckIfCorrectLogonData() {
		fail("Not yet implemented");
	}

}
