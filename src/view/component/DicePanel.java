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
	
	
	
		int value;
		Color color = Color.black;
		private static final int SIDE = 32;
		
	public DicePanel(GameEngine gameEngine, GameWindow gameWindow) {
		
	}
	
	 @Override
	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.setColor(color);
		switch (value) {
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
	  }

	public void updateDie(Player player, Die die) {
		// TODO Auto-generated method stub
		
	}

	public void updateRollerDie(Die die) {
		// TODO Auto-generated method stub
		
	}
	
	public void changePlayer(Player player, Die die) {

		activePlayer = gameWindow.getActivePlayerAsPlayer();
		if (activePlayer.getResult() != null) {
			activePlayer = gameWindow.getActivePlayerAsPlayer();
			// make the value of dice change so the repainting is correct
			repaint();
		} else {
			die1 = null;
			die2 = null;
			repaint();

		}
	}
}
	
	
	
