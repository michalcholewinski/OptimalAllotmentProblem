package facade.implementation.dts;

import java.util.List;

import facade.interfaces.dts.AllotmentCalculationDts;
import facade.interfaces.dts.ChoosenFerrymanDts;

public class AllotmentCalculationDtsImpl implements AllotmentCalculationDts {
	private List<ChoosenFerrymanDts> ferrymans;

	@Override
	public List<ChoosenFerrymanDts> getFerrymans() {
		return ferrymans;
	}

	@Override
	public void setFerrymans(List<ChoosenFerrymanDts> ferrymans) {
		this.ferrymans = ferrymans;
	}

}
