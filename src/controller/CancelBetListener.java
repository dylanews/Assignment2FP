package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.GameWindow;

public class CancelBetListener implements ActionListener{

	private GameEngine gameEngine;
	private GameWindow gameWindow;
	
	public CancelBetListener(GameEngine gameEngine, GameWindow gameWindow) {	
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(gameWindow.getActivePlayerAsPlayer()) {
			SimplePlayer activePlayer = gameWindow.getActivePlayerAsPlayer();
			activePlayer.resetBet();
			gameWindow.getStatusBar().setComments("B.getSummaryPanel().updateBetCancel(activePlaet has been cancelled");
		} else {
			throw new NullPointerException("Add a player to start");
		}
	}
}
