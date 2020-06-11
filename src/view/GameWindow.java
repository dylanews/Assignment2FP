package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.component.DicePanel;
import view.component.MenuAndToolBarPanel;
import view.component.StatusBar;
import view.component.SummaryPanel;

public class GameWindow extends JFrame{
	
	private MenuAndToolBarPanel menuAndToolPanel;
	private DicePanel dicePanel;
	private SummaryPanel summaryPanel;
	private StatusBar statusBar;
	private final GameEngine gameEngine;
	private String activePlayer;
	private String activePlayerId;
	
	public GameWindow() {
		super("Dice Game GUI");

		gameEngine = new GameEngineImpl();
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(this));
		
		
		setLayout(new BorderLayout());
		setSize(1200, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		// Adding all panel components to game window display
		menuAndToolPanel = new MenuAndToolBarPanel(gameEngine, this);
		add(menuAndToolPanel, BorderLayout.NORTH);

		dicePanel = new DicePanel(gameEngine, this);
		add(dicePanel, BorderLayout.CENTER);
		
		summaryPanel = new SummaryPanel(gameEngine, this);
		add(summaryPanel, BorderLayout.EAST);
		
		statusBar = new StatusBar(gameEngine);
		add(statusBar, BorderLayout.SOUTH);
		
		
		setVisible(true);
		
	}
	
	
	public MenuAndToolBarPanel getMenuAndToolPanel() {
		return menuAndToolPanel;
	}


	public DicePanel getDicePanel() {
		return dicePanel;
	}


	public SummaryPanel getSummaryPanel() {
		return summaryPanel;
	}


	public StatusBar getStatusBar() {
		return statusBar;
	}


	public GameEngine getGameEngine() {
		return gameEngine;
	}
	
	public String getActivePlayer() {
		return activePlayer;
	}
	
	public String getActivePlayerID() {
		return activePlayerId;
	}
	
	public Player getActivePlayerAsPlayer() {
		return gameEngine.getPlayer(getActivePlayerID());
	}
	
	public void setActivePlayerID(String playerId) {
		this.activePlayerId = playerId;
	}

	public void setActivePlayer(String playerName) {
		this.activePlayer = playerName;
		
	}
}