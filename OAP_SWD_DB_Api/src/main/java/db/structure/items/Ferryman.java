package db.structure.items;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ferryman")
public interface Ferryman {
	public Long getId();
	public void setId(Long id);
	public String getName();
	public void setName(String name);
	public Date getInsertDate();
	public void setInsertDate(Date date);
	public Date getUpdateDate();
	public void setUpdateDate(Date date);
	
	public List<Tarif> getPriceList();
	@XmlElementWrapper(name = "priceList")
	@XmlElement(name = "tarif")
	public void setPriceList(List<Tarif> priceList);
}
