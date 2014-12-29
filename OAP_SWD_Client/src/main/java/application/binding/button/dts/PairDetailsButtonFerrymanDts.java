package application.binding.button.dts;

import javax.swing.JButton;

import facade.interfaces.dts.FerrymanDts;

public class PairDetailsButtonFerrymanDts {

	private final JButton button;
	private final FerrymanDts ferryman;
	
	public PairDetailsButtonFerrymanDts(JButton button,FerrymanDts ferryman) {
		this.button=button;
		this.ferryman=ferryman;
	}
	
	public JButton getButton() {
		return button;
	}
	
	public FerrymanDts getFerryman() {
		return ferryman;
	}
}
