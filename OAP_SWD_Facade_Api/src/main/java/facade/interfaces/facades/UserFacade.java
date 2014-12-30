package facade.interfaces.facades;

import java.util.List;

import oap.utils.exceptions.MyException;
import facade.interfaces.dts.UserDts;

public interface UserFacade {
	public List<UserDts> getUsers();
	public void addNewUser(UserDts user) throws MyException;
	public UserDts updateUser(UserDts user) throws MyException;
	public void deleteUser(UserDts user) throws MyException;
	
}
