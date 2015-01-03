package facade.interfaces.dts;

public interface ChoosenFerrymanDts {
	public long getId();
	public void setId(long id);
	public String getName();
	public void setName(String name);
	public TarifDts getTarif();
	public void setTarif(TarifDts tarif);
}
