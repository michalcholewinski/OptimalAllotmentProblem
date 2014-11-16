package db.structure.items.implementation;

import java.util.Date;

import db.structure.items.User;

public class UserImpl implements User {
	private Long id;
	private String name;
	private String surname;
	private String login;
	private String password;
	private Date insertDate;
	private Date updateDate;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getSurname() {
		return surname;
	}

	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public void setLogin(String login) {
		this.login = login;

	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Date getInsertDate() {
		return insertDate;
	}

	@Override
	public void setInsertDate(Date date) {
		insertDate = date;
	}

	@Override
	public Date getUpdateDate() {
		return updateDate;
	}

	@Override
	public void setUpdateDate(Date date) {
		updateDate = date;
	}

}
