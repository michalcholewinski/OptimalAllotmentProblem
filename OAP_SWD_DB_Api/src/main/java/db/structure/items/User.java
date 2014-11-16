package db.structure.items;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="user")
@XmlType(propOrder = { "id","name", "surname","login","password","insertDate","updateDate"})
public interface User {
	public Long getId();
	public void setId(Long id);
	public String getName();
	public void setName(String name);
	public String getSurname();
	public void setSurname(String surname);
	public String getLogin();
	public void setLogin(String login);
	public String getPassword();
	public void setPassword(String password);
	public Date getInsertDate();
	public void setInsertDate(Date date);
	public Date getUpdateDate();
	public void setUpdateDate(Date date);

}
