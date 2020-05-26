package view.BarsAndPanels;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	
	private JMenu menuMain;
	private JMenuItem exitMenuItem;
	
	private JMenu menuDice;
	private JMenuItem rollerRoll;
	
	private JMenu menuPlayer;
	private JMenuItem addPlayerMenuItem;
	private JMenuItem removePlayerMenuItem;
	
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	
	private MenuBar(GameEngine gameEngine, MainFrame mainFrame) {
	
	this.gameEngine = gameEngine;
	this.mainFrame = mainFrame;
	
	
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
	
	
	playerActionListener = new PlayerActionListener(gameEngine, MainFrame);
	addPlayerMenuItem.addActionListener(playerActionListener);
	removePlayerMenuItem.addActionListener(playerActionListener);
	
	rollerRoll.addActionListener(new RollerRollActionListener(gameEngine, mainFrame));
	
	add(menuMain);
	add(menuPlayer);
	add(menuDice);
	
	}	

}
