package application.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.ApplicationClient;
import state.pattern.impl.context.Context;
import application.beans.FerrymansManagementModelBean;
import application.panels.abstraction.AbstractPanel;
import facade.implementation.dts.FerrymanDtsImpl;
import facade.interfaces.dts.FerrymanDts;

public class FerrymansManagementPanel extends AbstractPanel<FerrymansManagementModelBean>{
	private static final int SPACING = 5;
	private JPanel contentPanel;
	private JScrollPane ferrymansList;
	private JPanel ferrymansListPanel;
	private JButton newFerryman;
	
	public FerrymansManagementPanel() {
		super();
		retrieveData();
		buildContentPanel();
		addBackButton();
		addNewFerrymanButton();
		
	}
	
	private void addNewFerrymanButton() {
		newFerryman=new JButton("Dodaj przewo�nika");
		footer.add(newFerryman, BorderLayout.CENTER);
	}


	private void buildContentPanel() {
		contentPanel=new JPanel();
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBackground(BACKGROUND);
		ferrymansListPanel=new JPanel();
		ferrymansListPanel.setBackground(BACKGROUND);
		ferrymansListPanel.setLayout(new GridLayout(modelBean.getNumberOfFerrymans(),1,SPACING,SPACING));
		ferrymansList = new JScrollPane(ferrymansListPanel);
		ferrymansList.setPreferredSize(new Dimension(ApplicationClient.WINDOW_SIZE_X-50,ApplicationClient.WINDOW_SIZE_Y-120));
		ferrymansList.setBackground(BACKGROUND);
		contentPanel.add(ferrymansList);
		content.add(contentPanel);
		
		createFerrymanList();
	}

	private List<FerrymanDts> createTestFerrymanList() {
		// TODO to remove, only for tests
		List<FerrymanDts> f = new ArrayList<FerrymanDts>();	
		for(int i=0; i<20; i++){
			FerrymanDts ff=new FerrymanDtsImpl();
			ff.setMaxWeight(1000);
			ff.setName("Ferryman nr "+i);
			ff.setPriceListSize(10);
			f.add(ff);
		}
		return f;
	}
	
	private void createFerrymanList() {
		int i=0;
		for(FerrymanDts f: modelBean.getFerrymans()){
			prepareRow(f, !(i++%2==0));
			
		}
		
	}


	private void prepareRow(FerrymanDts ferryman, boolean isOdd) {
		JButton details = new JButton("Szczeg�y");
		JButton delete = new JButton("Usu�");
		
		Color bgColor;
		JLabel label=new JLabel();
		label.setText("Nazwa: "+ferryman.getName()+" Maksymalna waga: "+ferryman.getMaxWeight());
		bgColor= isOdd ? Color.yellow : Color.gray;
		JPanel row = new JPanel();
		row.setBorder(BorderFactory.createLineBorder(Color.red));
		row.setBackground(bgColor);
		row.setLayout(new FlowLayout());
		row.add(label);
		row.add(details);
		row.add(delete);
		
		
		ferrymansListPanel.add(row);
		
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
		modelBean = new FerrymansManagementModelBean();
		modelBean.setFerrymans(createTestFerrymanList()); //only for testing
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
