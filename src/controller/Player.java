package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import exceptions.EmptyInput;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineWindow;
import view.CreatePlayer;

public class Player implements ActionListener {
	private GameEngineWindow gameEngineWindow;
	private GameEngine gameEngine;
	private Player player;
	private int playerCount = 0;
	private final String addPlayer = "ADDING A PLAYER";
	private final String deletePlayer = "REMOVING A PLAYER";
	
	public Player(GameEngineWindow gameEngineWindow, GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		this.gameEngineWindow = gameEngineWindow;
	}
	//can change to switch cases for menuItemChoice
	public void actionPerformed(ActionEvent event) {
		JMenuItem menuItem = (JMenuItem) event.getSource();
		String menuItemChoice = menuItem.getText();
		if(menuItemChoice==(addPlayer)) {
			CreatePlayer createPlayer = new CreatePlayer();
			int ChosenNumber = JOptionPane.showConfirmDialog(gameEngineWindow,createPlayer, "ADDING PLAYER", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(ChosenNumber == JOptionPane.OK_OPTION) {
				try {
					String playerName = createPlayer.getPlayerNameTxtFld();
					String playerPoints = createPlayer.getPlayerPointsField();
					int playeRPoints = Integer.getInteger(playerPoints);
					if(playerName.isEmpty() || playerPoints.isEmpty()) {
						throw new EmptyInput();
					}
					playerCount++;
					player = new SimplePlayer(Integer.toString(playerCount), playerName,playerPoints);
					if(playerCount > 0) {
						gameEngineWindow.setCurrentPlayer(player.getPlayerName());
			}
					gameEngine.addPlayer(player);
					gameEngineWindowAddPlayer();
				} catch(EmptyInput exception) {
					JOptionPane.showMessageDialog(gameEngineWindow, "PLEASE FILL UP FIELDS");
				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(gameEngineWindow, "POINTS MUST BE IN NUMBERS");
				}
				
			}
		} else if(menuItemChoice == (deletePlayer) && playerCount > 0) {
			player.gameEngineWindow.getCurrentPlayerAsPlayer();
			gameEngine.deletePlayer(player);
			gameEngineWindow.getSummaryPanel().deletePlayer(player);
			gameEngineWindowdeletePlayer();
		} else {
			JOptionPane.showMessageDialog(gameEngineWindow, "NO PLAYERS");
		}
		//incomplete
	}
	private void gameEngineWindowAddPlayer() {
		gameEngineWindow.getSummaryPanel().addPlayer(player);
		
	}
	