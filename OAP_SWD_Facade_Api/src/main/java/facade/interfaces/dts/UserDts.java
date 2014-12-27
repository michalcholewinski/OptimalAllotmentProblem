package facade.interfaces.dts;

public interface UserDts {
	
	public long getId();
	public void setId(long id);

	public String getName();
	public void setName(String name);

	public String getSurname();
	public void setSurname(String surname);
	
	public String getLogin();
	public void setLogin(String login);
	
	public String getPassword();
	public void setPassword(String password);
	
	public String getRole();
	public void setRole(String role);

}
