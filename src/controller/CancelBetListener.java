package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

public class CancelBetListener implements ActionListener {

		private GameEngine gameEngine;
		private MainFrame mainFrame;

		public CancelBetListener(GameEngine gameEngine, MainFrame mainFrame) {
			this.gameEngine = gameEngine;
			this.mainFrame = mainFrame;

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			try {

				String betPlaced = mainFrame.getMenuAndToolBarPanel().getToolBar().getBetEntered();
				String betType = mainFrame.getMenuAndToolBarPanel().getToolBar().getBetType();
				Player currentPlayer = mainFrame.getCurrentPlayerAsPlayer();

				if (gameEngine.placeBet(currentPlayer, Integer.parseInt(betPlaced), parseBetType(betType))) {
					mainFrame.getStatusBar().setFeedback("Bet Placed!");
					
					mainFrame.getSummaryPanel().updateBetInfo(currentPlayer, betPlaced, betType);
				} else {
					mainFrame.getStatusBar().setFeedback("error: not enough amount to bet");
				}
			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(mainFrame, "error: bet must be in numbers");
			} catch (NullPointerException exception) {
				JOptionPane.showMessageDialog(mainFrame, "error : add player to start rolling");
			}

		}

		private BetType parseBetType(String betType) {
			if (betType.equals("Dice 1")) {
				return BetType.COIN1;
			}

			else if (betType.equals("Dice 2")) {
				return BetType.COIN2;
			}

			else if (betType.equals("Both Dice")) {
				return BetType.BOTH;
			}

			else {
				return BetType.NO_BET;
			}

		}

	}

	
