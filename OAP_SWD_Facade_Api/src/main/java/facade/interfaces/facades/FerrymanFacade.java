package facade.interfaces.facades;

import java.util.List;

import oap.utils.exceptions.MyException;
import facade.interfaces.dts.FerrymanDts;
import facade.interfaces.dts.TarifDts;

public interface FerrymanFacade {
	public List<FerrymanDts> getFerrymans();
	public void deleteFerryman(FerrymanDts ferryman) throws MyException;
	public FerrymanDts updateFerryman(FerrymanDts ferryman) throws MyException;
	public FerrymanDts createFerryman(FerrymanDts ferryman) throws MyException;
	public List<TarifDts> getPriceListByFerrymanId(long id) throws MyException;
	public void updatePriceListToFerrymanWithGivenId(long id,List<TarifDts> priceList) throws MyException;
	public List<TarifDts> addNewTarifToFerrymanWithGivenId(long id, TarifDts tarif) throws MyException;
	public void deleteTarifWithGivenId(long id) throws MyException;
}
