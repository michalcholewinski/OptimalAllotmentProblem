package facade.interfaces.facades;

import java.util.List;

import facade.interfaces.dts.FerrymanDts;
import facade.interfaces.dts.TarifDts;

public interface FerrymanFacade {
	public List<FerrymanDts> getFerrymans();
	public void deleteFerryman(FerrymanDts ferryman);
	public FerrymanDts updateFerryman(FerrymanDts ferryman);
	public FerrymanDts createFerryman(FerrymanDts ferryman);
	public List<TarifDts> getPriceListByFerrymanId(long id);
	public void updatePriceListToFerrymanWithGivenId(long id,List<TarifDts> priceList);
	public List<TarifDts> addNewTarifToFerrymanWithGivenId(long id, TarifDts tarif);
	public void deletePriceListWithGivenId(long id);
}
