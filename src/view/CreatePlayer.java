package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CreatePlayer extends JPanel{
	
	private JTextField playerNameText;
	private JTextField playerPointsText;
	
	public CreatePlayer() {
		JLabel playerNameBox = new JLabel("Enter player name:");
		playerNameText = new JTextField(30);
		JLabel playerPointsBox = new JLabel("Enter the amount of player points");
		playerPointsText = new JTextField(30);
		add(playerNameBox);
		add(playerNameText);
		add(playerPointsBox);
		add(playerPointsText);
	}
	
	public String getPlayerNameText() {
		return playerNameText.getText();
	}
	
	public String getPlayerPointsText() {
		return playerPointsText.getText();
	}
	
}
