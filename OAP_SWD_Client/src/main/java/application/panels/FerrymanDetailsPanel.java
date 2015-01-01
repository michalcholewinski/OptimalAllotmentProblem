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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import main.ApplicationClient;
import oap.utils.exceptions.MyException;
import state.interfaces.State;
import state.pattern.impl.context.Context;
import application.beans.FerrymanDetailsModelBean;
import application.configuration.controllers.FerrymanDetailsConfigurationController;
import application.enumeriations.Dialogs;
import application.mode.Mode;
import application.panels.abstraction.AbstractPanel;
import facade.implementation.dts.FerrymanDtsImpl;
import facade.implementation.dts.TarifDtsImpl;
import facade.implementation.facades.FerrymanFacadeImpl;
import facade.interfaces.dts.FerrymanDts;
import facade.interfaces.dts.TarifDts;
import facade.interfaces.facades.FerrymanFacade;

public class FerrymanDetailsPanel extends
		AbstractPanel<FerrymanDetailsModelBean> {

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
	private FerrymanFacade ferrymanFacade = new FerrymanFacadeImpl();
	private FerrymanDetailsConfigurationController confController;

	public FerrymanDetailsPanel() {
		super();
		dialog = Dialogs.FERRYMAN_DETAILS;
		addBackButton();
		addSaveButton();
	}

	public void init() {
		content.removeAll();
		// retrieveData();
		buildMainPanel();
		addTarifButton();
	}

	private void addTarifButton() {
		if (addTarif == null) {
			addTarif = new JButton("Dodaj cenê");
			addTarif.addActionListener(this);
		}
		ferrymanDetails.add(addTarif);
	}

	private void addSaveButton() {
		save = new JButton("Zapisz");
		save.addActionListener(this);
		footer.add(save, BorderLayout.CENTER);
	}

	private void buildMainPanel() {
		mainContent = new JPanel();
		mainContent.setBackground(BACKGROUND);
		mainContent.setLayout(new GridLayout(ROWS, COLS));
		ferrymanDetails = new JPanel();
		ferrymanDetails.setBackground(BACKGROUND);
		ferrymanDetails.add(addLabelsAndFields());
		priceListPanel = new JPanel();

		priceListPanel.setLayout(new BorderLayout());
		priceListPanel.setBackground(BACKGROUND);
		priceListPanel.add(addPriceList(), BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(priceListPanel);
		scrollPane.setPreferredSize(new Dimension(
				(ApplicationClient.WINDOW_SIZE_X / 2) - 10,
				ApplicationClient.WINDOW_SIZE_Y - 120));
		mainContent.add(ferrymanDetails);
		mainContent.add(scrollPane);
		content.add(mainContent);
	}

	private JPanel addPriceList() {
		JPanel newPanel = new JPanel();
		newPanel.setBackground(BACKGROUND);
		newPanel.setLayout(new GridLayout(MANY_ROWS, 1));
		List<TarifDts> priceList = modelBean.getPriceList();
		int i = 0;
		newPanel.add(addPriceListCaption());
		for (TarifDts t : priceList) {
			newPanel.add(addPriceListRow(t, (i++ % 2 == 0)));
		}
		return newPanel;
	}

	private JPanel addPriceListRow(TarifDts t, boolean isOdd) {
		Color bgColor;
		bgColor = isOdd ? Color.LIGHT_GRAY : Color.ORANGE;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(PRICELSIT_ROWS, PRICELIST_COLS));
		panel.setBackground(bgColor);
		panel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		JLabel weightLbl = new JLabel();
		weightLbl.setText("" + t.getWeight());
		weightLbl.setBackground(WEIGHT_BG);
		JLabel priceLbl = new JLabel();
		priceLbl.setText("" + t.getPrice());
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
		bgColor = Color.CYAN;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(PRICELSIT_ROWS, PRICELIST_COLS));
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
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEtchedBorder(Color.RED,
				Color.YELLOW));
		panel.setLayout(new GridLayout(3, 1, 10, 10));
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new GridLayout(1, 2));
		nameLabel = new JLabel();
		nameLabel.setText("Nazwa: ");
		name = new JTextField();
		namePanel.add(nameLabel, BorderLayout.WEST);
		namePanel.add(name, BorderLayout.EAST);
		maxWeightLabel = new JLabel();
		maxWeightLabel.setText("Maksymalna waga: ");
		priceListSizeLabel = new JLabel();
		priceListSizeLabel.setText("Iloœæ cenników: ");
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
	public void retrieveData() {
		confController = FerrymansManagementPanel.detailsControllerConfiguration;
		modelBean = new FerrymanDetailsModelBean();
		// TODO should be deleted createTestData(modelBean);
		if (confController.getMode() == Mode.UPDATE) {
			long ferrymanId = confController.getFerryman().getId();
			try {
				modelBean.setFerryman(ferrymanFacade
						.getFerrymanById(ferrymanId));
			} catch (MyException e1) {
				// TODO exception should be handled

				return;
			}

			try {
				modelBean.setPriceList(ferrymanFacade
						.getPriceListByFerrymanId(ferrymanId));

			} catch (MyException e) {
				// TODO exception should be handled

				return;
			}

		} else {
			modelBean.setFerryman(new FerrymanDtsImpl());
			modelBean.setPriceList(new ArrayList<TarifDts>());
		}
		init();
		name.setText(modelBean.getFerryman().getName());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		Object source = e.getSource();
		Mode mode = confController.getMode();

		if (source.equals(addTarif)) {
			String message="Podaj cenê dla wagi <<WAGA>>";
			String price = JOptionPane.showInputDialog(message);
			//TODO find last weight in priceList, add next 
		
		} else if (source.equals(save)) {
			if (validate()) {
				updateModelBean();
				if (mode == Mode.CREATE) {
					try {
						ferrymanFacade.createFerryman(modelBean.getFerryman());
						for (TarifDts t : modelBean.getPriceList()) {
							long ferrymanId = modelBean.getFerryman().getId();
							ferrymanFacade.addNewTarifToFerrymanWithGivenId(
									ferrymanId, t);
						}
					} catch (MyException e1) {
						// TODO exception should be handled
						System.out.println("Exception1");
					}

				} else {
					try {
						ferrymanFacade.updateFerryman(modelBean.getFerryman());
					} catch (MyException e1) {
						// TODO exception should be handled
						System.out.println("Exception2");
					}
				}

				Dialogs ferrymanDialogName = Dialogs.FERRYMANS_MANAGEMENT;
				State state = ApplicationClient.states
						.stream()
						.filter(item -> item.getDialogsName() == ferrymanDialogName)
						.findFirst().get();

				((FerrymansManagementPanel) state).init();
				switchPanel(ferrymanDialogName);
			}
		}

	}

	private void updateModelBean() {
		FerrymanDts ferryman = modelBean.getFerryman();
		ferryman.setName(name.getText());
	}

	/**
	 * 
	 * @return true if every field's value is valid
	 */
	private boolean validate() {
		// TODO implement it
		return true;
	}

}
