package facade.implementation.facades;

import java.util.ArrayList;
import java.util.List;

import oap.utils.xml.enums.DatabaseName;
import dao.entities.FerrymanDao;
import dao.entities.FerrymanDaoImpl;
import db.structure.items.implementation.Ferryman;
import db.structure.items.implementation.Tarif;
import facade.implementation.assembler.TarifAssembler;
import facade.implementation.dts.ChoosenFerrymanDtsImpl;
import facade.interfaces.dts.AllotmentCalculationDts;
import facade.interfaces.dts.ChoosenFerrymanDts;
import facade.interfaces.facades.AllotmentCalculationFacade;

public class AllotmentCalculationFacadeImpl implements
		AllotmentCalculationFacade {
	private FerrymanDao ferrymanDao;
	private final int PALLET_WEIGHT = 100; // /kg

	public AllotmentCalculationFacadeImpl() {
		ferrymanDao = new FerrymanDaoImpl(DatabaseName.PROD_DB);
	}

	@Override
	public AllotmentCalculationDts performCalculationForWeight(int weight) {
		List<Ferryman> ferrymans = ferrymanDao.findAllFerrymans();
		List<Ferryman> appropriateFerrymans = findAppropriateFerrymans(weight,
				ferrymans);
		if (appropriateFerrymans.size() < 1)
			return null;
		List<PriceListTableRow> priceListTable = createPriceListTable(
				appropriateFerrymans, weight);
		
		
		//TODO priceListTable obliczenia

		return null;
	}

	private List<PriceListTableRow> createPriceListTable(
			List<Ferryman> appropriateFerrymans, int weight) {
		List<PriceListTableRow> priceListTable = new ArrayList<PriceListTableRow>();

		int numberOfCols = (weight / PALLET_WEIGHT);
		for (Ferryman ferryman : appropriateFerrymans) {
			priceListTable.add(createRow(ferryman, numberOfCols));
		}
		return priceListTable;
	}

	public PriceListTableRow createRow(Ferryman ferryman, int numberOfCols) {
		PriceListTableRow row = new PriceListTableRow(numberOfCols);
		TarifAssembler assembler=new TarifAssembler();
		
		for (Tarif t: ferryman.getPriceList()) {
			ChoosenFerrymanDts choosenFerryman = new ChoosenFerrymanDtsImpl();
			choosenFerryman.setId(ferryman.getId());
			choosenFerryman.setName(ferryman.getName());
			choosenFerryman.setTarif(assembler.entityToDts(t));
		}

		return row;
	}

	public List<Ferryman> findAppropriateFerrymans(int weight,
			List<Ferryman> ferrymans) {
		List<Ferryman> appropriateFerrymans = new ArrayList<Ferryman>();
		ferrymans
				.stream()
				.filter(item -> item.getPriceList().size() > (weight / PALLET_WEIGHT))
				.forEach(appropriateFerrymans::add);
		return appropriateFerrymans;
	}

	private class PriceListTableRow {
		private PriceListTableCell[] row;

		public PriceListTableRow(int numberOfCols) {
			row = new PriceListTableCell[numberOfCols];
		}

		public PriceListTableCell[] getRow() {
			return row;
		}

	}

	private class PriceListTableCell {
		private List<ChoosenFerrymanDts> ferrymans; // initially one item inside
		private float totalPrice;

		public PriceListTableCell() {
			ferrymans = new ArrayList<ChoosenFerrymanDts>();
		}

		public List<ChoosenFerrymanDts> getFerrymans() {
			return ferrymans;
		}

		public void setFerrymans(List<ChoosenFerrymanDts> ferrymans) {
			this.ferrymans = ferrymans;
		}

		public void addToFerrymans(ChoosenFerrymanDts ferryman) {
			ferrymans.add(ferryman);
		}

		public float getTotalPrice() {
			totalPrice = calculateTotalPrice();
			return totalPrice;
		}

		private float calculateTotalPrice() {
			float totalPrice = 0f;
			for (ChoosenFerrymanDts f : ferrymans) {
				totalPrice += f.getTarif().getPrice();
			}
			return totalPrice;
		}
	}
}
