package db.dao;

import db.structure.items.implementation.SystemXML;

public class DbDao implements DbDaoInterface {
	private static DbDaoInterface instance;
	
	private DbDao() {
		initDB();
	}

	
	private SystemXML initDB() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSystemXML(SystemXML systemXML) {
		// TODO Auto-generated method stub

	}

	@Override
	public SystemXML getSystemXML() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub

	}
	
	public static DbDaoInterface getInstance(){
		if(instance==null){
			instance=new DbDao();
		}
		return instance;
	}

}
