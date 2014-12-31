package dao.entities;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import oap.utils.exceptions.CannotAddElementException;
import oap.utils.exceptions.ElementExistInDatabaseException;
import oap.utils.exceptions.ElementNotExistInDatabaseException;
import oap.utils.exceptions.MyException;
import oap.utils.exceptions.NonUniqueDataException;
import oap.utils.exceptions.NotCompleteDataException;
import oap.utils.xml.enums.DatabaseName;

import com.google.common.base.Strings;

import db.dao.DbDao;
import db.dao.DbDaoInterface;
import db.structure.items.implementation.Ferryman;
import db.structure.items.implementation.Sequence;
import db.structure.items.implementation.SystemXML;
import db.structure.items.implementation.Tarif;

public class FerrymanDaoImpl implements FerrymanDao {
	private DbDaoInterface dbDao;

	public FerrymanDaoImpl(DatabaseName databaseFileName) {
		dbDao = DbDao.getInstance(databaseFileName);
	}

	@Override
	public Ferryman getFerrymanById(Long id) throws ElementNotExistInDatabaseException{
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
			sequence.setFerrymanCurrvalSequence(sequence
					.getFerrymanCurrvalSequence() + 1);
			return ferryman;
		}

		throw new CannotAddElementException();
	}

	@Override
	public Ferryman updateFerryman(Ferryman ferryman)
			throws NonUniqueDataException, ElementNotExistInDatabaseException {
		SystemXML systemXML = dbDao.getSystemXML();
		Ferryman updatedFerryman = getFerrymanById(ferryman.getId());
		if (updatedFerryman == null) {
			throw new ElementNotExistInDatabaseException();
		}

		for (Ferryman f : systemXML.getRoot().getFerrymans()) {
			if (f.getId() != updatedFerryman.getId()) {
				if (f.hasSameBussinessKey(ferryman)) {
					throw new NonUniqueDataException();
				}
			}
		}

		updatedFerryman.setName(ferryman.getName());
		updatedFerryman.setPriceList(ferryman.getPriceList());
		updatedFerryman.setUpdateDate(new Date());

		return updatedFerryman;
	}

	@Override
	public void deleteFerryman(Ferryman ferryman)
			throws ElementNotExistInDatabaseException {
		SystemXML systemXML = dbDao.getSystemXML();
		Iterator<Ferryman> it = systemXML.getRoot().getFerrymans().iterator();
		while (it.hasNext()) {
			Ferryman f = it.next();
			if (f.equals(ferryman)) {
				it.remove();
				return;
			}
		}

		throw new ElementNotExistInDatabaseException();

	}

	@Override
	public Ferryman findFerrymanByName(String name) {
		SystemXML systemXML = dbDao.getSystemXML();
		for (Ferryman f : systemXML.getRoot().getFerrymans()) {
			if (f.getName().equals(name)) {
				return f;
			}
		}
		return null;
	}

	@Override
	public List<Ferryman> findAllFerrymans() {
		SystemXML systemXML = dbDao.getSystemXML();
		return systemXML.getRoot().getFerrymans();
	}

	@Override
	public void deleteTarif(long id) throws MyException {
		SystemXML systemXML = dbDao.getSystemXML();
		List<Ferryman> ferrymans= systemXML.getRoot().getFerrymans();
		Iterator<Tarif> priceListIterator;
		for(Ferryman f: ferrymans){
			priceListIterator=f.getPriceList().iterator();
			while(priceListIterator.hasNext()){
				Tarif t=priceListIterator.next();
				if(t.getId()==id){
					priceListIterator.remove();
					return;
				}
			}
			
		}
		throw new ElementNotExistInDatabaseException();

	}

}
