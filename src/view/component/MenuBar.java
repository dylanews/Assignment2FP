package view.component;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.PlayerListener;
import controller.RollerListener;
import model.interfaces.GameEngine;
import view.GameWindow;

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
	private GameWindow gameWindow;
	
	MenuBar(GameEngine gameEngine, GameWindow gameWindow) {
	this.gameEngine = gameEngine;
	this.gameWindow = gameWindow;
	// Main Menu
	menuMain = new JMenu("File");
	exitMenuItem = new JMenuItem("Exit");
	menuMain.add(exitMenuItem);
	// Player Menu
	menuPlayer = new JMenu("Player Menu");
	addPlayerMenuItem = new JMenuItem("Add Player");
	removePlayerMenuItem = new JMenuItem("Remove Player");
	menuPlayer.add(addPlayerMenuItem);
	menuPlayer.add(removePlayerMenuItem);
	// Dice Menu
	menuDice = new JMenu("Roller");
	rollerRoll = new JMenuItem("RollerRoll");
	menuDice.add(rollerRoll);
	
	PlayerListener playerListener = new PlayerListener(gameEngine, gameWindow);
	addPlayerMenuItem.addActionListener(playerListener);
	removePlayerMenuItem.addActionListener(playerListener);
	rollerRoll.addActionListener(new RollerListener(gameEngine, gameWindow));
	add(menuMain);
	add(menuPlayer);
	add(menuDice);
	
	}	

}
