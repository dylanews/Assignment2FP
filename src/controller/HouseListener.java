package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import view.GameWindow;

public class HouseListener implements ActionListener{

	private GameEngine gameEngine;
	private GameWindow gameWindow;
	private final int INITIAL_DELAY_1 = 100;
	private final int FINAL_DELAY_1 = 1000;
	private final int DELAY_INCREMENT_1 = 100;
	private final int INITIAL_DELAY_2 = 50;
	private final int FINAL_DELAY_2 = 500;
	private final int DELAY_INCREMENT_2 = 50;

	public HouseListener(GameEngine gameEngine, GameWindow gameWindow) {
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Thread() {

			@Override
			public void run() {

				try {

					gameEngine.rollHouse(INITIAL_DELAY_1, FINAL_DELAY_1, DELAY_INCREMENT_1, INITIAL_DELAY_2,
							FINAL_DELAY_2, DELAY_INCREMENT_2);

				} catch (NullPointerException exception) {

					JOptionPane.showMessageDialog(gameWindow, "ERROR: You must have a player before you can spin");

				}
			}

		}.start();
	}

}
