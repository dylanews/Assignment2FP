package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import exception.EmptyInput;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.CreatePlayer;
import view.GameWindow;

public class PlayerListener implements ActionListener{
	
	private GameEngine gameEngine;
	private GameWindow gameWindow;
	private Player player;
	private int playerCount = 0;
	private final String ADD_PLAYER = "Add Player";
	private final String REMOVE_PLAYER = "Remove Player";
	
	public PlayerListener(GameEngine gameEngine, GameWindow gameWindow) {
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JMenuItem menuItem = (JMenuItem) event.getSource();
		String menuItemChoice = menuItem.getText();

		if (menuItemChoice.equals(ADD_PLAYER)) {
			CreatePlayer createPlayerDialog = new CreatePlayer();

			int selection = JOptionPane.showConfirmDialog(gameWindow, createPlayerDialog, "Add Player",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

			if (selection == JOptionPane.OK_OPTION) {

				try {
					
					String playerName = createPlayerDialog.getPlayerNameText();
					String playerPointsString = createPlayerDialog.getPlayerPointsText();
					int playerPoints = Integer.parseInt(playerPointsString);
					if(playerName.isEmpty() || playerPointsString.isEmpty()) {
						throw new EmptyInput();
					}

					playerCount++;
					player = new SimplePlayer(Integer.toString(playerCount), playerName, playerPoints);

					if (playerCount == 0) {
						gameWindow.setActivePlayer(player.getPlayerName());
					}
					
					gameEngine.addPlayer(player);
					gameWindowAddPlayer();
				} catch(EmptyInput exception) {
					JOptionPane.showMessageDialog(gameWindow, "Fields cannot be empty");
					
				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(gameWindow, "Points must have a number value");
				}

			}

			
		}

		else if (menuItemChoice.equals(REMOVE_PLAYER) && playerCount > 0) {

			player = gameWindow.getActivePlayerAsPlayer();
			gameEngine.removePlayer(player);
			gameWindow.getSummaryPanel().deletePlayer();
			gameWindowRemovePlayer();

		} else {
			JOptionPane.showMessageDialog(gameWindow, "There are no players to be removed");
		}

	}

	private void gameWindowAddPlayer() {
		gameWindow.getSummaryPanel().playerAdd(player);
		gameWindow.getMenuPanel().getToolBar().addPlayer(player);
	}

	private void gameWindowRemovePlayer() {
		gameWindow.getSummaryPanel().removeAll();
		gameWindow.getMenuPanel().getToolBar().removePlayer();
	}
}
