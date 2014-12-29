package application.panels;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.ApplicationClient;
import state.pattern.impl.context.Context;
import application.beans.MainPanelModelBean;
import application.enumeriations.Dialogs;
import application.panels.abstraction.AbstractPanel;

public class MainPanel extends AbstractPanel<MainPanelModelBean> {
	private static final int LINES = 2;
	private static final int ROWS = 1;
	private static final int MENU_ROWS = 3;
	private static final int MENU_LINES = 1;
	private static final int SPACING = 5;
	private JButton ferrymansManagement;
	private JButton usersManagement;
	private JButton optimalAllotmentCalculation;
	
	private JPanel menuPanel;
	private JPanel contentPanel;
	private JPanel mainContainer;
	
	
	
	public MainPanel() {
		super();
		buildPanel();
	}

	
	private void buildPanel(){
		initPannels();
		createMenuPanel();
		content.add(mainContainer);
		
	}
	
	private void createMenuPanel() {
		initButtons();
		menuPanel.add(ferrymansManagement);
		menuPanel.add(usersManagement);
		menuPanel.add(optimalAllotmentCalculation);
	}


	private void initButtons() {
		ferrymansManagement=new JButton("ZARZADZANIE PRZEWO�NIKAMI");
		ferrymansManagement.addActionListener(this);
		usersManagement = new JButton("ZARZ�DZANIE U�YTKOWNIKAMI");
		usersManagement.addActionListener(this);
		optimalAllotmentCalculation = new JButton("OBLICZENIE OPTYMALNEGO PRZYDZIA�U");
		optimalAllotmentCalculation.addActionListener(this);
	}


	private void initPannels() {
		mainContainer=new JPanel();
		mainContainer.setBackground(BACKGROUND);
		mainContainer.setLayout(new GridLayout(ROWS,LINES));
		JPanel additionalPanel = new JPanel();
		additionalPanel.setBackground(BACKGROUND);
		additionalPanel.setLayout(new BorderLayout());
		mainContainer.add(additionalPanel);
		menuPanel=new JPanel();
		menuPanel.setBackground(BACKGROUND);
		menuPanel.setLayout(new GridLayout(MENU_ROWS,MENU_LINES,SPACING,SPACING));
		contentPanel=new JPanel();
		contentPanel.setBackground(BACKGROUND);
		additionalPanel.add(menuPanel, BorderLayout.SOUTH);
		mainContainer.add(contentPanel);
	}


	@Override
	public void proceed(Context context) {
		
	}

	@Override
	public void back(Context context) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void retrieveData() {
		//nothing to do
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		Container parent = getPanel().getParent();
		
		if(source.equals(ferrymansManagement)){
			ApplicationClient.cards.show(parent, Dialogs.FERRYMANS_MANAGEMENT.getName());
		}else if(e.getSource().equals(usersManagement)){
			context.setState(new UsersManagementPanel());
		}else if(e.getSource().equals(optimalAllotmentCalculation)){
			context.setState(new UsersManagementPanel());
		}
//		context.frameRefresh(context);
		
	}

}
