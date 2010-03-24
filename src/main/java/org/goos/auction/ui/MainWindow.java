package org.goos.auction.ui;

import javax.swing.JFrame;

import org.goos.auction.Main;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;


	public MainWindow() {
		super("Auction Sniper");
		setName(Main.MAIN_WINDOW_NAME);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
