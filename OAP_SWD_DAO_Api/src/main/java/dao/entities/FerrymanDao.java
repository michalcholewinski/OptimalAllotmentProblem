package dao.entities;

import java.util.List;

import oap.utils.exceptions.CannotAddElementException;
import oap.utils.exceptions.ElementExistInDatabaseException;
import oap.utils.exceptions.ElementNotExistInDatabaseException;
import oap.utils.exceptions.NonUniqueDataException;
import oap.utils.exceptions.NotCompleteDataException;
import db.structure.items.implementation.Ferryman;

public interface FerrymanDao {
	public Ferryman getFerrymanById(Long id);

	public Ferryman createFerryman(Ferryman ferryman)
			throws NonUniqueDataException, ElementExistInDatabaseException,
			CannotAddElementException, NotCompleteDataException;

	public Ferryman updateFerryman(Ferryman ferryman)
			throws NonUniqueDataException, ElementNotExistInDatabaseException;

	public void deleteFerryman(Ferryman ferryman)
			throws ElementNotExistInDatabaseException;

	/**
	 * 
	 * @param name
	 * @return null when noone element exist in DB
	 */
	public Ferryman findFerrymanByName(String name);

	public List<Ferryman> findAllFerrymans();
}
