package db.structure.items;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="tarif")
@XmlType(propOrder = { "id","weight", "price","insertDate","updateDate"})
public interface Tarif {
	public Long getId();
	public void setId(Long id);
	public int getWeight();
	public void setWeight(int weight);
	public float getPrice();
	public void setPrice(float price);
	public Date getInsertDate();
	public void setInsertDate(Date date);
	public Date getUpdateDate();
	public void setUpdateDate(Date date);
	
}
