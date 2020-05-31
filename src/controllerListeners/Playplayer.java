package controllerListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import view.GameEngineWindow;
import model.interfaces.GameEngine;

public class Playplayer implements ActionListener {
	private GameEngine gameEngine;
	private GameEngineWindow gameEngineWindow;
	
	public Playplayer(GameEngine gameEngine, GameEngineWindow gameEngineWindow) {
		this.gameEngine = gameEngine;
		this.gameEngineWindow = gameEngineWindow;
	}
	public void actionPerformed(ActionEvent e) {
		setCurrentPlayer(e);
		updateStatusBar();
		updateDicePanel();
		}
		private void updateDicePanel() {
			if(gameEngineWindow.getCurrentPlayer()!=(null)) {
				gameEngineWindow.getDicePanel().changePlayer();
			}
		}
		private void setCurrentPlayer(ActionEvent e) {
			JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
			String comboBoxSelection = (String) comboBox.getSelectedItem();
			gameEngineWindow.setCurrentPlayer(comboBoxSelection);
		}
		private void updateStatusBar() {
            if(gameEngineWindow.getCurrentPlayer() != null) {
                gameEngineWindow.getStatusBar().setCurrentPlayer(gameEngineWindow.getCurrentPlayer());
            } else {
                gameEngineWindow.getStatusBar().setDefaultCurrentPlayer();
            }
        }
	}