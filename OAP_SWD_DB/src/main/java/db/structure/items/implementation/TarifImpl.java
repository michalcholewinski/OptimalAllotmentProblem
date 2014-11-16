package db.structure.items.implementation;

import java.util.Date;

import db.structure.items.Tarif;

public class TarifImpl implements Tarif {

	private Long id;
	private int weight;
	private float price;
	private Date insertDate;
	private Date updateDate;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;

	}

	@Override
	public int getWeight() {
		return weight;
	}

	@Override
	public void setWeight(int weight) {
		this.weight=weight;

	}

	@Override
	public float getPrice() {
		return price;
	}

	@Override
	public void setPrice(float price) {
		this.price=price;

	}

	@Override
	public Date getInsertDate() {
		return insertDate;
	}

	@Override
	public void setInsertDate(Date date) {
		insertDate=date;

	}

	@Override
	public Date getUpdateDate() {
		return updateDate;
	}

	@Override
	public void setUpdateDate(Date date) {
		updateDate=date;

	}

}
