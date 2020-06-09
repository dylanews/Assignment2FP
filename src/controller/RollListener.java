package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import exception.NoBet;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.GameWindow;

public class RollListener implements ActionListener{

	private GameEngine gameEngine;
	private GameWindow gameWindow;
	
	public RollListener(GameEngine gameEngine, GameWindow gameWindow){
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			if(checkNoBet()) {
				new Thread() {
					public void run() {
						try {
							gameEngine.rollPlayer(gameWindow.getActivePlayerAsPlayer(), 100, 1000,
									100, 50, 500, 50);
						} catch (NullPointerException exception) {
							JOptionPane.showMessageDialog(gameWindow, "No Player to Spin");
						}
						}
					}.start();
				} else {
					throw new NoBet();
				}
		} catch(NoBet exception) {
			JOptionPane.showMessageDialog(gameWindow, "Please place a bet");
		}
	}

	private boolean checkNoBet() {
		SimplePlayer activePlayer = gameWindow.getActivePlayerAsPlayer();
		if (activePlayer.getBet() == 0) {
			return false;
		}else {
			return true;
		}
	}

}
