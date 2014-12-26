package application.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.ApplicationClient;
import state.pattern.impl.context.Context;
import application.beans.UsersManagementModelBean;
import application.panels.abstraction.AbstractPanel;
import facade.interfaces.dts.FerrymanDts;
import facade.interfaces.dts.UserDts;

public class UsersManagementPanel extends AbstractPanel<UsersManagementModelBean>{
	private static final int SPACING = 5;
	private JPanel contentPanel;
	private JScrollPane usersList;
	private JPanel usersListPanel;
	
	
	public UsersManagementPanel() {
		super();
		retrieveData();
		buildContentPanel();
		addBackButton();
	}

	private void buildContentPanel() {
		contentPanel=new JPanel();
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBackground(BACKGROUND);
		usersListPanel=new JPanel();
		usersListPanel.setBackground(BACKGROUND);
		usersListPanel.setLayout(new GridLayout(modelBean.getNumberOfUsers(),1,SPACING,SPACING));
		usersList = new JScrollPane(usersListPanel);
		usersList.setPreferredSize(new Dimension(ApplicationClient.WINDOW_SIZE_X-50,ApplicationClient.WINDOW_SIZE_Y-120));
		usersList.setBackground(BACKGROUND);
		contentPanel.add(usersList);
		content.add(contentPanel);
		
		createFerrymanList();
	}
	
	private void createFerrymanList() {
		int i=0;
		for(UserDts u: modelBean.getUsers()){
			prepareRow(u, !(i++%2==0));
		}
	}

	private void prepareRow(UserDts user, boolean isOdd) {
		JButton details = new JButton("Szczeg�y");
		JButton delete = new JButton("Usu�");
		
		Color bgColor;
		JLabel label=new JLabel();
		label.setText("Imie: "+user.getName()+" Maksymalna waga: "+user.getSurname());
		bgColor= isOdd ? Color.yellow : Color.gray;
		JPanel row = new JPanel();
		row.setBorder(BorderFactory.createLineBorder(Color.red));
		row.setBackground(bgColor);
		row.setLayout(new FlowLayout());
		row.add(label);
		row.add(details);
		row.add(delete);
		usersListPanel.add(row);
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
	protected void retrieveData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
