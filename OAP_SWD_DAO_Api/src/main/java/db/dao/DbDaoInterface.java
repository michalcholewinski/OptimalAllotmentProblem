package db.dao;

import db.structure.items.implementation.SystemXML;

public interface DbDaoInterface {
	
	public void setSystemXML(SystemXML systemXML);
	public SystemXML getSystemXML();
	public void commit();
}
