package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CreatePlayer extends JPanel {
	private JTextField playerNametext;
	private JTextField playerPointsfld;
	public CreatePlayer() {
		JLabel playerNameBox = new JLabel("Enter player name:");
		playerNametext = new JTextField(30);
		JLabel playerPoinstBox = new JLabel("Enter the amount of player points");
		playerPointsfld = new JTextField(30);
		add(playerNameBox);
		add(playerNametext);
		add(playerPoinstBox);
		add(playerPointsfld);
	}
	public String getPlayerNameTxtFld() {
		return playerNametext.getText();
	}
	public String getPlayerPointsField() {
		return playerPointsfld.getText();
	}
}
