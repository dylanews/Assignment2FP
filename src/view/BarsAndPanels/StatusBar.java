package view.BarsAndPanels;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import model.interfaces.GameEngine;

public class StatusBar extends JPanel{

	private JLabel statusBarLbl;
	private GameEngine gameEngine;
	private JLabel activePlayer;
	private JLabel comments;
	private final String ACTIVE_PLAYER_INITIAL_TEXT = "Add player to start the application";
	
	public StatusBar(GameEngine gameEngine) {
		
		this.gameEngine = gameEngine;
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		activePlayer = new JLabel(ACTIVE_PLAYER_INITIAL_TEXT);
		activePlayer.setAlignmentX(Component.LEFT_ALIGNMENT);
		comments = new JLabel();
		comments.setAlignmentX(Component.RIGHT_ALIGNMENT);
		add(activePlayer);
		add(Box.createHorizontalGlue());
		add(comments);
	}
	public void setActivePlayer(String activePlayer) {
		this.activePlayer.setText("Active Player: " + activePlayer);
	}
	public void setDefaultCurrentPlayer() {
		activePlayer.setText(ACTIVE_PLAYER_INITIAL_TEXT);
	}
	public void setComments(String comments) {
		this.comments.setText(comments);
	}
}
