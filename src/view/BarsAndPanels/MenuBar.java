package view.BarsAndPanels;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.interfaces.GameEngine;
import view.GameEngineWindow;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar{
	
	private JMenu menuMain;
	private JMenuItem exitMenuItem;
	
	private JMenu menuDice;
	private JMenuItem rollerRoll;
	
	private JMenu menuPlayer;
	private JMenuItem addPlayerMenuItem;
	private JMenuItem removePlayerMenuItem;
	
	@SuppressWarnings("unused")
	private GameEngine gameEngine;
	@SuppressWarnings("unused")
	private GameEngineWindow gameEngineWindow;
	
	private MenuBar(GameEngine gameEngine, GameEngineWindow gameEngineWindow) {
	this.gameEngine = gameEngine;
	this.gameEngineWindow = gameEngineWindow;
	// Main Menu
	menuMain = new JMenu("File");
	exitMenuItem = new JMenuItem("Exit");
	menuMain.add(exitMenuItem);
	// Player Menu
	menuPlayer = new JMenu("File");
	addPlayerMenuItem = new JMenuItem("Add Player");
	removePlayerMenuItem = new JMenuItem("Remove Player");
	menuPlayer.add(addPlayerMenuItem);
	menuPlayer.add(removePlayerMenuItem);
	// Dice Menu
	menuDice = new JMenu("Roller");
	rollerRoll = new JMenuItem("RollerRoll");
	menuDice.add(rollerRoll);
	
	playerListener = new PlayerListener(gameEngine, GameEngineWindow);
	addPlayerMenuItem.addActionListener(playerListener);
	removePlayerMenuItem.addActionListener(playerListener);
	rollerRoll.addActionListener(new RollerRollActionListener(gameEngine, mainFrame));
	add(menuMain);
	add(menuPlayer);
	add(menuDice);
	
	}	

}
