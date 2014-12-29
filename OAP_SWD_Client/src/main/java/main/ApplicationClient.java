package main;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import state.interfaces.State;
import application.enumeriations.Dialogs;
import application.panels.FerrymanDetailsPanel;
import application.panels.FerrymansManagementPanel;
import application.panels.MainPanel;
import application.panels.OptimalAllotmentCalculationPanel;
import application.panels.UserDetailsPanel;
import application.panels.UsersManagementPanel;
import application.panels.abstraction.AbstractPanel;

public class ApplicationClient implements Runnable {
	public static final int WINDOW_SIZE_X = 640;
	public static final int WINDOW_SIZE_Y = 480;
	public static CardLayout cards = new CardLayout();
	public static List<State> states = new ArrayList<State>();

	private void init() {
		JFrame frame = new JFrame("Optimal Allotment Problem");
		frame.setSize(WINDOW_SIZE_X, WINDOW_SIZE_Y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addStates();
		frame.add(addCards());
		frame.setVisible(true);
	}

	private void addStates() {
		states.add(new MainPanel());
		states.add(new FerrymanDetailsPanel());
		states.add(new UsersManagementPanel());
		states.add(new UserDetailsPanel());
		states.add(new FerrymansManagementPanel());
		states.add(new OptimalAllotmentCalculationPanel());
	}

	private JPanel addCards() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(cards);
		for (State s : states) {
			mainPanel.add(((AbstractPanel) s).getPanel(), s.getDialogsName()
					.getName());
		}
		cards.show(mainPanel, Dialogs.MAIN_PANEL.getName());
		return mainPanel;
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
