package main;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import state.pattern.impl.context.Context;
import application.enumeriations.Dialogs;
import application.panels.FerrymanDetailsPanel;
import application.panels.FerrymansManagementPanel;
import application.panels.MainPanel;
import application.panels.OptimalAllotmentCalculationPanel;
import application.panels.UserDetailsPanel;
import application.panels.UsersManagementPanel;

public class ApplicationClient implements Runnable {
	public static final int WINDOW_SIZE_X = 640;
	public static final int WINDOW_SIZE_Y = 480;
	public static CardLayout cards=new CardLayout();

	private void init() {
		JFrame frame = new JFrame("Optimal Allotment Problem");
		frame.setSize(WINDOW_SIZE_X, WINDOW_SIZE_Y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Context context = new Context();
		context.setFrame(frame);
		context.setState(new MainPanel());
		context.getState().setContext(context);
//		context.setState(new FerrymansManagementPanel());
//		context.setState(new UsersManagementPanel());
//		context.setState(new FerrymansDetailsPanel());
//		context.setState(new UserDetailsPanel());
//		context.setState(new OptimalAllotmentCalculationPanel());
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(cards);
		mainPanel.add(new MainPanel().getPanel(),Dialogs.MAIN_PANEL.getName());
		mainPanel.add(new FerrymansManagementPanel().getPanel(),Dialogs.FERRYMANS_MANAGEMENT.getName());
		mainPanel.add(new UsersManagementPanel().getPanel(),Dialogs.USERS_MANAGEMENT.getName());
		mainPanel.add(new FerrymanDetailsPanel().getPanel(),Dialogs.FERRYMAN_DETAILS.getName());
		mainPanel.add(new UserDetailsPanel().getPanel(),Dialogs.USER_DETAILS.getName());
		mainPanel.add(new OptimalAllotmentCalculationPanel().getPanel(),Dialogs.OPTIMAL_ALLOTMENT_CALCULATION.getName());
		
//		frame.add(((AbstractPanel)context.getState()).getPanel());
frame.add(mainPanel);
		frame.setVisible(true);
	}

	@Override
	public void run() {
		init();
	}

	public static void main(String[] args) {
		Thread t = new Thread(new ApplicationClient());
		t.run();
	}

}
