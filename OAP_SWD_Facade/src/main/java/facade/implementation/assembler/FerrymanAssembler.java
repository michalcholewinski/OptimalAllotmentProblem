package facade.implementation.assembler;

import java.util.Comparator;
import java.util.List;

import db.structure.items.implementation.Ferryman;
import db.structure.items.implementation.Tarif;
import facade.implementation.dts.FerrymanDtsImpl;
import facade.interfaces.dts.FerrymanDts;

public class FerrymanAssembler {

	public FerrymanDts entityToDts(Ferryman entity) {
		FerrymanDts ferryman = new FerrymanDtsImpl();
		ferryman.setId(entity.getId());
		List<Tarif> priceList = entity.getPriceList();
		Tarif t = priceList.stream().max(Comparator.comparing(item -> item.getWeight())).get();
		ferryman.setMaxWeight(t.getWeight());
		ferryman.setPriceListSize(priceList.size());
		return ferryman;
	}
	
	public Ferryman dtsToEntity(FerrymanDts dts){
		Ferryman ferryman = new Ferryman();
		ferryman.setId(dts.getId());
		ferryman.setName(dts.getName());
		return ferryman;
	}
}
