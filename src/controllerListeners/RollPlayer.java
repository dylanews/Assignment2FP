package controllerListeners;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;

public class RollPlayer implements ActionListener {

	private GameEngine gameEngine;
	private GameWindow gameWindow;

	public RollPlayer(GameEngine gameEngine, GameWindow gameWindow) {
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Thread() {

			@Override
			public void run() {

				try {

					gameEngine.rollPlayer(100, 1000, 100, 50,
							500, 50);

				} catch (NullPointerException exception) {

					JOptionPane.showMessageDialog(gameWindow, "Please add a player");

				}
			}

		}.start();

	}

}