package facade.implementation.assembler;

import db.structure.items.implementation.Tarif;
import facade.implementation.dts.TarifDtsImpl;
import facade.interfaces.dts.TarifDts;

public class TarifAssembler {

	public Tarif dtsToEntity(TarifDts dts){
		Tarif tarif = new Tarif();
		tarif.setId(dts.getId());
		tarif.setPrice(dts.getPrice());
		tarif.setWeight(dts.getWeight());
		return tarif;
	}
	
	public TarifDts entityToDts(Tarif entity){
		TarifDts tarif = new TarifDtsImpl();
		tarif.setId(entity.getId());
		tarif.setPrice(entity.getPrice());
		tarif.setWeight(entity.getWeight());
		return tarif;
	}
	
}
