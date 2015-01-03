package facade.implementation.dts;

import facade.interfaces.dts.ChoosenFerrymanDts;
import facade.interfaces.dts.TarifDts;

public class ChoosenFerrymanDtsImpl implements ChoosenFerrymanDts {
	private long id;
	private String name;
	private TarifDts tarif;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public TarifDts getTarif() {
		return tarif;
	}

	@Override
	public void setTarif(TarifDts tarif) {
		this.tarif = tarif;
	}
}