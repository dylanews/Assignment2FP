package controllerListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.interfaces.GameEngine;
import view.GameEngineWindow;

public class RollDie implements ActionListener {
	
	private GameEngine gameEngine;
	private GameWindow gameWindow;
	
	public RollDie(GameEngine gameEngine, GameWindow gameWindow) {
		
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			if(betCheck()) {
				new Thread() {
					
					@Override
					public void run() {
						
						try {
							
							gameEngine.spinPlayer(gameWindow.getActivePlayerAsPlaye(), 100, 100, 50, 500, 50);
							
						} catch (NullPointerException exception) {
							
							JOptionPane.showMessageDialog(gameWindow, "Please add a player to roll");
							
						}
						
					}
					
					
				}.start();
			}
			else {
				
				throw new NoBet();
				
			}
		} catch(NoBet exception) {
			JOptionPane.showMessageDialog(gameWindow, "Please place a bet");
			
		}
			
		}
	
	private boolean betCheck() {
		
		Player activePlayer = gameWindow.getActivePlayerAsPlayer();
		if(activePlayer.getBetAmount == null) {
			
			return false;
			
		} else {
			
			return true;
		}
		
	}
}

	
