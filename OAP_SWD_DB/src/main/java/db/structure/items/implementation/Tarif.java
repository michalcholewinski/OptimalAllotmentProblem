package db.structure.items.implementation;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "tarif")
@XmlType(propOrder = { "id", "weight", "price", "insertDate", "updateDate" })
public class Tarif {

	private long id;
	private int weight;
	private float price;
	private Date insertDate;
	private Date updateDate;

	public Tarif() {
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

	public int getWeight() {
		return weight;
	}
	
	@XmlElement(required=true)
	public void setWeight(int weight) {
		this.weight = weight;

	}

	public float getPrice() {
		return price;
	}

	@XmlElement(required=true)
	public void setPrice(float price) {
		this.price = price;
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

	@Override
	public boolean equals(Object arg0) {
		Tarif tarif = (Tarif) arg0;

		return (tarif.getWeight() == weight && tarif.getId() == id
				&& tarif.getPrice() == price
				&& getInsertDate().equals(insertDate));
	}

	
	public boolean hasSameBussinessKey(Tarif tarif){
		return (tarif.getId()==id || tarif.getWeight()==weight);
	}
}
