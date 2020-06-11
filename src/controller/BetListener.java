package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameWindow;

public class BetListener implements ActionListener{

	private GameEngine gameEngine;
	private GameWindow gameWindow;

	public BetListener(GameEngine gameEngine, GameWindow gameWindow) {
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;

	}
	
	// Validation on bet input
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		try {
			String betEntered = gameWindow.getMenuAndToolPanel().getToolBar().getEntryBet();
			Player activePlayer = gameWindow.getActivePlayerAsPlayer();


			if (gameEngine.placeBet(activePlayer, Integer.parseInt(betEntered) )) {
				gameWindow.getStatusBar().setFeedback("Bet has been placed!");
				gameWindow.getSummaryPanel().updateBetInfo(activePlayer, betEntered);
			} else {
				gameWindow.getStatusBar().setFeedback("Not Enough points to place bet!");
			}

		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(gameWindow, "Bet must be a numeric value only");
		} catch (NullPointerException exception) {
			JOptionPane.showMessageDialog(gameWindow, "Add a player to start");
		}

	}
}
