package db.structure.items.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class Root {
	private List<Ferryman> ferrymans=new ArrayList<Ferryman>();
	private List<User> users=new ArrayList<User>();
	private Sequence sequence;

	@XmlElementWrapper(name = "ferrymans")
	@XmlElement(name = "ferryman")
	public void setFerrymans(List<Ferryman> ferrymans) {
		this.ferrymans = ferrymans;
	}
	public List<Ferryman> getFerrymans() {
		return ferrymans != null ? ferrymans : new ArrayList<Ferryman>();
	}

	public List<User> getUsers() {
		return users != null ? users : new ArrayList<User>();
	}

	@XmlElementWrapper(name = "users")
	@XmlElement(name = "user")
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Sequence getSequence() {
		return sequence;
	}

	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}

}