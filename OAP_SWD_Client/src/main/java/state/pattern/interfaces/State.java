package state.pattern.interfaces;

import state.pattern.impl.context.Context;

public interface State {
	public void proceed(Context context);
	public void back(Context context);
}
