package db.structure.items.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.structure.items.Ferryman;
import db.structure.items.Tarif;

public class FerrymanImpl implements Ferryman {
	private Long id;
	private String name;
	private Date insertDate;
	private Date updateDate;
	private List<Tarif> priceList;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Date getInsertDate() {
		return insertDate;
	}

	@Override
	public void setInsertDate(Date date) {
		insertDate = date;
	}

	@Override
	public Date getUpdateDate() {
		return updateDate;
	}

	@Override
	public void setUpdateDate(Date date) {
		updateDate = date;
	}

	@Override
	public List<Tarif> getPriceList() {
		return priceList != null ? priceList : new ArrayList<Tarif>();
	}

	@Override
	public void setPriceList(List<Tarif> priceList) {
		this.priceList = priceList;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
		
	}

	@Override
	public void setName(String name) {
		this.name=name;
		
	}

}
