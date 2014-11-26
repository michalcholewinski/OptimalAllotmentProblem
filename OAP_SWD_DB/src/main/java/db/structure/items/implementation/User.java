package db.structure.items.implementation;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "user")
@XmlType(propOrder = { "id", "name", "surname", "login", "password",
		"insertDate", "updateDate" })
public class User {
	private Long id;
	private String name;
	private String surname;
	private String login;
	private String password;
	private Date insertDate;
	private Date updateDate;

	public User() {
		name=new String();
		surname=new String();
		login=new String();
		password=new String();
		insertDate=new Date();
		updateDate=new Date();
	}
	public Long getId() {
		return id;
	}

	@XmlElement(required=true)
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement(required=true)
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}
	@XmlElement(required=true)
	public void setLogin(String login) {
		this.login = login;

	}

	public String getPassword() {
		return password;
	}
	@XmlElement(required=true)
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date date) {
		insertDate = date;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date date) {
		updateDate = date;
	}

	@Override
	public boolean equals(Object arg0) {
		User user = (User) arg0;
		return (user.getId() == id && user.getLogin().equals(login)
				&& user.getName().equals(name)
				&& user.getPassword().equals(password)
				&& user.getSurname().equals(surname)
				&& user.getInsertDate().equals(insertDate) && user
				.getUpdateDate().equals(updateDate));
	}

	public boolean hasSameBussinessKey(User user) {
		return (user.getId() == id
				|| (user.getName().equals(name) && user.getSurname().equals(
						surname)) || user.getLogin().equals(login));
	}

}
