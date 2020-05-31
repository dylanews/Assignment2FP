package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import view.GameEngineWindow;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class RemoveBet implements ActionListener {
	private GameEngine gameEngine;
	private GameEngineWindow gameEngineWindow;
	
	public RemoveBet(GameEngine gameEngine, GameEngineWindow gameEngineWindow) {
		this.gameEngineWindow = gameEngineWindow;
		this.gameEngine = gameEngine;
	}
	
	//incomplete without actions
}