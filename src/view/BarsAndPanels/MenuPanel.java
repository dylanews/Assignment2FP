package view.BarsAndPanels;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.interfaces.GameEngine;
import view.GameEngineWindow;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel{
	
	private MenuBar menuBar;
	private ToolBar toolBar;
	@SuppressWarnings("unused")
	private GameEngine gameEngine;
	@SuppressWarnings("unused")
	private GameEngineWindow gameEngineWindow;
	
	public MenuPanel(GameEngine gameEngine, GameEngineWindow gameEngineWindow) {
		
		this.gameEngine = gameEngine;
		this.gameEngineWindow = gameEngineWindow;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.menuBar = new MenuBar(gameEngine, gameEngineWindow);
		menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.toolBar = new ToolBar(gameEngineWindow, gameEngine);
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(menuBar);
		add(toolBar);
}
	public ToolBar getToolBar() {
		return toolBar;
	}
	public MenuBar getMenuBar() {
		return menuBar;
	}
}
