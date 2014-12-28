package application.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

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
import facade.implementation.dts.FerrymanDtsImpl;
import facade.implementation.dts.TarifDtsImpl;
import facade.interfaces.dts.FerrymanDts;
import facade.interfaces.dts.TarifDts;

public class FerrymansDetailsPanel extends AbstractPanel<FerrymanDetailsModelBean> {

	private static final int MANY_ROWS = 0;
	private static final int PRICELSIT_ROWS = 1;
	private static final int PRICELIST_COLS = 2;
	private static final Color PRICE_BG = Color.MAGENTA;
	private static final Color WEIGHT_BG = Color.YELLOW;
	private static final int ROWS = 1;
	private static final int COLS = 2;
	private JPanel mainContent;
	private JPanel ferrymanDetails;
	private JPanel priceListPanel;
	private JButton save;
	private JButton addTarif;
	private JLabel nameLabel;
	private JTextField name;
	private JLabel maxWeightLabel;
	private JLabel priceListSizeLabel;
	
	public FerrymansDetailsPanel() {
		super();
		retrieveData();
		buildMainPanel();
		addTarifButton();
		addBackButton();
		addSaveButton();
		
	}

	private void addTarifButton() {
		addTarif=new JButton("Dodaj cen�");
		ferrymanDetails.add(addTarif);
		
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
		priceListPanel = new JPanel();
		
		priceListPanel.setLayout(new BorderLayout());
		priceListPanel.setBackground(BACKGROUND);
		priceListPanel.add(addPriceList(),BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(priceListPanel);
		scrollPane.setPreferredSize(new Dimension((ApplicationClient.WINDOW_SIZE_X/2)-10,ApplicationClient.WINDOW_SIZE_Y-120));
		mainContent.add(ferrymanDetails);
		mainContent.add(scrollPane);
		content.add(mainContent);
	}

	private JPanel addPriceList() {
		JPanel newPanel=new JPanel();
		newPanel.setBackground(BACKGROUND);
		newPanel.setLayout(new GridLayout(MANY_ROWS,1));
		List<TarifDts> priceList = modelBean.getPriceList();
		int i=0;
		newPanel.add(addPriceListCaption());
		for(TarifDts t: priceList){
			newPanel.add(addPriceListRow(t,(i++%2==0)));
		}
		return newPanel;
	}

	private JPanel addPriceListRow(TarifDts t, boolean isOdd) {
		Color bgColor;
		bgColor=isOdd ? Color.LIGHT_GRAY : Color.ORANGE;
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(PRICELSIT_ROWS,PRICELIST_COLS));
		panel.setBackground(bgColor);
		panel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		JLabel weightLbl = new JLabel();
		weightLbl.setText(""+t.getWeight());
		weightLbl.setBackground(WEIGHT_BG);
		JLabel priceLbl = new JLabel();
		priceLbl.setText(""+t.getPrice());
		priceLbl.setBackground(PRICE_BG);
		panel.add(weightLbl);
		panel.add(priceLbl);
		JPanel panelTmp = new JPanel();
		panelTmp.setLayout(new BorderLayout());
		panelTmp.add(panel, BorderLayout.CENTER);
		return panelTmp;
	}
	
	private JPanel addPriceListCaption() {
		Color bgColor;
		bgColor=Color.CYAN;
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(PRICELSIT_ROWS,PRICELIST_COLS));
		panel.setBackground(bgColor);
		panel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		JLabel weightLbl = new JLabel();
		weightLbl.setText("Waga");
		weightLbl.setBackground(WEIGHT_BG);
		JLabel priceLbl = new JLabel();
		priceLbl.setText("Cena");
		priceLbl.setBackground(PRICE_BG);
		panel.add(weightLbl);
		panel.add(priceLbl);
		
		JPanel panelTmp = new JPanel();
		panelTmp.setLayout(new BorderLayout());
		panelTmp.add(panel, BorderLayout.CENTER);
		return panelTmp;
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
		modelBean = new FerrymanDetailsModelBean();
		createTestData(modelBean);
		
	}

	private void createTestData(FerrymanDetailsModelBean modelBean) {
		FerrymanDts ferryman = new FerrymanDtsImpl();
		modelBean.setFerryman(ferryman);
		List<TarifDts> priceList=new ArrayList<TarifDts>();
		for(int i=0; i<15; i++){
			TarifDts t=new TarifDtsImpl();
			t.setId(i);
			t.setPrice(i*100f);
			t.setWeight(i*100);
			priceList.add(t);
		}
		modelBean.setPriceList(priceList);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
