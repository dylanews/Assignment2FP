package view.BarsAndPanels;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import model.interfaces.GameEngine;

public class ToolBar extends JToolBar {
		
		private GameEngineWindow gameEngineWindow;
		private GameEngine gameEngine;
		private JButton rollButton;
		private JComboBox<String> playerComboBox;
		private JTextField bet;
		private JComboBox<String> betTypeComboBox;
		private JButton betConfirm;
		private JButton betCancel;
		
		private final String ENT_BET_STRING = "Please enter the amount you would like to bet";
		
		public ToolBar(GameEngineWindow gameEngineWindow, GameEngine gameEngine) {
			
			super("ToolBar");
			
			this.gameEngineWindow = gameEngineWindow;
			this.gameEngine = gameEngine;
			
			setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
			
			rollButton = new JButton("ROLL");
			playerComboBox = new JComboBox<String>();
			
			String[] betTypes = {"Dice 1", "Dice 2", "Both"};
			
			bet = new JTextField(ENT_BET_STRING);
			betTypeComboBox = new JComboBox<String>(betTypes);
			betConfirm = new JButton("PLACE BET");
			betCancel = new JButton("CANCEL BET");
			
			playerComboBox.setPreferredSize(new Dimension(200,0));
			bet.setPreferredSize(new Dimension(200, 0));
			
			add(rollButton);
			add(playerComboBox);
			add(bet);
			add(betTypeComboBox);
			add(betConfirm);
			add(betCancel);
			
			bet.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {
					if(bet.getText().equals(ENT_BET_STRING)) {
						bet.setText("");
					}
				
			};
				
			});
			
			
			
		}
		
}

		
		

