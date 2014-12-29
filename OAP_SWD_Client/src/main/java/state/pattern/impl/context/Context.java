package state.pattern.impl.context;

import javax.swing.JFrame;

import state.pattern.interfaces.State;
import application.mode.Mode;
import application.panels.abstraction.AbstractPanel;

public class Context {
	private State state;
	private Mode mode;
	private JFrame frame;
	
	public Context(){
		state=null;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public State getState() {
		return state;
	}
	
	public Mode getMode() {
		return mode;
	}
	
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
	public void frameRefresh(Context context){
		frame.removeAll();
		frame.add(((AbstractPanel)context.getState()).getPanel());
		frame.repaint();
		frame.setVisible(true);
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
