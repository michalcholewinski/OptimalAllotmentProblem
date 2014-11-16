package db.structure.items.implementation;

import java.util.ArrayList;
import java.util.List;

import db.structure.items.Ferryman;
import db.structure.items.Root;
import db.structure.items.Sequence;
import db.structure.items.User;

public class RootImpl implements Root {
	private List<Ferryman> ferrymans;
	private List<User> users;
	private List<Sequence> sequences;

	@Override
	public List<Ferryman> getFerymans() {
		return ferrymans != null ? ferrymans : new ArrayList<Ferryman>();
	}

	@Override
	public void setFerrymans(List<Ferryman> ferrymans) {
		this.ferrymans = ferrymans;
	}

	@Override
	public List<User> getUsers() {
		return users != null ? users : new ArrayList<User>();
	}

	@Override
	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public List<Sequence> getSequences() {
		return sequences != null ? sequences : new ArrayList<Sequence>();
	}

	@Override
	public void setSequences(List<Sequence> sequences) {
		this.sequences = sequences;
	}

}
