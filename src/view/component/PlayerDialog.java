package view.component;

import javax.swing.*;

@SuppressWarnings("serial")
public class PlayerDialog extends JPanel{
	
	// Create text field variables
	private JTextField playerNameField;
	private JTextField playerPointsField;
	
	public PlayerDialog(){
		
		// Player Name Input
		JLabel playerNameLabel = new JLabel("Enter player name:");
		playerNameField = new JTextField(30);
		add(playerNameLabel);
		add(playerNameField);
		
		// Player Point Input
		JLabel playerPointsLabel = new JLabel("Enter player points");
		playerPointsField = new JTextField(30);
		add(playerPointsLabel);
		add(playerPointsField);
		
	}
	
	public String getPlayerNameField() {
		return playerNameField.getText();
	}
	
	public String getPlayerPointsField() {
		return playerPointsField.getText();
	}

}
