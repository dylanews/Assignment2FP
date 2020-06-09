package view.component;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.ActivePlayerListener;
import controller.BetListener;
import controller.CancelBetListener;
import controller.RollListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameWindow;

@SuppressWarnings("serial")
public class Toolbar extends JToolBar {
		
		private GameEngine gameEngine;
		private GameWindow gameWindow;
	
		private JButton rollButton;
		private JComboBox<String> playerComboBox;
		private JTextField bet;
		private JButton betConfirm;
		private JButton betCancel;
		
		private final String ENT_BET_STRING = "Please enter the amount you would like to bet";
		
		public Toolbar(GameEngine gameEngine, GameWindow gameWindow) {
						
			super("Toolbar");
			
			this.gameEngine = gameEngine;
			this.gameWindow = gameWindow;
			
			setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
			
			rollButton = new JButton("ROLL");
			playerComboBox = new JComboBox<String>();
			
			bet = new JTextField(ENT_BET_STRING);
			betConfirm = new JButton("PLACE BET");
			betCancel = new JButton("CANCEL BET");
			
			playerComboBox.setPreferredSize(new Dimension(200,0));
			bet.setPreferredSize(new Dimension(200, 0));
			
			add(rollButton);
			add(playerComboBox);
			add(bet);
			add(betConfirm);
			add(betCancel);
			
			bet.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {
					if(bet.getText().equals(ENT_BET_STRING)) {
						bet.setText("");
						}
				};
			});
			
			rollButton.addActionListener(new RollListener(gameEngine, gameWindow));
			playerComboBox.addActionListener(new ActivePlayerListener(gameEngine, gameWindow));
			betConfirm.addActionListener(new BetListener(gameEngine, gameWindow));
			betCancel.addActionListener(new CancelBetListener(gameEngine, gameWindow));
		}

		public void addPlayer(Player player) {
			playerComboBox.addItem(player.getPlayerId() +":"+ player.getPlayerName());
			updateUI();
			
		}

		public void removePlayer() {
			playerComboBox.removeAllItems();
			Collection<Player> allPlayers = gameEngine.getAllPlayers();
			for (Player player : allPlayers) {
				playerComboBox.addItem(player.getPlayerId() +":"+ player.getPlayerName());
			}
			updateUI();
		}
		
		public String getBetEntered() {
			String betEntered = bet.getText();
			return betEntered;
		}

		public Component getSpinButton() {
			return rollButton;
		}
		
		public Component getPlayerComboBox() {
			return playerComboBox;
		}


	}
