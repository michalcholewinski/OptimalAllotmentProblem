package dao.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import oap.utils.exceptions.CannotAddElementException;
import oap.utils.exceptions.ElementExistInDatabaseException;
import oap.utils.exceptions.ElementNotExistInDatabaseException;
import oap.utils.exceptions.NonUniqueDataException;
import oap.utils.exceptions.NotCompleteDataException;
import oap.utils.xml.enums.DatabaseName;

import com.google.common.base.Strings;

import db.dao.DbDao;
import db.dao.DbDaoInterface;
import db.structure.items.implementation.Sequence;
import db.structure.items.implementation.SystemXML;
import db.structure.items.implementation.User;

public class UserDaoImpl implements UserDao {
	private DbDaoInterface dbDao;

	public UserDaoImpl(DatabaseName databaseFileName) {
		dbDao = DbDao.getInstance(databaseFileName);
	}

	@Override
	public User getUserById(Long id) {
		SystemXML systemXML = dbDao.getSystemXML();
		
		for(User user: systemXML.getRoot().getUsers()){
			if(user.getId()==id){
				return user;
			}
		}
		
		return null;
	}

	private boolean isUserComplete(User user) {

		return (!Strings.isNullOrEmpty(user.getLogin())
				&& !Strings.isNullOrEmpty(user.getPassword())
				&& !Strings.isNullOrEmpty(user.getName()) && !Strings
					.isNullOrEmpty(user.getSurname()));
	}

	@Override
	public User createUser(User user) throws NonUniqueDataException,
			ElementExistInDatabaseException, CannotAddElementException,
			NotCompleteDataException {
		if(!isUserComplete(user)){
			throw new NotCompleteDataException();
		}
		SystemXML systemXML = dbDao.getSystemXML();

		Sequence sequence = systemXML.getRoot().getSequence();
		if (sequence.getUserCurrvalSequence() == 0) {
			user.setId(sequence.getUserCurrvalSequence() + 1);
		}

		if (systemXML.getRoot().getUsers().contains(user)) {
			throw new ElementExistInDatabaseException();
		}

		for (User u : systemXML.getRoot().getUsers()) {
			if (u.hasSameBussinessKey(user)) {
				throw new NonUniqueDataException();
			}
		}

		systemXML.getRoot().getUsers().add(user);
		
		//check if user has been added and increment sequence
		for (User u : systemXML.getRoot().getUsers()) {
			if (user.equals(u)) {
				sequence.setUserCurrvalSequence(sequence
						.getUserCurrvalSequence() + 1);
				return u;
			}
		}

		throw new CannotAddElementException();
	}

	@Override
	public User updateUser(User user) throws NonUniqueDataException,ElementNotExistInDatabaseException {
		SystemXML systemXML = dbDao.getSystemXML();
		User updatedUser = getUserById(user.getId());
		if(updatedUser==null){
			throw new ElementNotExistInDatabaseException();
		}
		for(User u: systemXML.getRoot().getUsers()){
			if(u.hasSameBussinessKey(user)){
				throw new NonUniqueDataException();
			}
		}
		updatedUser.setName(user.getName());
		updatedUser.setSurname(user.getSurname());
		updatedUser.setLogin(user.getLogin());
		updatedUser.setPassword(user.getPassword());
		updatedUser.setRole(user.getRole());
		updatedUser.setUpdateDate(new Date());
		
		return updatedUser;
	}

	@Override
	public void deleteUser(User user) throws ElementNotExistInDatabaseException {
		SystemXML systemXML = dbDao.getSystemXML();
		Iterator<User> it = systemXML.getRoot().getUsers().iterator();
		while(it.hasNext()){
			User u= it.next();
			if(u.equals(user)){
				it.remove();
				return;
			}
		}
		throw new ElementNotExistInDatabaseException();
	}

	@Override
	public List<User> findUserByName(String name) {
		List<User> users = new ArrayList<User>();
		SystemXML systemXML = dbDao.getSystemXML();
		for(User u: systemXML.getRoot().getUsers()){
			if(u.getName().equals(name)){
				users.add(u);
			}
		}
		return users;
	}

	@Override
	public List<User> findUserBySurname(String surname) {
		List<User> users = new ArrayList<User>();
		SystemXML systemXML = dbDao.getSystemXML();
		for(User u: systemXML.getRoot().getUsers()){
			if(u.getSurname().equals(surname)){
				users.add(u);
			}
		}
		return users;
	}

	@Override
	public List<User> findUserByNameAndSurname(String name, String surname) {
		List<User> users = new ArrayList<User>();
		SystemXML systemXML = dbDao.getSystemXML();
		for(User u: systemXML.getRoot().getUsers()){
			if(u.getSurname().equals(surname) && u.getName().equals(name)){
				users.add(u);
			}
		}
		return users;
	}

	@Override
	public User findUserByLogin(String login) {
		SystemXML systemXML = dbDao.getSystemXML();
		for(User u: systemXML.getRoot().getUsers()){
			if(u.getLogin().equals(login)){
				return u;
			}
		}
		return null;
	}

	@Override
	public User checkIfCorrectLogonData(String login, String password) {
		SystemXML systemXML = dbDao.getSystemXML();
		for(User u: systemXML.getRoot().getUsers()){
			//TODO password should be encrypted MD5
			if(u.getLogin().equals(login) && u.getPassword().equals(password)){
				return u;
			}
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		SystemXML systemXML = dbDao.getSystemXML();
		return systemXML.getRoot().getUsers();
	}

}
