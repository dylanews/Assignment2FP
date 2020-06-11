package view;

import javax.swing.SwingUtilities;

import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback{
	
	private GameWindow gameWindow;

	public GameEngineCallbackGUI(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
	}

	// player die update
	@Override
	public void playerDieUpdate(Player player, Die die, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gameWindow.getDicePanel().updateDie(player, die);
			}
		});

	}

	// house die update 
	@Override
	public void houseDieUpdate(Die die, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gameWindow.getMenuAndToolPanel().getToolBar().getRollButton().setEnabled(false);
				gameWindow.getMenuAndToolPanel().getToolBar().getPlayerComboBox().setEnabled(false);
				gameWindow.getStatusBar().setActivePlayer("Roller");
				gameWindow.getStatusBar().setFeedback("Roller is Rolling");
				gameWindow.getDicePanel().updateRollerDie(die);
					
				
			}
		});

	}

	// Results of player after rolling dice
	@Override
	public void playerResult(Player player, DicePair dicePair, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gameWindow.getSummaryPanel().updateSummaryPanel(player, dicePair);
				
				gameWindow.getSummaryPanel().autoSpin();
			}
		});

	}

	
	// Run result of house dice
	@Override
	public void houseResult(DicePair dicePair, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gameWindow.getStatusBar().setActivePlayer(gameWindow.getActivePlayer());
				gameWindow.getMenuAndToolPanel().getToolBar().getRollButton().setEnabled(true);
				gameWindow.getMenuAndToolPanel().getToolBar().getPlayerComboBox().setEnabled(true);
				gameWindow.getStatusBar().setFeedback("House Results: " + dicePair.toString());
				gameWindow.getSummaryPanel().summary();
			}
		});

	}


}
