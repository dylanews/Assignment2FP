package view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.component.DicePanel;
import view.component.GameEngineCallbackGUI;
import view.component.MenuPanel;
import view.component.SummaryPanel;
import view.component.Toolbar;
import view.component.StatusBar;

@SuppressWarnings("serial")
public class GameWindow extends JFrame{
	
	private final GameEngine gameEngine;
	private MenuPanel menuPanel;
	private DicePanel dicePanel;
	private SummaryPanel summaryPanel;
	private StatusBar statusBar;
	private Toolbar toolbar;
	private String activePlayer;
	private String activePlayerID;
	
	public GameWindow() {
		super("DICE GAME");
		gameEngine = new GameEngineImpl();
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(null));
			setLayout(new BorderLayout());
			setSize(1400,600);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			dicePanel = new DicePanel(gameEngine, this);
			add(dicePanel, BorderLayout.CENTER);
			menuPanel = new MenuPanel (gameEngine, this);
			add(menuPanel, BorderLayout.NORTH);
			summaryPanel = new SummaryPanel(gameEngine, this);
			add(summaryPanel, BorderLayout.EAST);
			statusBar = new StatusBar(gameEngine, this);
			add(statusBar, BorderLayout.SOUTH);
			setVisible(true);	
	}
	public DicePanel getDicePanel() {
		return dicePanel;
	}
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}
	public SummaryPanel getSummaryPanel() {
		return summaryPanel;
	}
	public StatusBar getStatusBar() {
		return statusBar;
	}
	public String getActivePlayer() {
		return activePlayer;
	}
	public String getActivePlayerID() { 
		return activePlayerID;
	}
	public Player getActivePlayerAsPlayer() {
		return gameEngine.getPlayer(getActivePlayerID());
	}
	public void setActivePlayer(String playerName) {
		this.activePlayer = playerName;
	}
	public Toolbar getToolbarPanel() {
		return toolbar;

	}
}