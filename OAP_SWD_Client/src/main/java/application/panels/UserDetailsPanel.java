package application.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.ApplicationClient;
import state.pattern.impl.context.Context;
import application.beans.UserDetailsModelBean;
import application.enumeriations.Dialogs;
import application.panels.abstraction.AbstractPanel;

public class UserDetailsPanel extends AbstractPanel<UserDetailsModelBean> {
	private JButton save;
	private JPanel mainContent;
	private JTextField name;
	private JTextField surname;
	private JTextField login;
	private JTextField password;
	
	public UserDetailsPanel() {
		super();
		dialog=Dialogs.USER_DETAILS;
		buildMainPanel();
		addSaveButton();
		addBackButton();
	}

	private void buildMainPanel() {
		mainContent=new JPanel();
		mainContent.setBackground(BACKGROUND);
		mainContent.setLayout(new BorderLayout());
		mainContent.add(addFieldsPanel(), BorderLayout.CENTER);
		content.add(mainContent);
	}

	private JPanel addFieldsPanel() {
		JPanel panel=new JPanel();
		panel.setPreferredSize(new Dimension(ApplicationClient.WINDOW_SIZE_X/2,ApplicationClient.WINDOW_SIZE_Y/6));
		panel.setBackground(BACKGROUND);
		panel.setLayout(new GridLayout(4,2));
		JLabel nameLabel=new JLabel();
		nameLabel.setText("Imi�: ");
		JLabel surnameLabel=new JLabel();
		surnameLabel.setText("Nazwisko: ");
		JLabel loginLabel=new JLabel();
		loginLabel.setText("Login: ");
		JLabel passLabel=new JLabel();
		passLabel.setText("Haslo: ");
		name = new JTextField();
		surname = new JTextField();
		login=new JTextField();
		password=new JPasswordField();
		
		panel.add(nameLabel);
		panel.add(name);
		panel.add(surnameLabel);
		panel.add(surname);
		panel.add(loginLabel);
		panel.add(login);
		panel.add(passLabel);
		panel.add(password);
		
		
		return panel;
	}

	private void addSaveButton() {
		save=new JButton("Zapisz");
		footer.add(save, BorderLayout.CENTER);
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
