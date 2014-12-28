package facade.interfaces.facades;

import java.util.List;

import facade.interfaces.dts.UserDts;

public interface UserFacade {
	public List<UserDts> getUsers();
	public void addNewUser(UserDts user);
	public UserDts updateUser(UserDts user);
	public void deleteUser(UserDts user);
	
}
