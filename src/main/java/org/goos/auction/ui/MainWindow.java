package org.goos.auction.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import org.goos.auction.Main;

public class MainWindow extends JFrame {

	public static final String STATUS_JOINING = "Joining";
	public static final String SNIPER_STATUS_NAME = "sniper status";
	private final JLabel sniperStatus = createLabel(STATUS_JOINING);

	private static final long serialVersionUID = 1L;

	public MainWindow() {
		super("Auction Sniper");
		setName(Main.MAIN_WINDOW_NAME);
		add(sniperStatus);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private static JLabel createLabel(String initialText) {
		JLabel result = new JLabel(initialText);
		result.setName(SNIPER_STATUS_NAME);
		result.setBorder(new LineBorder(Color.BLACK));
		return result;
	}
}
