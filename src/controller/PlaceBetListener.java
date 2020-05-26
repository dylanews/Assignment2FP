package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import viewGUI.MainFrame;

public class PlaceBetListener implements ActionListener {
	
	private GameEngine gameEngine;
	private Mainframe mainFrame;
	
	public PlaceBetListener(GameEngine gameEngine, MainFrame mainFrame) {
		
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			
			String betAmount = mainFrame.getMenuAndToolPanel().getToolBar().getBetEntered();
			String betType = mainFrame.getMenuAndToolPanel().getToolBar().getBetType();
			Player currentPlayer = mainFrame.getCurrentPlayerAsPlayer();
			
			if(gameEngine.placeBet(currentPlayer,  Integer.parseInt(betAmount), parseBetType(betType))) {
				mainFrame.getStatusBar().setFeedback("bet placed");
				
				mainFrame.getSummaryPanel().updateBetInfo(currentPlayer, betAmount, betType);
			} else { 
				mainFrame.getStatusBar().setFeedback("error: not enough bets");
			}
			
			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(mainFrame, "error: bet place must be in numbers");
			} catch (NullPointerException exception) {
				JOptionPane.showMessageDialog(mainFrame, "error: need player to start");
			}
	}
	
	private BetType parseBetType(String betType) {
		if (betType.contentEquals("Coin 1")) {
			return BetType.COIN1;
		}
		else if (betType.contentEquals("Coin 2")) {
			return BetType.COIN2;
		}
		else if (betType.equals("Both Coins")) {
			return BetType.BOTH;
		}
		else {
			return BetType.NO_BET;
		}
	}