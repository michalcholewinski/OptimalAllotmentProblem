package facade.implementation.facades;

import java.util.ArrayList;
import java.util.List;

import oap.utils.exceptions.MyException;
import oap.utils.xml.enums.DatabaseName;
import dao.entities.FerrymanDao;
import dao.entities.FerrymanDaoImpl;
import db.structure.items.implementation.Ferryman;
import db.structure.items.implementation.Tarif;
import facade.implementation.assembler.FerrymanAssembler;
import facade.implementation.assembler.TarifAssembler;
import facade.interfaces.dts.FerrymanDts;
import facade.interfaces.dts.TarifDts;
import facade.interfaces.facades.FerrymanFacade;

public class FerrymanFacadeImpl implements FerrymanFacade{
	private FerrymanDao ferrymanDao;
	private FerrymanAssembler ferrymanAssembler;
	private TarifAssembler tarifAssembler;
	
	public FerrymanFacadeImpl() {
		ferrymanDao=new FerrymanDaoImpl(DatabaseName.PROD_DB);
		ferrymanAssembler=new FerrymanAssembler();
		tarifAssembler = new TarifAssembler();
	}
	
	
	@Override
	public List<FerrymanDts> getFerrymans() {
		List<FerrymanDts> ferrymans = new ArrayList<FerrymanDts>();
		List<Ferryman> ferrymanList = ferrymanDao.findAllFerrymans();
		for(Ferryman f:ferrymanList){
			ferrymans.add(ferrymanAssembler.entityToDts(f));
		}
		return ferrymans;
	}

	@Override
	public void deleteFerryman(FerrymanDts ferryman) throws MyException{
		ferrymanDao.deleteFerryman(ferrymanAssembler.dtsToEntity(ferryman));
		
	}


	@Override
	public FerrymanDts updateFerryman(FerrymanDts ferryman) throws MyException {
		Ferryman updatedFerryman = ferrymanDao.updateFerryman(ferrymanAssembler.dtsToEntity(ferryman));
		return ferrymanAssembler.entityToDts(updatedFerryman);
	}


	@Override
	public FerrymanDts createFerryman(FerrymanDts ferryman) throws MyException {
		Ferryman createdFerryman = ferrymanDao.createFerryman(ferrymanAssembler.dtsToEntity(ferryman));
		return ferrymanAssembler.entityToDts(createdFerryman);
	}


	@Override
	public List<TarifDts> getPriceListByFerrymanId(long id) throws MyException {
		Ferryman ferryman = ferrymanDao.getFerrymanById(id);
		List<TarifDts> priceList = new ArrayList<TarifDts>();
		List<Tarif> tarifList = ferryman.getPriceList();
		for(Tarif t: tarifList){
			priceList.add(tarifAssembler.entityToDts(t));
		}
		return priceList;
	}


	@Override
	public void updatePriceListToFerrymanWithGivenId(long id,
			List<TarifDts> priceList) throws MyException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<TarifDts> addNewTarifToFerrymanWithGivenId(long id,
			TarifDts tarif) throws MyException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deletePriceListWithGivenId(long id) throws MyException {
		// TODO Auto-generated method stub
		
	}

	

}
