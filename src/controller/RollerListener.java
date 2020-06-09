package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import view.GameWindow;

public class RollerListener implements ActionListener{

	private GameEngine gameEngine;
	private GameWindow gameWindow;
	
	public RollerListener(GameEngine gameEngine, GameWindow gameWindow) {
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new Thread() {
			public void run() {
				try {
					gameEngine.rollHouse(100, 1000, 100, 50, 500, 50);
				}catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(gameWindow, "Please add Player");
				}
			}
		}.start();
	}

}
