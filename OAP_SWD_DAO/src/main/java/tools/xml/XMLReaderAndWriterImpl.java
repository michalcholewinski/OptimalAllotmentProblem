package tools.xml;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import tools.xml.XMLReaderAndWriter;
import db.structure.items.implementation.SystemXML;

public class XMLReaderAndWriterImpl implements XMLReaderAndWriter {
	private String dbFileName = DB_FILE_NAME;
	private static XMLReaderAndWriter instance;

	private XMLReaderAndWriterImpl() {
	}

	@Override
	public SystemXML readSystemXML() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(SystemXML.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			File XMLfile = new File(dbFileName);
			return (SystemXML) jaxbUnmarshaller.unmarshal(XMLfile);

		} catch (JAXBException e) {
			e.printStackTrace();

			return null;
		}
	}

	@Override
	public void writeSystemXML(SystemXML systemXML) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(SystemXML.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);
			File XMLfile = new File(dbFileName);
			jaxbMarshaller.marshal(systemXML, XMLfile);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static XMLReaderAndWriter getInstance() {
		
		if(instance==null){
			instance=new XMLReaderAndWriterImpl();
		}
		return instance;
	}

	@Override
	public void setDbFileName(String fileName) {
		dbFileName = fileName;

	}



}
