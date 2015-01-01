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
import oap.utils.exceptions.MyException;
import state.interfaces.State;
import state.pattern.impl.context.Context;
import application.beans.FerrymansManagementModelBean;
import application.binding.button.dts.PairDetailsButtonFerrymanDts;
import application.configuration.controllers.FerrymanDetailsConfigurationController;
import application.enumeriations.Dialogs;
import application.mode.Mode;
import application.panels.abstraction.AbstractPanel;
import facade.implementation.dts.FerrymanDtsImpl;
import facade.implementation.facades.FerrymanFacadeImpl;
import facade.interfaces.dts.FerrymanDts;
import facade.interfaces.facades.FerrymanFacade;

public class FerrymansManagementPanel extends
		AbstractPanel<FerrymansManagementModelBean> {
	private static final int SPACING = 5;
	private JPanel contentPanel;
	private JScrollPane ferrymansList;
	private JPanel ferrymansListPanel;
	private JButton newFerryman;
	private List<PairDetailsButtonFerrymanDts> detailsButtonDtsPairList;
	private List<PairDetailsButtonFerrymanDts> deleteButtonDtsPairList;
	private FerrymanFacade ferrymanFacade;
	static FerrymanDetailsConfigurationController detailsControllerConfiguration;

	public FerrymansManagementPanel() {
		super();
		dialog = Dialogs.FERRYMANS_MANAGEMENT;
		ferrymanFacade = new FerrymanFacadeImpl();
		init();
		addBackButton();
		addNewFerrymanButton();

	}

	public void init() {
		detailsButtonDtsPairList = new ArrayList<PairDetailsButtonFerrymanDts>();
		deleteButtonDtsPairList = new ArrayList<PairDetailsButtonFerrymanDts>();
		retrieveData();
		content.removeAll();
		buildContentPanel();
	}

	private void addNewFerrymanButton() {
		newFerryman = new JButton("Dodaj przewoünika");
		newFerryman.addActionListener(this);
		footer.add(newFerryman, BorderLayout.CENTER);
	}

	private void buildContentPanel() {
		contentPanel = new JPanel();
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBackground(BACKGROUND);
		ferrymansListPanel = new JPanel();
		ferrymansListPanel.setBackground(BACKGROUND);
		ferrymansListPanel.setLayout(new GridLayout(modelBean
				.getNumberOfFerrymans(), 1, SPACING, SPACING));
		ferrymansList = new JScrollPane(ferrymansListPanel);
		ferrymansList.setPreferredSize(new Dimension(
				ApplicationClient.WINDOW_SIZE_X - 50,
				ApplicationClient.WINDOW_SIZE_Y - 120));
		ferrymansList.setBackground(BACKGROUND);
		contentPanel.add(ferrymansList);
		content.add(contentPanel);
		createFerrymanList();
	}

	private List<FerrymanDts> createTestFerrymanList() {
		// TODO to remove, only for tests
		List<FerrymanDts> f = new ArrayList<FerrymanDts>();
		for (int i = 0; i < 20; i++) {
			FerrymanDts ff = new FerrymanDtsImpl();
			ff.setMaxWeight(1000);
			ff.setName("Ferryman nr " + i);
			ff.setPriceListSize(10);
			f.add(ff);
		}
		return f;
	}

	private void createFerrymanList() {
		int i = 0;
		for (FerrymanDts f : modelBean.getFerrymans()) {
			prepareRow(f, !(i++ % 2 == 0));

		}

	}

	private void prepareRow(FerrymanDts ferryman, boolean isOdd) {
		JButton details = new JButton("SzczegÛ≥y");
		JButton delete = new JButton("UsuÒ");
		registerDeleteButton(delete, ferryman);
		registerDetailsButton(details, ferryman);
		Color bgColor;
		JLabel label = new JLabel();
		label.setText("Nazwa: " + ferryman.getName() + " Maksymalna waga: "
				+ ferryman.getMaxWeight());
		bgColor = isOdd ? Color.yellow : Color.gray;
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
	public void retrieveData() {
		modelBean = new FerrymansManagementModelBean();
		// TODO should be deleted
		// modelBean.setFerrymans(createTestFerrymanList()); // only for testing

		modelBean.setFerrymans(ferrymanFacade.getFerrymans());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		Object source = e.getSource();
		FerrymanDts ferryman=null;
		Dialogs nextDialog = Dialogs.FERRYMANS_MANAGEMENT;
		if (source.equals(newFerryman)) {
			showDetailsForNewFerryman();
			return;
		}

		for (PairDetailsButtonFerrymanDts p : deleteButtonDtsPairList) {
			if (source.equals(p.getButton())) {
				try {
					ferrymanFacade.deleteFerryman(p.getFerryman());
					nextDialog = Dialogs.FERRYMANS_MANAGEMENT;
					switchPanel(Dialogs.MAIN_PANEL);
					init();
					switchPanel(nextDialog);
					break;
				} catch (MyException e1) {
					// TODO should be validated
					System.out.println("Nie usunalem");
				}
			}
		}

		for (PairDetailsButtonFerrymanDts p : detailsButtonDtsPairList) {
			if (source.equals(p.getButton())) {
				nextDialog = Dialogs.FERRYMAN_DETAILS;
				ferryman=p.getFerryman();
				showDetailsFor(ferryman);
				break;
			}
		}
	}

	private void showDetailsForNewFerryman() {
		detailsControllerConfiguration = new FerrymanDetailsConfigurationController(
				new FerrymanDtsImpl(), Mode.CREATE);
		String dialogName = Dialogs.FERRYMAN_DETAILS.getName();
		State detailsPanel = getState(dialogName);
		((FerrymanDetailsPanel) detailsPanel).retrieveData();
		ApplicationClient.cards.show(getPanel().getParent(), dialogName);

	}

	private State getState(String dialogName) {
		State state = ApplicationClient.states
				.stream()
				.filter(item -> item.getDialogsName().getName()
						.equals(dialogName)).findFirst().get();
		return state;
	}

	private void showDetailsFor(FerrymanDts ferryman) {
		detailsControllerConfiguration = new FerrymanDetailsConfigurationController(
				ferryman, Mode.UPDATE);
		String dialogName = Dialogs.FERRYMAN_DETAILS.getName();
		State detailsPanel = getState(dialogName);

		((FerrymanDetailsPanel) detailsPanel).retrieveData();
		ApplicationClient.cards.show(getPanel().getParent(), dialogName);

	}

	private void registerDetailsButton(JButton button, FerrymanDts ferryman) {
		button.addActionListener(this);
		detailsButtonDtsPairList.add(new PairDetailsButtonFerrymanDts(button,
				ferryman));

	}

	private void registerDeleteButton(JButton button, FerrymanDts ferryman) {
		button.addActionListener(this);
		deleteButtonDtsPairList.add(new PairDetailsButtonFerrymanDts(button,
				ferryman));

	}

}
