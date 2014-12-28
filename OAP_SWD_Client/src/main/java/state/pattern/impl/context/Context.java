package state.pattern.impl.context;

import application.mode.Mode;
import state.pattern.interfaces.State;

public class Context {
	private State state;
	private Mode mode;
	
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
}
