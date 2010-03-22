package org.goos.auction;

import javax.swing.SwingUtilities;

public class Main {

	public static final String MAIN_WINDOW_NAME = "bubbles";
	public static final String SNIPER_STATUS_NAME = "sniper-name";
	private MainWindow ui;

	public Main() throws Exception {
		startUserInterface();
	}

	public static void main(String... args) throws Exception {
		Main main = new Main();
	}

	private void startUserInterface() throws Exception {
		SwingUtilities.invokeAndWait(new Runnable() {
			public void run() {
				ui = new MainWindow();
			}
		});
	}
}
