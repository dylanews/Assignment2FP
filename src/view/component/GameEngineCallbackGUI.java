package view.component;
import javax.swing.SwingUtilities;

import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameWindow;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements  GameEngineCallback{

	private GameWindow gameWindow;

	public GameEngineCallbackGUI(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
	}

	@Override
	public void playerDieUpdate(Player player,Die die, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gameWindow.getDicePanel().updateDie(player, die);
			}
		});

	}

	@Override
	public void houseDieUpdate(Die die, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gameWindow.getMenuPanel().getToolBar().getSpinButton().setEnabled(false);
				gameWindow.getMenuPanel().getToolBar().getPlayerComboBox().setEnabled(false);
				gameWindow.getStatusBar().setActivePlayer("Spinner");
				gameWindow.getStatusBar().setComments("Spinner is spinning");
				gameWindow.getDicePanel().updateRollerDie(die);
					
				
			}
		});

	}

	@Override
	public void playerResult(Player player, DicePair dicePair, GameEngine gameEngine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gameWindow.getSummaryPanel().updateSummaryPanel(player, dicePair);
				
				gameWindow.getSummaryPanel().UpdateBetDetails(player, betEntered);
			}
		});

	}

	@Override
	public void houseResult(DicePair dicePair, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gameWindow.getStatusBar().setActivePlayer(gameWindow.getActivePlayer());
				gameWindow.getMenuPanel().getToolBar().getSpinButton().setEnabled(true);
				gameWindow.getMenuPanel().getToolBar().getPlayerComboBox().setEnabled(true);
				gameWindow.getStatusBar().setComments("Spinner Results: " + dicePair.toString());
				gameWindow.getSummaryPanel().summarise();
			}
		});

	}




}