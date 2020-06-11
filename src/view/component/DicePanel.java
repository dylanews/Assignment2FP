package view.component;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameWindow;

@SuppressWarnings("serial")
public class DicePanel extends JPanel {
	
	private GameEngine gameEngine;
	private GameWindow gameWindow;
	private Player activePlayer;
	private Die die1;
	private Die die2;
	
	
	
		int value1;
		int value2;
		Color color = Color.black;
		private static final int SIDE = 32;
		private static final int SIDE2 = 100;
		
	public DicePanel(GameEngine gameEngine, GameWindow gameWindow) {
		
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;
		
	}
	
	// Display two dice
	 @Override
	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.setColor(color);
		g.setColor(color);
		switch (value1) {
	    case 1:
	      g.fillRect(3 * SIDE, 3 * SIDE, SIDE, SIDE);
	      break;
	    case 2:
	      g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
	      break;
	    case 3:
	      g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(3 * SIDE, 3 * SIDE, SIDE, SIDE);
	      break;
	    case 4:
	      g.fillRect(SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
	      break;
	    case 5:
	      g.fillRect(SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(3 * SIDE, 3 * SIDE, SIDE, SIDE);
	      break;
	    case 6:
	      g.fillRect(SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(SIDE, 3 * SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE, 3 * SIDE, SIDE, SIDE);
	      break;
	    }
		switch (value2) {
	    case 1:
	      g.fillRect(5 * SIDE2-128, 3 * SIDE, SIDE, SIDE);
	      break;
	    case 2:
	      g.fillRect(5 * SIDE2, SIDE, SIDE, SIDE);
	      g.fillRect(5 *SIDE2-128, 5 * SIDE, SIDE, SIDE);
	      break;
	    case 3:
	      g.fillRect(5 *SIDE2, SIDE, SIDE, SIDE);
	      g.fillRect(5 *SIDE2, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE2-128, 3 * SIDE, SIDE, SIDE);
	      break;
	    case 4:
	      g.fillRect(5 *SIDE2-128, SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE2, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE2, SIDE, SIDE, SIDE);
	      g.fillRect(5 *SIDE2-128, 5 * SIDE, SIDE, SIDE);
	      break;
	    case 5:
	      g.fillRect(5 *SIDE2-128, SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE2, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE2, SIDE, SIDE, SIDE);
	      g.fillRect(5 *SIDE2-128, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE2-128, 3 * SIDE, SIDE, SIDE);
	      break;
	    case 6:
	      g.fillRect(5 *SIDE2-128, SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE2, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE2, SIDE, SIDE, SIDE);
	      g.fillRect(5 *SIDE2-128, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(5 *SIDE2-128, 3 * SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE2, 3 * SIDE, SIDE, SIDE);
	      break;
	    }
	  }

	 // update both dice
	public void updateDie(Player player, Die die) {
		activePlayer = gameWindow.getActivePlayerAsPlayer();
		if (player.equals(activePlayer) && die.getNumber() == 1) {
			value1 = die1.getValue();
		}

		else if (player.equals(activePlayer) && die.getNumber() == 2) {
			value2 = die2.getValue();
		}
		repaint();
		
	}

	// update house dice
	public void updateRollerDie(Die die) {
		if (die.getNumber() == 1) {
			value1 = die1.getValue();
		}

		else if (die.getNumber() == 2) {
			value2 = die2.getValue();
		}
		repaint();
		
	}
	
	// change active player
	public void changePlayer() {

		activePlayer = gameWindow.getActivePlayerAsPlayer();
		
		System.out.println(activePlayer);
		
		if (activePlayer.getResult() != null) {
			activePlayer = gameWindow.getActivePlayerAsPlayer();
			die1 = activePlayer.getResult().getDie1();
			die2 = activePlayer.getResult().getDie2();
			repaint();
		} else {
			die1 = null;
			die2 = null;
			repaint();

		}
	}
}
	
	
	
