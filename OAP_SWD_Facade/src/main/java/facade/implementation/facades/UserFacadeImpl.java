package facade.implementation.facades;

import java.util.ArrayList;
import java.util.List;

import oap.utils.exceptions.MyException;
import oap.utils.xml.enums.DatabaseName;
import dao.entities.UserDao;
import dao.entities.UserDaoImpl;
import db.structure.items.implementation.User;
import facade.implementation.assembler.UserAssembler;
import facade.interfaces.dts.UserDts;
import facade.interfaces.facades.UserFacade;

public class UserFacadeImpl implements UserFacade{
	private UserDao userDao;
	private UserAssembler assembler;
	
	public UserFacadeImpl() {
		userDao=new UserDaoImpl(DatabaseName.PROD_DB);
		assembler=new UserAssembler();
	}

	@Override
	public List<UserDts> getUsers() {
		List<UserDts> users = new ArrayList<UserDts>();
		List<User> userList =  userDao.getAllUsers();
		for(User u: userList){
			users.add(assembler.entityToDts(u));
		}
		return users;
	}

	@Override
	public void addNewUser(UserDts user) throws MyException{
			userDao.createUser(assembler.dtsToEntity(user));
	}

	@Override
	public UserDts updateUser(UserDts user) throws MyException{
		User updatedUser=userDao.updateUser(assembler.dtsToEntity(user));
		return assembler.entityToDts(updatedUser);
	}

	@Override
	public void deleteUser(UserDts user) throws MyException{
		userDao.deleteUser(assembler.dtsToEntity(user));
	}

}
