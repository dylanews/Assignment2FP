package view.BarsAndPanels;

import java.awt.Dimension;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import javax.swing.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;


@SuppressWarnings("serial")
public class SummaryPanel extends JPanel{
	private GameEngine gameEngine;
	private GameEngineWindow gameEngineWindow;
	private Map<String, JLabel>playerDetails;
	private Map<String, JLabel>playerBetDetails;
	private Map<String, JLabel>playerBetResult;
	
	public SummaryPanel(GameEngine gameEngine, GameEngineWindow gameEngineWindow) {
		this.gameEngine = gameEngine;
		this.gameEngineWindow = gameEngineWindow;
		this.playerDetails = new HashMap<String, JLabel>();
		this.playerBetDetails = new HashMap<String, JLabel>();
		this.playerBetResult = new HashMap<String, JLabel>();
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(300,200));
		
		Border blueline = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titleBorder = BorderFactory.createTitledBorder(blueline,"SummaryPanel");
		title.setTitleJustification(TitledBorder.CENTER);
		setBorder(titleBorder);
	}
	public void playerAdd(Player player) {
		this.playerBetDetails.put(player.getPlayerId(), newJLabel(player.getPlayerId()+""+player.getPlayerName()+""+player.getPoints()));
		add(this.player.get(player.getPlayerId()));
		playerBetDetails.put(player.getPlayerId(), new JLabel("there are no bets placed"));
		add(playerBetDetails.get(player.getPlayerId()));
		playerBetResult.put(player.getPlayerId(), new JLabel("there are no result being displayed"));
		add(playerBetResult.get(player.getPlayerId()));
		updateUI();
	}
	public void deletePlayer() {
		removeAll();
		Collection<Player> allPlayers = gameEngine.getAllPlayers();
		for (Player player: allPlayers) {
			add(new JLabel(player.getPlayerId()+""+player.getPlayerName()+""+player.getPoints()));
			updateUI();
		}
	}
	public void updateSummaryPanel(Player player, DicePair dicePair) {
		updatePlayerBetResult(player);
	}
	public void UpdateBetDetails(Player currentPlayer, String betEntered)
	

}
