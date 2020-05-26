package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreatePlayer extends JPanel {

	private JTextField playerNameTxtFld;
	private JTextField playerPointsTxtFld;
	
	public CreatePlayer() {
		
		JLabel playerNameBox = new JLabel("Enter player name:");
		playerNameTxtFld = new JTextField(30);
		
		JLabel playerPoinstBox = new JLabel("Enter the amount of player points");
		playerPointsTxtFld = new JTextField(30);
		
		add(playerNameBox);
		add(playerNameTxtFld);
		add(playerPoinstBox);
		add(playerPointsTxtFld);
	}

	public String getPlayerNameTxtFld() {
		return playerNameTxtFld.getText();
	}
	public String getPlayerPointsField() {
		return playerPointsTxtFld.getText();
	}
}
