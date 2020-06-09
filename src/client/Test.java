package client;

import javax.swing.SwingUtilities;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.component.GameEngineCallbackGUI;
import view.GameWindow;

public class Test {

	public static void main(String[] args) {
		
		final GameEngine gameEngine = new GameEngineImpl();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(null));
				
				new GameWindow();
				
			}
		});
	}
}
 