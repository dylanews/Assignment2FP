package view.BarsAndPanels;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
	
	private MenuBar menuBar;
	private ToolBar toolBar;
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	
	public MenuPanel(GameEngine gameEngine, MainFrame mainFrame) {
		
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.menuBar = new MenuBar(gameEngine, mainFrame);
		menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		this.toolBar = new ToolBar(mainFrame, gameEngine);
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
