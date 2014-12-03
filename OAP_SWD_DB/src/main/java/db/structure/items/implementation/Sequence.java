package db.structure.items.implementation;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="sequence")
@XmlType(propOrder = { "tarifCurrvalSequence", "ferrymanCurrvalSequence","userCurrvalSequence"})
public class Sequence {
	private long tarifCurrvalSequence;
	private long ferrymanCurrvalSequence;
	private long userCurrvalSequence;

	public long getTarifCurrvalSequence() {
		return tarifCurrvalSequence;
	}

	public void setTarifCurrvalSequence(long currval) {
		tarifCurrvalSequence = currval;
	}

	public long getFerrymanCurrvalSequence() {
		return ferrymanCurrvalSequence;
	}

	public void setFerrymanCurrvalSequence(long currval) {
		ferrymanCurrvalSequence = currval;
	}

	public long getUserCurrvalSequence() {
		return userCurrvalSequence;
	}

	public void setUserCurrvalSequence(long currval) {
		userCurrvalSequence = currval;
	}
}