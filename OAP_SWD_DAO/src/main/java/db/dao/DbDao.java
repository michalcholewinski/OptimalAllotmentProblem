package db.dao;

import java.io.File;

import oap.utils.xml.enums.DatabaseName;
import tools.xml.XMLReaderAndWriter;
import tools.xml.XMLReaderAndWriterImpl;
import db.structure.items.implementation.Root;
import db.structure.items.implementation.Sequence;
import db.structure.items.implementation.SystemXML;

public class DbDao implements DbDaoInterface {
	private static DbDaoInterface instance;
	private final SystemXML systemXML;
	private XMLReaderAndWriter xmlReaderAndWriter;

	private DbDao(DatabaseName databaseFileName) {
		xmlReaderAndWriter = XMLReaderAndWriterImpl.getInstance();
		xmlReaderAndWriter.setDbFileName(databaseFileName.getFileName());
		systemXML = initDB(databaseFileName);
	}

	private SystemXML initDB(DatabaseName databaseFileName) {
		
		SystemXML systemXML;
		
		if(new File(databaseFileName.getFileName()).exists()){
			systemXML = xmlReaderAndWriter.readSystemXML();
			return systemXML;
		}else{
			systemXML = new SystemXML();
			systemXML.setRoot(new Root());
			systemXML.getRoot().setSequence(new Sequence());
			xmlReaderAndWriter.writeSystemXML(systemXML);
			return systemXML;
		}
		
	}

	@Override
	public SystemXML getSystemXML() {
		return systemXML;
	}

	@Override
	public void commit() {
		xmlReaderAndWriter.writeSystemXML(systemXML);

	}

	public static DbDaoInterface getInstance(DatabaseName databaseFileName) {
		if (instance == null) {
			instance = new DbDao(databaseFileName);
		}
		return instance;
	}

	public static void resetInstance() {
		instance=null;
		
	}

}
