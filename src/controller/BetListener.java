package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.GameWindow;



public class BetListener implements ActionListener{
	
	private GameEngine gameEngine;
	private GameWindow gameWindow;
	
	public BetListener(GameEngine gameEngine, GameWindow gameWindow) {
		this.gameEngine =  gameEngine;
		this.gameWindow = gameWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String betEntry = gameWindow.getToolbarPanel().getToolBar().getBetEntered();
			SimplePlayer activePlayer = gameWindow.getActivePlayerASPlayer();
			
			if(gameEngine.placeBet(activePlayer, Integer.parseInt(betEntry))) {
				gameWindow.getStatusBar().setFeedback("Bet has been placed!");
				gameWindow.getSummaryPanel().updateBetInfo(activePlayer, betEntry);
			} else {
				gameWindow.getStatusBar().setFeedback("Not enough points to place bet");
			}
			
		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(gameWindow, "Bet must be a numeric value only");
		} catch (NullPointerException exception) {
			JOptionPane.showMessageDialog(gameWindow, "Add a player to start");
		}
	}
}
