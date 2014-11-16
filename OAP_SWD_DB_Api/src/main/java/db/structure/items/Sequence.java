package db.structure.items;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="sequence")
@XmlType(propOrder = { "tarifCurrvalSequence", "ferrymanCurrvalSequence","userCurrvalSequence"})
public interface Sequence {
	public Long getTarifCurrvalSequence();
	public void setTarifCurrvalSequence(Long currval);
	
	public Long getFerrymanCurrvalSequence();
	public void setFerrymanCurrvalSequence(Long currval);

	public Long getUserCurrvalSequence();
	public void setUserCurrvalSequence(Long currval);
	
	

}
