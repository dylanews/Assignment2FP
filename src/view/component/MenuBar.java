package view.component;

import javax.swing.*;

import controller.ExitListener;
import controller.HouseListener;
import controller.PlayerListener;
import model.interfaces.GameEngine;
import view.GameWindow;


@SuppressWarnings("serial")
public class MenuBar extends JMenuBar{
	
	// Referencing to GameEngine and GameWindow Class
	private GameEngine gameEngine;
	private GameWindow gameWindow;
	
	// Creating JMenus variables
	private JMenu fileMenu;
	private JMenu houseMenu;
	private JMenu playerMenu;
	
	// Creating JMenus' items variables
	private JMenuItem exitItem;
	private JMenuItem rollHouseItem;
	private JMenuItem addPlayerItem;
	private JMenuItem removePlayerItem;
	
	public MenuBar(GameEngine gameEngine, GameWindow gameWindow) {
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;
		
		// File Menu
		fileMenu = new JMenu("File");
		exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);
		
		// House Menu
		houseMenu = new JMenu("House");
		rollHouseItem = new JMenuItem("Roll House");
		houseMenu.add(rollHouseItem);
		
		// Player Menu
		playerMenu = new JMenu("Player");
		addPlayerItem = new JMenuItem("Add Player");
		removePlayerItem = new JMenuItem("Remove Player");
		playerMenu.add(addPlayerItem);
		playerMenu.add(removePlayerItem);
		
		// Adding Listeners to JMenuItems
		PlayerListener playerListener = new PlayerListener(gameEngine, gameWindow);
		exitItem.addActionListener(new ExitListener());
		rollHouseItem.addActionListener(new HouseListener(gameEngine, gameWindow));
		addPlayerItem.addActionListener(playerListener);
		removePlayerItem.addActionListener(playerListener);
		
		// Adding components to MenuBar
		add(fileMenu);
		add(houseMenu);
		add(playerMenu);

	}

}
