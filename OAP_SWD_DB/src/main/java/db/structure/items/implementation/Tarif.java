package db.structure.items.implementation;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "tarif")
@XmlType(propOrder = { "id", "weight", "price", "insertDate", "updateDate" })
public class Tarif {

	private Long id;
	private int weight;
	private float price;
	private Date insertDate;
	private Date updateDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;

	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;

	}

	public float getPrice() {
		return price;
	}

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
				&& getInsertDate().equals(insertDate) && getUpdateDate()
				.equals(updateDate));
	}

}
