package dao.entities;

import static org.junit.Assert.fail;

import java.io.File;

import oap.utils.exceptions.CannotAddElementException;
import oap.utils.exceptions.ElementExistInDatabaseException;
import oap.utils.exceptions.ElementNotExistInDatabaseException;
import oap.utils.exceptions.MyException;
import oap.utils.exceptions.NonUniqueDataException;
import oap.utils.exceptions.NotCompleteDataException;
import oap.utils.xml.enums.DatabaseName;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import db.dao.DbDao;
import db.structure.items.implementation.Ferryman;

public class FerrymanDaoImplTest {
	private FerrymanDao ferrymanDao;

	@Before
	public void setup() {
		if (new File(DatabaseName.TEST_DB.getFileName()).exists()) {
			new File(DatabaseName.TEST_DB.getFileName()).delete();
		}

		ferrymanDao = new FerrymanDaoImpl(DatabaseName.TEST_DB);
	}

	@After
	public void reset() {
		DbDao.resetInstance();
	}

	@Test
	public void shouldCreateFerryman() {
		Ferryman ferryman = new Ferryman();
		ferryman.setName("AAA");

		Ferryman ferrymanFromDb = null;
		try {
			ferrymanFromDb = ferrymanDao.createFerryman(ferryman);
		} catch (MyException e) {
			fail("Not performed");
		}

		Assert.assertEquals(ferryman, ferrymanFromDb);

	}

	@Test(expected = NonUniqueDataException.class)
	public void shouldCreateFerrymanThrowNonUniqueDataException()
			throws NonUniqueDataException, ElementExistInDatabaseException,
			CannotAddElementException, NotCompleteDataException {

		Ferryman ferryman = new Ferryman();
		ferryman.setName("AAA");

		Ferryman ferrymanFromDb = null;
		ferrymanFromDb = ferrymanDao.createFerryman(ferryman);
		Ferryman ferryman2 = new Ferryman();
		ferryman2.setName("AAA");
		ferrymanFromDb = ferrymanDao.createFerryman(ferryman2);

	}

	@Test(expected = ElementExistInDatabaseException.class)
	public void shouldCreateFerrymanThrowElementExistInDatabaseException()
			throws NonUniqueDataException, ElementExistInDatabaseException,
			CannotAddElementException, NotCompleteDataException {

		Ferryman ferryman = new Ferryman();
		ferryman.setName("AAA");

		Ferryman ferrymanFromDb = null;
		ferrymanFromDb = ferrymanDao.createFerryman(ferryman);

		ferrymanFromDb = ferrymanDao.createFerryman(ferryman);

	}

	@Test(expected = NotCompleteDataException.class)
	public void shouldCreateFerrymanThrowNotCompleteDataException()
			throws NonUniqueDataException, ElementExistInDatabaseException,
			CannotAddElementException, NotCompleteDataException {

		Ferryman ferryman = new Ferryman();

		Ferryman ferrymanFromDb = null;
		ferrymanFromDb = ferrymanDao.createFerryman(ferryman);

	}

	@Test
	public void shouldUpdateFerryman() throws NonUniqueDataException,
			ElementNotExistInDatabaseException {

		Ferryman ferryman = new Ferryman();
		ferryman.setName("AAA");

		Ferryman ferrymanFromDb = null;
		try {
			ferrymanFromDb = ferrymanDao.createFerryman(ferryman);
		} catch (MyException e) {
			fail("Not performed");
		}

		ferryman.setName("BBB");
		ferrymanFromDb = ferrymanDao.updateFerryman(ferryman);

		Assert.assertEquals(ferryman, ferrymanFromDb);
	}

	@Test(expected = NonUniqueDataException.class)
	public void shouldUpdateFerrymanThrowNonUniqueDataException()
			throws NonUniqueDataException, ElementNotExistInDatabaseException {
		Ferryman ferryman = new Ferryman();
		ferryman.setName("AAA");

		Ferryman ferrymanFromDb = null;
		try {
			ferrymanFromDb = ferrymanDao.createFerryman(ferryman);
		} catch (MyException e) {
			fail("Not performed");
		}
		Ferryman ferryman1 = new Ferryman();
		ferryman1.setName("BBB");

		try {
			ferrymanFromDb = ferrymanDao.createFerryman(ferryman1);
		} catch (MyException e) {
			fail("Not performed");
		}

		ferryman.setName("BBB");
		ferrymanFromDb = ferrymanDao.updateFerryman(ferryman);

	}

	@Test
	public void shouldDeleteFerryman()
			throws ElementNotExistInDatabaseException {
		Ferryman ferryman = new Ferryman();
		ferryman.setName("AAA");

		Ferryman ferrymanFromDb = null;
		try {
			ferrymanFromDb = ferrymanDao.createFerryman(ferryman);
		} catch (MyException e) {
			fail("Not performed");
		}
		Assert.assertEquals(ferryman, ferrymanFromDb);
		ferrymanDao.deleteFerryman(ferryman);

		Assert.assertEquals(0, ferrymanDao.findAllFerrymans().size());

	}

	@Test(expected = ElementNotExistInDatabaseException.class)
	public void shouldDeleteFerrymanThrowElementNotExistInDatabaseException()
			throws ElementNotExistInDatabaseException {
		Ferryman ferryman = new Ferryman();
		ferryman.setName("AAA");
		ferrymanDao.deleteFerryman(ferryman);
	}

}
