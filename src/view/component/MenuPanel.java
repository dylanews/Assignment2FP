package view.component;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.interfaces.GameEngine;
import view.GameWindow;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel{
	
	private MenuBar menuBar;
	private Toolbar toolBar;
	@SuppressWarnings("unused")
	private GameEngine gameEngine;
	@SuppressWarnings("unused")
	private GameWindow gameWindow;
	
	public MenuPanel(GameEngine gameEngine, GameWindow gameWindow) {
		
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.menuBar = new MenuBar(gameEngine, gameWindow);
		menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.toolBar = new Toolbar(gameEngine, gameWindow);
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(menuBar);
		add(toolBar);
}
	public Toolbar getToolBar() {
		return toolBar;
	}
	public MenuBar getMenuBar() {
		return menuBar;
	}
}
