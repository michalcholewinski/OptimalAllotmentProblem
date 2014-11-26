package dao.entities;

import java.util.List;

import db.dao.DbDao;
import db.dao.DbDaoInterface;
import db.structure.items.implementation.Sequence;
import db.structure.items.implementation.SystemXML;
import db.structure.items.implementation.User;

public class UserDaoImpl implements UserDao {
	private DbDaoInterface dbDao;
	
	public UserDaoImpl() {
		dbDao=DbDao.getInstance();
	}
	
	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User user) {
		//TODO add own exception and test it
		SystemXML systemXML = dbDao.getSystemXML();
		Sequence sequence = systemXML.getRoot().getSequence();
		if(sequence.getUserCurrvalSequence()==0){
			user.setId(sequence.getUserCurrvalSequence()+1);
		}
		
		if(systemXML.getRoot().getUsers().contains(user)){
			return null; //the same record exist in DB
		}
		
		for(User u:systemXML.getRoot().getUsers()){
			if(u.hasSameBussinessKey(user)){
				return null; //business key unique exception
			}
		}
		
		
		systemXML.getRoot().getUsers().add(user);
		for(User u:systemXML.getRoot().getUsers()){
			if(user.equals(u)){
				sequence.setUserCurrvalSequence(sequence.getUserCurrvalSequence()+1);
				return u;
			}
		}
		
		return null; //Not added
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserBySurname(String surname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByNameAndSurname(String name, String surname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User checkIfCorrectLogonData(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTestDataFileName(String fileName) {
		dbDao.setTestDataFileName(fileName);
		
	}

}