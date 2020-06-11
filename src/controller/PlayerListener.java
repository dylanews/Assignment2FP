package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import exception.EmptyInput;
import model.DicePairImpl;
import model.DieImpl;
import model.SimplePlayer;
import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameWindow;
import view.component.PlayerDialog;

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
	public void actionPerformed(ActionEvent e) {
		JMenuItem menuItem = (JMenuItem) e.getSource();
		String menuItemChoice = menuItem.getText();
		
		// Add new player with Name, Points and set player to active player
		if(menuItemChoice.equals(ADD_PLAYER)) {
			PlayerDialog playerDialog = new PlayerDialog();
			
			int selection = JOptionPane.showConfirmDialog(gameWindow, playerDialog, "Add Player", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			
			if(selection == JOptionPane.OK_OPTION) {
				try {
					String playerNameString = playerDialog.getPlayerNameField();
					String playerPointsString = playerDialog.getPlayerPointsField();
					int playerPointsInteger = Integer.parseInt(playerPointsString);
					
					if(playerNameString.isEmpty() || playerPointsString.isEmpty()) {
						
						throw new EmptyInput();
					}
					
					playerCount++;
					player = new SimplePlayer(Integer.toString(playerCount), playerNameString, playerPointsInteger);
					
					Random r = new Random();	
					Die playerDie1 = new DieImpl(1, r.nextInt((6 - 1) + 1) + 1, 6);
					Die playerDie2 = new DieImpl(2, r.nextInt((6 - 1) + 1) + 1, 6);
					DicePair playerDicePair = new DicePairImpl(playerDie1, playerDie2);
					player.setResult(playerDicePair);
					
					System.out.println(player.getPlayerName());
					
					if (playerCount <= 1) {
						gameWindow.setActivePlayer(player.getPlayerName());
						gameWindow.setActivePlayerID(player.getPlayerId());
					}
					
					
					gameEngine.addPlayer(player);
					gameWindowAddPlayer();
					
					
				}catch(EmptyInput exception)
				{
					JOptionPane.showMessageDialog(gameWindow, "Fields cannot be empty");
				}catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(gameWindow, "Points must be in numeric value");
				}
			}
		}
		
		// remove player choice
		else if(menuItemChoice.equals(REMOVE_PLAYER) && playerCount > 0) {
			
			player = gameWindow.getActivePlayerAsPlayer();
			gameEngine.removePlayer(player);
			gameWindow.getSummaryPanel().DeletePlayer(player);
			gameWindowRemovePlayer();
		
		
		}
		}
				
				private void gameWindowAddPlayer(){
					
					gameWindow.getSummaryPanel().addPlayer(player);
					gameWindow.getMenuAndToolPanel().getToolBar().addPlayer(player);
					
				}
				
				private void gameWindowRemovePlayer() {
					
					gameWindow.getSummaryPanel().removePlayer();
					gameWindow.getMenuAndToolPanel().getToolBar().addPlayer(player);
					
				}
			
		}	
	