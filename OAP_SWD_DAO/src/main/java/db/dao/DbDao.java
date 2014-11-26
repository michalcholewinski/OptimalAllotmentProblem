package db.dao;

import tools.xml.XMLReaderAndWriter;
import tools.xml.XMLReaderAndWriterImpl;
import db.structure.items.implementation.Root;
import db.structure.items.implementation.Sequence;
import db.structure.items.implementation.SystemXML;

public class DbDao implements DbDaoInterface {
	private static DbDaoInterface instance;
	private final SystemXML systemXML;
	private XMLReaderAndWriter xmlReaderAndWriter;

	private DbDao() {
		xmlReaderAndWriter = XMLReaderAndWriterImpl.getInstance();
		systemXML = initDB();
	}

	private SystemXML initDB() {
		SystemXML systemXML = xmlReaderAndWriter.readSystemXML();
		if (systemXML == null) {
			systemXML = new SystemXML();
			systemXML.setRoot(new Root());
			systemXML.getRoot().setSequence(new Sequence());
		}
		return systemXML;
	}

	@Override
	public SystemXML getSystemXML() {
		return systemXML;
	}

	@Override
	public void commit() {
		xmlReaderAndWriter.writeSystemXML(systemXML);

	}

	public static DbDaoInterface getInstance() {
		if (instance == null) {
			instance = new DbDao();
		}
		return instance;
	}

	@Override
	public void setTestDataFileName(String fileName) {
		xmlReaderAndWriter.setDbFileName(fileName);
		
	}

}
