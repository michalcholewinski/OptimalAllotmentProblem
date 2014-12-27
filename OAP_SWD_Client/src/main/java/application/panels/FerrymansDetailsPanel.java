package application.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

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
	private JLabel maxWeightLabel;
	private JLabel priceListSizeLabel;
	private JTextField name;
	
	public FerrymansDetailsPanel() {
		super();
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
		priceList = new JPanel();
		priceList.setBackground(BACKGROUND);
		JScrollPane scrollPane = new JScrollPane(priceList);
		scrollPane.setPreferredSize(new Dimension((ApplicationClient.WINDOW_SIZE_X/2)-10,ApplicationClient.WINDOW_SIZE_Y-120));
		mainContent.add(ferrymanDetails);
		mainContent.add(scrollPane);
		
		
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
	protected void retrieveData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
