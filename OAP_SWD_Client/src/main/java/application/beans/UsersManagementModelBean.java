package application.beans;

import java.util.List;

import facade.interfaces.dts.UserDts;

public class UsersManagementModelBean {
	private List<UserDts> users;
	
	
	public int getNumberOfUsers() {
		return users.size();
	}

	public List<UserDts> getUsers() {
		return users;
	}

	public void setUsers(List<UserDts> users) {
		this.users=users;
	}

}
