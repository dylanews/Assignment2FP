package view.component;

import java.awt.*;
import java.awt.event.*;
import java.util.Collection;

import javax.swing.*;

import controller.ActivePlayerListener;
import controller.BetListener;
import controller.CancelBetListener;
import controller.RollPlayerListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameWindow;

public class ToolBar extends JToolBar{
	
	private GameEngine gameEngine;
	private GameWindow	gameWindow;
	
	private JButton rollButton;
	private JComboBox<String> playerComboBox;
	private JTextField entryBet;
	private JButton placeBet;
	private JButton cancelBet;
	
	private final String BET_AMT_STRING = "Enter bet amount";
	
	public ToolBar(GameEngine gameEngine, GameWindow gameWindow) {
		super("ToolBar");
		
		// Referencing to GameEngine and GameWindow Class
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;
		
		// Set layout for JToolBar
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		// Player selection and roll button
		rollButton = new JButton("Roll Player");
		playerComboBox = new JComboBox<String>();
		
		// bet choices
		entryBet = new JTextField(BET_AMT_STRING);
		placeBet = new JButton("Place Bet");
		cancelBet = new JButton("Cancel Bet");
		
		playerComboBox.setPreferredSize(new Dimension(200, 0));
		entryBet.setPreferredSize(new Dimension(200, 0));
		
		// add toolbar components
		add(rollButton);
		add(playerComboBox);
		add(entryBet);
		add(placeBet);
		add(cancelBet);
		
		entryBet.addMouseListener(new MouseAdapter(){
			@Override 
			public void mouseClicked(MouseEvent e) {
				if(entryBet.getText().equals(BET_AMT_STRING)) {
					entryBet.setText("");
				}
			}
			
			
		});
		
		// adding action listener
		rollButton.addActionListener(new RollPlayerListener(gameEngine, gameWindow));
		playerComboBox.addActionListener(new ActivePlayerListener(gameEngine, gameWindow));
		placeBet.addActionListener(new BetListener(gameEngine, gameWindow));
		cancelBet.addActionListener(new CancelBetListener(gameEngine, gameWindow));
		
	}
	
	// Add player method
	public void addPlayer(Player player) {
		playerComboBox.addItem(player.getPlayerId()+" + "+player.getPlayerName());
		updateUI();
	}
	
	// Remove player method
	public void removePlayer() {
		playerComboBox.removeAllItems();
		Collection<Player> allPlayers = gameEngine.getAllPlayers();
		for (Player player : allPlayers) {
			playerComboBox.addItem(player.getPlayerId() +" : "+ player.getPlayerName());
		}
		updateUI();
	}
	
	// Getter for Entry Bet
	public String getEntryBet() {
		String benteredBet = entryBet.getText();
		return benteredBet;
	}
	
	// Getter for Roll Button
	public Component getRollButton() {
		return rollButton;
	}
	
	// Getter for Player Combo Box
	public Component getPlayerComboBox() {
		return playerComboBox;
	}
	
	

}
