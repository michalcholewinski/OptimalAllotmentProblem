package application.panels;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import state.pattern.impl.context.Context;
import application.beans.OptimalAllotmentCalculationModelBean;
import application.enumeriations.Dialogs;
import application.panels.abstraction.AbstractPanel;

public class OptimalAllotmentCalculationPanel extends AbstractPanel<OptimalAllotmentCalculationModelBean> {
	private JPanel mainContent;


	public OptimalAllotmentCalculationPanel() {
		super();
		dialog=Dialogs.OPTIMAL_ALLOTMENT_CALCULATION;
		buildMainPanel();
		addBackButton();
	}

	private void buildMainPanel() {
		mainContent=new JPanel();
		mainContent.setBackground(BACKGROUND);
		content.add(mainContent);
	}

	@Override
	public void proceed(Context context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void back(Context context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retrieveData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);		
	}

}
