package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationClient implements Runnable {

	private void init() {
		JFrame frame = new JFrame("Optimal Allotment Problem");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);

		frame.setVisible(true);
	}

	@Override
	public void run() {
		init();
	}

	public static void main(String[] args) {
		Thread t = new Thread(new ApplicationClient());
		t.run();
	}

}
