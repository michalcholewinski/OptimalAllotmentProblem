package db.structure.items.implementation;

import db.structure.items.Sequence;

public class SequenceImpl implements Sequence {
	private Long tarifCurrvalSequence;
	private Long ferrymanCurrvalSequence;
	private Long userCurrvalSequence;

	@Override
	public Long getTarifCurrvalSequence() {
		return tarifCurrvalSequence;
	}

	@Override
	public void setTarifCurrvalSequence(Long currval) {
		tarifCurrvalSequence = currval;
	}

	@Override
	public Long getFerrymanCurrvalSequence() {
		return ferrymanCurrvalSequence;
	}

	@Override
	public void setFerrymanCurrvalSequence(Long currval) {
		ferrymanCurrvalSequence = currval;
	}

	@Override
	public Long getUserCurrvalSequence() {
		return userCurrvalSequence;
	}

	@Override
	public void setUserCurrvalSequence(Long currval) {
		userCurrvalSequence = currval;
	}
}