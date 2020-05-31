package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineWindow;

public class Bet implements ActionListener {
	private GameEngine gameEngine;
	private GameEngineWindow gameEngineWindow;
	
	public Bet(GameEngine gameEngine, GameEngineWindow gameEngineWindow) {
		this.gameEngine = gameEngine;
		this.gameEngineWindow = gameEngineWindow;
	}
	public void actionPerformed(ActionEvent e) {
		try {
			String betAmount = gameEngineWindow.getMenuPanel().getToolBar().getBetType();
			String betType = gameEngineWindow.getMenuPanel().getToolBar().getBetEntered();
			Player currentPlayer = gameEngineWindow.getCurrentPlayerAsPlayer();
			if (gameEngineWindow.placeBet(currentPlayer, Integer.parseInt(betAmount), getBetType(betType))) {
				gameEngineWindow.getStatusBar().setComments("THE AMOUNT OF BET HAS BEEN ENTERED");
			}else {
				gameEngineWindow.getStatusBar().setComments("insufficient amount to place bet");
			}
		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(gameEngineWindow,  "bet must be in numbers");
		} catch (NullPointerException exception)
		{
			JOptionPane.showMessageDialog(gameEngineWindow,  "please add a player to start the betting");}
		}
	private BetType getBetType(String betType) {
		if (betType.contentEquals("dice 1:")) {
			return BetType.DICE1;
		} else if (betType.equals("DICE 2:")) {
			return BetType.DICE2;
		}
		else if (betType.contentEquals("BOTH dice:")) {
			return betType.BOTH;
		}
		else {
			return BetType.NO_BET;
		}
	}
}