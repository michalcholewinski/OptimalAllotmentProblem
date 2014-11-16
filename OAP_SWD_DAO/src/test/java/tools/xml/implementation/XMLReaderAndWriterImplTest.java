package tools.xml.implementation;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tools.xml.XMLReaderAndWriter;
import db.structure.items.SystemXML;
import db.structure.items.User;
import db.structure.items.implementation.RootImpl;
import db.structure.items.implementation.SystemXMLImpl;
import db.structure.items.implementation.UserImpl;

public class XMLReaderAndWriterImplTest {
	private XMLReaderAndWriter xmlRAW;
	private String testDBFileName ="testDb.xml";
	
	@Before
	public void setup(){
		xmlRAW=XMLReaderAndWriterImpl.getInstance();
	}
	
	
	
	
	@Test
	public void shouldAddOneUser(){
		SystemXML systemXML=new SystemXMLImpl();
		systemXML.setRoot(new RootImpl());
		systemXML.getRoot().setUsers(new ArrayList<User>());
		User user = new UserImpl();
		user.setId(1L);
		user.setName("AAA");
		user.setSurname("BBB");
		user.setLogin("LOGIN");
		user.setPassword("PASSWOORD");
		user.setInsertDate(new Date());
		user.setUpdateDate(new Date());
		systemXML.getRoot().getUsers().add(user);
		
		xmlRAW.writeSystemXML(systemXML);
		
		SystemXML systemXML2 = xmlRAW.readSystemXML();
		
		
		Assert.assertEquals(user, systemXML2.getRoot().getUsers().get(0));
		
		
		
		
		
		
	}
	

}
