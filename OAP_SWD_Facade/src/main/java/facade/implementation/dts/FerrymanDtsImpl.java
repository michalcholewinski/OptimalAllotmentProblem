package facade.implementation.dts;

import facade.interfaces.dts.FerrymanDts;

public class FerrymanDtsImpl implements FerrymanDts {
	private long id;
	private String name;
	private int priceListSize;
	private int maxWeight;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int priceListSize() {
		return priceListSize;
	}

	@Override
	public int getMaxWeight() {
		return maxWeight;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setPriceListSize(int size) {
		this.priceListSize = size;
	}

	@Override
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id=id;
	}

}
