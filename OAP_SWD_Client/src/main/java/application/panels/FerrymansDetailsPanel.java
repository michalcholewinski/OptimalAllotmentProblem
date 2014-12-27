package application.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import main.ApplicationClient;
import state.pattern.impl.context.Context;
import application.beans.FerrymanDetailsModelBean;
import application.panels.abstraction.AbstractPanel;

public class FerrymansDetailsPanel extends AbstractPanel<FerrymanDetailsModelBean> {

	private static final int ROWS = 1;
	private static final int COLS = 2;
	private JPanel mainContent;
	private JPanel ferrymanDetails;
	private JPanel priceList;
	private JButton save;
	private JLabel nameLabel;
	private JTextField name;
	private JLabel maxWeightLabel;
	private JLabel priceListSizeLabel;
	
	public FerrymansDetailsPanel() {
		super();
		retrieveData();
		buildMainPanel();
		addBackButton();
		addSaveButton();
		
	}

	private void addSaveButton() {
		save = new JButton("Zapisz");
		footer.add(save, BorderLayout.CENTER);
	}

	private void buildMainPanel() {
		mainContent=new JPanel();
		mainContent.setBackground(BACKGROUND);
		mainContent.setLayout(new GridLayout(ROWS,COLS));
		ferrymanDetails=new JPanel();
		ferrymanDetails.setBackground(BACKGROUND);
		ferrymanDetails.add(addLabelsAndFields());
		priceList = new JPanel();
		priceList.setBackground(BACKGROUND);
		JScrollPane scrollPane = new JScrollPane(priceList);
		scrollPane.setPreferredSize(new Dimension((ApplicationClient.WINDOW_SIZE_X/2)-10,ApplicationClient.WINDOW_SIZE_Y-120));
		mainContent.add(ferrymanDetails);
		mainContent.add(scrollPane);
		
		content.add(mainContent);
	}

	private JPanel addLabelsAndFields() {
		JPanel panel= new JPanel();
		panel.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.YELLOW));
		panel.setLayout(new GridLayout(3,1,10,10));	
		JPanel namePanel=new JPanel();
		namePanel.setLayout(new GridLayout(1,2));
		nameLabel=new JLabel();
		nameLabel.setText("Nazwa: ");
		name=new JTextField();
		namePanel.add(nameLabel,BorderLayout.WEST);
		namePanel.add(name,BorderLayout.EAST);
		maxWeightLabel=new JLabel();
		maxWeightLabel.setText("Maksymalna waga: ");
		priceListSizeLabel=new JLabel();
		priceListSizeLabel.setText("Ilo�� cennik�w: ");
		panel.add(namePanel);
		panel.add(maxWeightLabel);
		panel.add(priceListSizeLabel);
		
		
		return panel;
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
