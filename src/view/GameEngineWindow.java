package view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.BarsAndPanels.DicePanel;
import view.BarsAndPanels.MenuPanel;
import view.BarsAndPanels.StatusBar;
import view.BarsAndPanels.SummaryPanel;

@SuppressWarnings("serial")
public class GameEngineWindow extends JFrame{
	
	private MenuPanel menuPanel;
	private DicePanel dicePanel;
	private SummaryPanel summaryPanel;
	private StatusBar statusBar;
	private final GameEngine gameEngine;
	private String currentPlayer;
	
	public GameEngineWindow() {
		super("DICE GAME");
		gameEngine = new GameEngineImpl();
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI());
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
	public String getCurrentPlayer() {
		return currentPlayer;
	}
	public String getCurrentPlayerID() {
		return currentPlayerID;
	}
	public Player getCurrentPlayerAsPlayer() {
		return gameEngine.getPlayer(getCurrentPlayerID());
	}
	public void setCurrentPlayer(String playerName) {
		this.currentPlayer = playerName;
	}
}
