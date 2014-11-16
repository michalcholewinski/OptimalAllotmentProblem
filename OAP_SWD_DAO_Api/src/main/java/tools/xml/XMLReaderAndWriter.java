package tools.xml;

import db.structure.items.SystemXML;

public interface XMLReaderAndWriter {
	public String DB_FILE_NAME= "../DB_OAP.xml";
	
	public void setDbFileName(String fileName);
	public SystemXML readSystemXML();
	public void writeSystemXML(SystemXML systemXML);
}
