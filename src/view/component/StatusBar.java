package view.component;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import model.interfaces.GameEngine;
import view.GameWindow;

@SuppressWarnings("serial")
public class StatusBar extends JPanel{
	
	private GameEngine gameEngine;
	private GameWindow gameWindow;
	private JLabel activePlayer;
	private JLabel comments;
	private final String INITIAL_TEXT = "Add player to Start";
	
	public StatusBar(GameEngine gameEngine) {
		
		// Set layout and border for status bar JPanel
		this.gameEngine = gameEngine;
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		activePlayer = new JLabel(INITIAL_TEXT);
		activePlayer.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		comments = new JLabel(); 
		comments.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		// adding components to status bar jpanel
		add(activePlayer);
		add(Box.createHorizontalGlue());
		add(comments);
		
	}
	
	public void setActivePlayer(String selectedPlayer) {
		
		activePlayer.setText("Selected Player: " + selectedPlayer);
	
	}
	
	public void setDefaultActivePlayer() {
		
		activePlayer.setText(INITIAL_TEXT);
		
	}
	
	
	public void setFeedback (String feedbackText) {
		
		comments.setText(feedbackText);
		
	}
	
}
