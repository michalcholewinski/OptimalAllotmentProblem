package db.structure.items.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "ferryman")
public class Ferryman {
	private long id;
	private String name; 
	private Date insertDate;
	private Date updateDate;
	private List<Tarif> priceList=new ArrayList<Tarif>();

	public Ferryman() {
		name=new String();
		insertDate=new Date();
		updateDate=new Date();
	}
	
	public long getId() {
		return id;
	}

	@XmlElement(required=true)
	public void setId(long id) {
		this.id = id;

	}

	
	public String getName() {
		return name;
	}

	@XmlElement(required=true)
	public void setName(String name) {
		this.name = name;

	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date date) {
		insertDate = date;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date date) {
		updateDate = date;
	}

	public List<Tarif> getPriceList() {
		return priceList != null ? priceList : new ArrayList<Tarif>();
	}

	@XmlElementWrapper(name = "priceList")
	@XmlElement(name = "tarif")
	public void setPriceList(List<Tarif> priceList) {
		this.priceList = priceList;
	}

	@Override
	public boolean equals(Object arg0) {
		Ferryman ferryman = (Ferryman) arg0;
		
		boolean samePriceList = (ferryman.getPriceList().isEmpty() && priceList.isEmpty())|| ferryman.getPriceList().equals(priceList);
		return (ferryman.getId() == id && ferryman.getName().equals(name)
				&& ferryman.getInsertDate().equals(insertDate) && samePriceList);
	}
	
	public boolean hasSameBussinessKey(Ferryman ferryman){
		return (ferryman.getId()==id || ferryman.getName().equals(name));
	}

	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Ferryman ferryman = new Ferryman();
		ferryman.setId(id);
		ferryman.setInsertDate(insertDate);
		ferryman.setName(name);
		ferryman.setUpdateDate(updateDate);
		return ferryman;
	}
	
	public Ferryman deepClone(){
		Ferryman ferryman = new Ferryman();
		ferryman.setId(id);
		ferryman.setInsertDate(insertDate);
		ferryman.setName(name);
		ferryman.setUpdateDate(updateDate);
		List<Tarif> newPriceList = new ArrayList<Tarif>();
		for(Tarif t : priceList){
			Tarif newTarif = new Tarif();
			newTarif.setId(t.getId());
			newTarif.setInsertDate(t.getInsertDate());
			newTarif.setPrice(t.getPrice());
			newTarif.setUpdateDate(t.getUpdateDate());
			newTarif.setWeight(t.getWeight());
			newPriceList.add(newTarif);
		}
		ferryman.setPriceList(newPriceList);
		return ferryman;
	}
	
}
