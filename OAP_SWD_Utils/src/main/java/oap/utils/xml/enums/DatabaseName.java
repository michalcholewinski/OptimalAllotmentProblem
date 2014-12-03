package oap.utils.xml.enums;


public enum DatabaseName {
	TEST_DB("DB_TEST.xml"),
	PROD_DB("DB_OAP.xml");
	
	private DatabaseName(String fileName){
		this.fileName=fileName;
	}
	
	private String fileName;
	
	
	public String getFileName() {
		return fileName;
	}
	

}
