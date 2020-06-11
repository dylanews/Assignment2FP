package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.interfaces.GameEngine;
import view.GameWindow;

public class ActivePlayerListener implements ActionListener{

	private GameEngine gameEngine;
	private GameWindow gameWindow;

	public ActivePlayerListener(GameEngine gameEngine, GameWindow gameWindow) {
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setActivePlayer(e);
		updateStatusBar();
		updateDicePanel();
		
	}
	
	// update dice panel when change player
	private void updateDicePanel() {
		
		if(gameWindow.getActivePlayer() != (null)) {
			gameWindow.getDicePanel().changePlayer();
		}
		
	}
	
	// set player to active player from list
	private void setActivePlayer(ActionEvent event) {
		JComboBox<String> comboBox = (JComboBox<String>) event.getSource();
		String comboBoxSelection = (String) comboBox.getSelectedItem();
		gameWindow.setActivePlayer(comboBoxSelection);
	}
	
	// update status bar
	private void updateStatusBar() {
		if(gameWindow.getActivePlayer() == (null)) {
			gameWindow.getStatusBar().setDefaultActivePlayer();
		} else {
			gameWindow.getStatusBar().setActivePlayer(gameWindow.getActivePlayer());
		}
		
	}
	

}
