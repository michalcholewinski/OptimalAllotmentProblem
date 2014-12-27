package facade.implementation.dts;

import facade.interfaces.dts.TarifDts;

public class TarifDtsImpl implements TarifDts{
	
	private long id;
	private int weight;
	private float price;
	@Override
	public long getId() {
		return id;
	}
	@Override
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public int getWeight() {
		return weight;
	}
	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public float getPrice() {
		return price;
	}
	@Override
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	

}
