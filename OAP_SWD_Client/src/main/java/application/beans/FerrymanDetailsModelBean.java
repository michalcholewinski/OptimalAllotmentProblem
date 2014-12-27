package application.beans;

import java.util.List;

import facade.interfaces.dts.FerrymanDts;
import facade.interfaces.dts.TarifDts;

public class FerrymanDetailsModelBean {
	private FerrymanDts ferryman;
	private List<TarifDts> priceList;
	public FerrymanDts getFerryman() {
		return ferryman;
	}
	public void setFerryman(FerrymanDts ferryman) {
		this.ferryman = ferryman;
	}
	public List<TarifDts> getPriceList() {
		return priceList;
	}
	public void setPriceList(List<TarifDts> priceList) {
		this.priceList = priceList;
	}
	
	
}
