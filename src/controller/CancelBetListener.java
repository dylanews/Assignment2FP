package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameWindow;

public class CancelBetListener implements ActionListener {

	private GameEngine gameEngine;
	private GameWindow gameWindow;

	public CancelBetListener(GameEngine gameEngine, GameWindow gameWindow) {
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;

	}

	
	// resets player bet when canceled
	@Override
	public void actionPerformed(ActionEvent e) {
		if(gameWindow.getActivePlayerAsPlayer() != null) {
			Player activePlayer = gameWindow.getActivePlayerAsPlayer();
			activePlayer.resetBet();
			gameWindow.getStatusBar().setFeedback("Bet has been cancelled");
		} else {
			throw new NullPointerException("Add a player to start");
		}
	}
}
