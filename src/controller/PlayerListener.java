package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import exceptions.EmptyInput;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameWindow;
import view.createPlayerPanel;

public class PlayerListener implements ActionListener {

	private GameWindow gameWindow;
	private GameEngine gameEngine;
	private Player player;
	private int playerCount = 0;
	private final int ONE = 1;
	private final String AddPlayer = "add player";
	private final String RemovePlayer = "remove playerr";

	public PlayerListener(GameEngine gameEngine, GameWindow gameWindow) {
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		JMenuItem menuItem = (JMenuItem) event.getSource();
		String menuItemChoice = menuItem.getText();
		if (menuItemChoice.equals(AddPlayer)) {
			createPlayerPanel createPlayerPanel = new createPlayerPanel();
			int selection = JOptionPane.showConfirmDialog(gameWindow, createPlayerPanel, "Add Player",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (selection == JOptionPane.OK_OPTION) {
				try {
					String playerName = createPlayerPanel.getNameField();
					String playerPointsString = createPlayerPanel.getPointsField();
					int playerPoints = Integer.parseInt(playerPointsString);
					if(playerName.isEmpty() || playerPointsString.isEmpty()) {
						throw new EmptyInput();
					}
					playerCount++;
					player = new SimplePlayer(Integer.toString(playerCount), playerName, playerPoints);

					if (playerCount == ONE) {
						gameWindow.setCurrentPlayer(player.getPlayerName());
					}
					gameEngine.addPlayer(player);
					gameWindowAddPlayer();
				} catch(EmptyInput exception) {
					JOptionPane.showMessage(gameWindow, "Fields cannot be empty");
					
				} catch (NumberFormatException exception) {
					JOptionPane.showMessage(gameWindow, "Points must contain a number value");
				}
			}
		}

		else if (menuItemChoice.equals(RemovePlayer) && playerCount > 0) {

			player = gameWindow.getActivePlayerAsPlayer();
			gameEngine.removePlayer(player);
			gameWindow.getSummaryPanel().DeletePlayer(player);
			gameWindowRemovePlayer();

		} else {
			JOptionPane.showMessageDialog(gameWindow, "There are no players to be deleted");
		}
	}
	private void gameWindowAddPlayer() {
		gameWindow.getSummaryPanel().addPlayer(player);
		gameWindow.getToolbarPanel().getToolBar().addPlayer(player);
	}

	private void gameWindowRemovePlayer() {
		gameWindow.getSummaryPanel().removePlayer();
		gameWindow.getToolbarPanel().getToolBar().removePlayer();
	}
}
