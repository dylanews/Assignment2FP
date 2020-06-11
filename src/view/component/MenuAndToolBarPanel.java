package view.component;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.interfaces.GameEngine;
import view.GameWindow;

@SuppressWarnings("serial")
public class MenuAndToolBarPanel extends JPanel{
	
	private GameEngine gameEngine;
	private GameWindow gameWindow;
	private MenuBar menuBar;
	private ToolBar toolBar;
	
	
	// Combining Menubar and Toolbar into one JPanel
	public MenuAndToolBarPanel(GameEngine gameEngine, GameWindow gameWindow) {
		
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		// Initialising objects and adding to Jpanel
		this.menuBar = new MenuBar(gameEngine, gameWindow);
		this.toolBar = new ToolBar(gameEngine, gameWindow);
		menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(menuBar);
		add(toolBar);
		
}
	
	public ToolBar getToolBar() {
		
		return toolBar;
		
	}
	
	
}
