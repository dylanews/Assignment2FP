package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.interfaces.GameEngine;
import view.MainFrame;

public class CurrentPlayerListener implements ActionListener{
	
	@SuppressWarnings("unused")
	private GameEngine gameEngine;
	private MainFrame mainFrame;	
	
	public CurrentPlayerListener(GameEngine gameEngine, MainFrame mainFrame) {
		
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
		
	}
	
	public void actionPerformed(ActionEvent event){
		
		setCurrentPlayer(event);
		updateStatusBar();
		updateCoinPanel();

	}
	
	public void updateCoinPanel() {
		
		if(mainFrame.getCurrentPlayer() != null) {
			
			mainFrame.getDicePanel().changePlayer();
			
		}
		
	}
	
	public void setCurrentPlayer(ActionEvent event) {
		
		JComboBox<String> comboBox = (JComboBox<String>) event.getSource();
		String comboBoxSelection = (String) comboBox.getSelectedItem();
		mainFrame.setCurrentPlayer(comboBoxSelection);
		
	}
	
	public void updateStatusBar() {
		
		if(mainFrame.getCurrentPlayer() == null) {
			
			mainFrame.getStatusBar().setDefaultCurrentPlayer();
			
		} else {
			
			mainFrame.getStatusBar().setCurrentPlayer(mainFrame.getCurrentPlayer());
			
		}
		
		
	}


}
