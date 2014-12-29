package state.interfaces;

import java.awt.event.ActionListener;

import state.pattern.impl.context.Context;
import application.enumeriations.Dialogs;

public interface State extends ActionListener{
	public void proceed(Context context);
	public void back(Context context);
	public Dialogs getDialogsName();
}
