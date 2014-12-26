package application.beans;

import java.util.List;

import facade.interfaces.dts.FerrymanDts;

public class FerrymansManagementModelBean {
	private List<FerrymanDts> ferrymans;	

	public List<FerrymanDts> getFerrymans() {
		return ferrymans;
	}
	
	public int getNumberOfFerrymans(){
		return ferrymans.size();
	}
	
	public void setFerrymans(List<FerrymanDts> ferrymans) {
		this.ferrymans = ferrymans;
	}

}
