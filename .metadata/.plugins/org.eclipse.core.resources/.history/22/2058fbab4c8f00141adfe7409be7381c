package application.panels.abstraction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import state.pattern.impl.context.Context;
import state.pattern.interfaces.State;

public abstract class AbstractPanel<T> implements State {
	private static final int _FONT_SIZE = 16;
	protected Context context;
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

	public AbstractPanel() {
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

	protected abstract void retrieveData();

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
		footer.add(back, BorderLayout.WEST);

	}

	private void createFooter() {
		footer = new JPanel();
		footer.setBackground(BACKGROUND);
		footer.setLayout(new BorderLayout());
		exit = new JButton("WYJSCIE");
		footer.add(exit, BorderLayout.EAST);

	}

	public JPanel getPanel() {
		return panel;
	}

}
