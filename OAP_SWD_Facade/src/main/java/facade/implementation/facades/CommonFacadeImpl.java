package facade.implementation.facades;

import oap.utils.xml.enums.DatabaseName;
import db.dao.DbDao;
import db.dao.DbDaoInterface;
import facade.interfaces.facades.CommonFacade;

public class CommonFacadeImpl implements CommonFacade {
	private DbDaoInterface db;

	public CommonFacadeImpl() {
		db=DbDao.getInstance(DatabaseName.PROD_DB);
	}

	@Override
	public void commit() {
		db.commit();
	}

}
