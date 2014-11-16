package db.structure.items;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public interface Root {
	public List<Ferryman> getFerymans();
	@XmlElementWrapper(name = "ferrymans")
	@XmlElement(name = "ferryman")
	public void setFerrymans(List<Ferryman> ferrymans);
	
	public List<User> getUsers();
	@XmlElementWrapper(name = "users")
	@XmlElement(name = "user")
	public void setUsers(List<User> users);
	
	public List<Sequence> getSequences();
	@XmlElementWrapper(name = "sequences")
	@XmlElement(name = "sequence")
	public void setSequences(List<Sequence> sequences);
}
