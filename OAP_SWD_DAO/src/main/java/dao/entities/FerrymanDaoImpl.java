package dao.entities;

import java.util.List;

import db.dao.DbDao;
import db.dao.DbDaoInterface;
import db.structure.items.implementation.Ferryman;
import db.structure.items.implementation.SystemXML;

public class FerrymanDaoImpl implements FerrymanDao {
	private DbDaoInterface dbDao;
	
	public FerrymanDaoImpl() {
		dbDao=DbDao.getInstance();
	}
	
	@Override
	public Ferryman getFerrymanById(Long id) {
		SystemXML systemXML = dbDao.getSystemXML();
		for(Ferryman ferryman: systemXML.getRoot().getFerrymans()){
			if(ferryman.getId()==id){
				return ferryman;
			}
		}
		return null;
	}

	@Override
	public Ferryman createFerryman(Ferryman ferryman) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ferryman updateFerryman(Ferryman ferryman) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFerryman(Ferryman ferryman) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Ferryman> findFerrymanByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}