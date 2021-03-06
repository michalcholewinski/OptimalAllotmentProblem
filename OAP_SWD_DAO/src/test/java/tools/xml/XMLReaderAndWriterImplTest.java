package tools.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import db.structure.items.implementation.Ferryman;
import db.structure.items.implementation.Root;
import db.structure.items.implementation.Sequence;
import db.structure.items.implementation.SystemXML;
import db.structure.items.implementation.Tarif;
import db.structure.items.implementation.User;

public class XMLReaderAndWriterImplTest {
	private XMLReaderAndWriter xmlRAW;
	private String testDBFileName ="testDb.xml";
	
	@Before
	public void setup(){
		new File("testDBFileName").delete();
		xmlRAW=XMLReaderAndWriterImpl.getInstance();
		xmlRAW.setDbFileName(testDBFileName);
	}
	
	@Test
	public void shouldAddOneUser(){
		SystemXML systemXML=new SystemXML();
		systemXML.setRoot(new Root());
		systemXML.getRoot().setUsers(new ArrayList<User>());
		User user = new User();
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
	
	

	
	@Test
	public void shouldAddOneFerryman(){
		SystemXML systemXML=new SystemXML();
		systemXML.setRoot(new Root());
		systemXML.getRoot().setUsers(new ArrayList<User>());
		Ferryman ferryman = new Ferryman();
		ferryman.setId(1L);
		ferryman.setName("AAA");
		ferryman.setInsertDate(new Date());
		ferryman.setUpdateDate(new Date());
		systemXML.getRoot().getFerrymans().add(ferryman);
		
		xmlRAW.writeSystemXML(systemXML);
		
		SystemXML systemXML2 = xmlRAW.readSystemXML();
		
		
		Assert.assertEquals(ferryman, systemXML2.getRoot().getFerrymans().get(0));
	}
	
	@Test
	public void shouldAddOneFerrymanWithOneTarifInPriceList(){
		SystemXML systemXML=new SystemXML();
		systemXML.setRoot(new Root());
		systemXML.getRoot().setUsers(new ArrayList<User>());
		Ferryman ferryman = new Ferryman();
		ferryman.setId(1L);
		ferryman.setName("AAA");
		ferryman.setInsertDate(new Date());
		ferryman.setUpdateDate(new Date());
		List<Tarif> priceList = new ArrayList<Tarif>();
		Tarif tarif=new Tarif();
		tarif.setPrice(10);
		tarif.setId(2L);
		tarif.setWeight(15);
		tarif.setInsertDate(new Date());
		tarif.setUpdateDate(new Date());
		priceList.add(tarif);
		ferryman.setPriceList(priceList);
		
		
		systemXML.getRoot().getFerrymans().add(ferryman);
		
		
		
		xmlRAW.writeSystemXML(systemXML);
		
		SystemXML systemXML2 = xmlRAW.readSystemXML();
		
		
		Assert.assertEquals(ferryman, systemXML2.getRoot().getFerrymans().get(0));
	}
	
	
	@Test
	public void shouldAddSequence(){
		SystemXML systemXML=new SystemXML();
		systemXML.setRoot(new Root());
		
		Sequence sequence = new Sequence();
		sequence.setFerrymanCurrvalSequence(10L);
		sequence.setTarifCurrvalSequence(10L);
		sequence.setUserCurrvalSequence(13L);
		systemXML.getRoot().setSequence(sequence);
		
		xmlRAW.writeSystemXML(systemXML);
		
		SystemXML systemXML2 = xmlRAW.readSystemXML();
		
		
		Assert.assertEquals(sequence.getFerrymanCurrvalSequence(), systemXML2.getRoot().getSequence().getFerrymanCurrvalSequence());
		Assert.assertEquals(sequence.getTarifCurrvalSequence(), systemXML2.getRoot().getSequence().getTarifCurrvalSequence());
		Assert.assertEquals(sequence.getUserCurrvalSequence(), systemXML2.getRoot().getSequence().getUserCurrvalSequence());
	}
	
	
	
	

}
