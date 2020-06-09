package view.component;


import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.interfaces.GameEngine;
import view.GameWindow;

@SuppressWarnings("serial")
public class MenuAndToolBarPanel extends JPanel{
	
	private MenuBar menuBar;
	private Toolbar toolBar;
	private GameEngine gameEngine;
	private GameWindow gameWindow;
	
	public MenuAndToolBarPanel(GameEngine gameEngine, GameWindow gameWindow) {
		
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		
		this.menuBar = new MenuBar(gameEngine, gameWindow);
		menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(menuBar);
				

		this.toolBar = new Toolbar(gameEngine, gameWindow);
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(toolBar);
	}

	public Toolbar getToolBar() {
		
		return toolBar;
		
	}

}