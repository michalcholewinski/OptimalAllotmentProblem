package db.dao;

import db.structure.items.implementation.SystemXML;

public interface DbDaoInterface {
	
	public SystemXML getSystemXML();
	public void commit();
}
