package application.panels.abstraction;

import javax.swing.JPanel;

import state.pattern.impl.context.Context;
import state.pattern.interfaces.State;

public abstract class AbstractPanel<T> implements State {
	protected Context context;
	protected final JPanel panel;
	protected T modelBean;
	
	public AbstractPanel() {
		panel = new JPanel();
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
