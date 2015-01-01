package application.panels.abstraction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import facade.implementation.facades.CommonFacadeImpl;
import facade.interfaces.facades.CommonFacade;
import main.ApplicationClient;
import state.interfaces.State;
import application.enumeriations.Dialogs;
import application.panels.FerrymanDetailsPanel;
import application.panels.FerrymansManagementPanel;
import application.panels.UserDetailsPanel;

public abstract class AbstractPanel<T> implements State {
	private static final int _FONT_SIZE = 16;
	// protected Context context;

	protected Dialogs dialog;
	private final JPanel panel;
	protected final JPanel content;
	protected JPanel footer;
	private JPanel header;
	private JLabel optimalAllotmentProblemLabel;
	private JButton exit;
	private final float[] HSBColor = Color.RGBtoHSB(240, 150, 135, null);
	protected final Color BACKGROUND = Color.getHSBColor(HSBColor[0],
			HSBColor[1], HSBColor[2]);
	private JButton back;

	protected T modelBean;
	private CommonFacade commonFacade;

	public AbstractPanel() {
		commonFacade=new CommonFacadeImpl();
		panel = new JPanel();

		panel.setLayout(new BorderLayout());
		content = new JPanel();
		content.setLayout(new FlowLayout());
		content.setBackground(BACKGROUND);
		createHeader();
		createFooter();

		panel.add(header, BorderLayout.NORTH);
		panel.add(content, BorderLayout.CENTER);
		panel.add(footer, BorderLayout.SOUTH);
	}

	public abstract void retrieveData();

	private void createHeader() {
		header = new JPanel();
		header.setBackground(BACKGROUND);
		header.setLayout(new FlowLayout());
		optimalAllotmentProblemLabel = new JLabel();
		optimalAllotmentProblemLabel.setText("PROBLEM OPTYMALNEGO PRZYDZIA£U");
		optimalAllotmentProblemLabel.setForeground(Color.BLUE);
		Font font = new Font(Font.DIALOG, Font.BOLD, _FONT_SIZE);
		optimalAllotmentProblemLabel.setFont(font);
		header.add(optimalAllotmentProblemLabel);

	}

	protected void addBackButton() {
		back = new JButton("WSTECZ");
		back.addActionListener(this);
		footer.add(back, BorderLayout.WEST);

	}

	private void createFooter() {
		footer = new JPanel();
		footer.setBackground(BACKGROUND);
		footer.setLayout(new BorderLayout());
		exit = new JButton("WYJSCIE");
		exit.addActionListener(this);
		footer.add(exit, BorderLayout.EAST);

	}

	public JPanel getPanel() {
		return panel;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		
		if (source.equals(back)) {
			if (this instanceof UserDetailsPanel) {
				switchPanel(Dialogs.USERS_MANAGEMENT);
				return;
			} else if (this instanceof FerrymanDetailsPanel) {
				State panel = ApplicationClient.states
						.stream()
						.filter(item -> item.getDialogsName() == Dialogs.FERRYMANS_MANAGEMENT)
						.findFirst().get();
				((FerrymansManagementPanel)panel).init();
				switchPanel(Dialogs.FERRYMANS_MANAGEMENT);
				return;
			} else {
				switchPanel(Dialogs.MAIN_PANEL);
				return;
			}
		}else if(source.equals(exit)){
			commonFacade.commit();
			System.exit(0);
		}
	}

	protected void switchPanel(Dialogs dialog) {
		Container parent = panel.getParent();
		ApplicationClient.cards.show(parent, dialog.getName());

	}

	@Override
	public Dialogs getDialogsName() {
		return dialog;
	}

}
