package dao.entities;

import java.util.List;

import oap.utils.exceptions.CannotAddElementException;
import oap.utils.exceptions.ElementExistInDatabaseException;
import oap.utils.exceptions.ElementNotExistInDatabaseException;
import oap.utils.exceptions.NonUniqueDataException;
import oap.utils.exceptions.NotCompleteDataException;
import oap.utils.xml.enums.DatabaseName;

import com.google.common.base.Strings;

import db.dao.DbDao;
import db.dao.DbDaoInterface;
import db.structure.items.implementation.Ferryman;
import db.structure.items.implementation.Sequence;
import db.structure.items.implementation.SystemXML;

public class FerrymanDaoImpl implements FerrymanDao {
	private DbDaoInterface dbDao;

	public FerrymanDaoImpl(DatabaseName databaseFileName) {
		dbDao = DbDao.getInstance(databaseFileName);
	}

	@Override
	public Ferryman getFerrymanById(Long id) {
		SystemXML systemXML = dbDao.getSystemXML();
		for (Ferryman ferryman : systemXML.getRoot().getFerrymans()) {
			if (ferryman.getId() == id) {
				return ferryman;
			}
		}
		return null;
	}

	private boolean isFerrymanComplete(Ferryman ferryman) {
		return !Strings.isNullOrEmpty(ferryman.getName());
	}

	@Override
	public Ferryman createFerryman(Ferryman ferryman)
			throws NonUniqueDataException, ElementExistInDatabaseException,
			CannotAddElementException, NotCompleteDataException {
		if (!isFerrymanComplete(ferryman)) {
			throw new NotCompleteDataException();
		}
		SystemXML systemXML = dbDao.getSystemXML();

		Sequence sequence = systemXML.getRoot().getSequence();
		ferryman.setId(sequence.getFerrymanCurrvalSequence());

		if (systemXML.getRoot().getFerrymans().contains(ferryman)) {
			throw new ElementExistInDatabaseException();
		}
		for (Ferryman f : systemXML.getRoot().getFerrymans()) {
			if (f.hasSameBussinessKey(ferryman)) {
				throw new NonUniqueDataException();
			}
		}

		systemXML.getRoot().getFerrymans().add(ferryman);
		if (systemXML.getRoot().getFerrymans().contains(ferryman)) {
			sequence.setFerrymanCurrvalSequence(sequence.getFerrymanCurrvalSequence()+1);
			return ferryman;
		}

		throw new CannotAddElementException();
	}

	@Override
	public Ferryman updateFerryman(Ferryman ferryman)
			throws NonUniqueDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFerryman(Ferryman ferryman)
			throws ElementNotExistInDatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public Ferryman findFerrymanByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ferryman> findAllFerrymans() {
		// TODO Auto-generated method stub
		return null;
	}

}
