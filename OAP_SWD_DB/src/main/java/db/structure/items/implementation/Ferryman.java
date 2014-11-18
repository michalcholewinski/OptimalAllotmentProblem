package db.structure.items.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "ferryman")
public class Ferryman {
	private Long id;
	private String name;
	private Date insertDate;
	private Date updateDate;
	private List<Tarif> priceList=new ArrayList<Tarif>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;

	}

	public String getName() {
		return name;
	}

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
				&& ferryman.getInsertDate().equals(insertDate) && ferryman
				.getUpdateDate().equals(updateDate) && samePriceList);
	}

}
