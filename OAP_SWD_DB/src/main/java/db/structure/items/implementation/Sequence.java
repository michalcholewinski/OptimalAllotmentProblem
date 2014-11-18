package db.structure.items.implementation;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="sequence")
@XmlType(propOrder = { "tarifCurrvalSequence", "ferrymanCurrvalSequence","userCurrvalSequence"})
public class Sequence {
	private Long tarifCurrvalSequence;
	private Long ferrymanCurrvalSequence;
	private Long userCurrvalSequence;

	public Long getTarifCurrvalSequence() {
		return tarifCurrvalSequence;
	}

	public void setTarifCurrvalSequence(Long currval) {
		tarifCurrvalSequence = currval;
	}

	public Long getFerrymanCurrvalSequence() {
		return ferrymanCurrvalSequence;
	}

	public void setFerrymanCurrvalSequence(Long currval) {
		ferrymanCurrvalSequence = currval;
	}

	public Long getUserCurrvalSequence() {
		return userCurrvalSequence;
	}

	public void setUserCurrvalSequence(Long currval) {
		userCurrvalSequence = currval;
	}
}