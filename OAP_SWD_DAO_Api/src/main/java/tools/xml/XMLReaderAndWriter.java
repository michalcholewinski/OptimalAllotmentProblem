package tools.xml;

import oap.utils.xml.enums.DatabaseName;
import db.structure.items.implementation.SystemXML;


public interface XMLReaderAndWriter {
	public String DB_FILE_NAME= DatabaseName.PROD_DB.getFileName();
	
	public void setDbFileName(String fileName);
	public SystemXML readSystemXML();
	public void writeSystemXML(SystemXML systemXML);
}
