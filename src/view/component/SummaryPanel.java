package view.component;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.HouseListener;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameWindow;

public class SummaryPanel extends JPanel{

	private GameEngine gameEngine;
	private GameWindow gameWindow;
	private Map<String, JLabel> player;
	private Map<String, JLabel> playerBet;
	private Map<String, JLabel> playerResult;
	
	public SummaryPanel(GameEngine gameEngine, GameWindow gameWindow) {
		this.gameEngine = gameEngine;
		this.gameWindow = gameWindow;
		this.player = new HashMap<String, JLabel>();
		this.playerBet = new HashMap<String, JLabel>();
		this.playerResult = new HashMap<String, JLabel>();
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(200,100));
		
		//colour of border
		Border borderLine = BorderFactory.createLineBorder(Color.getHSBColor(185,32,30));
		TitledBorder summary = BorderFactory.createTitledBorder(borderLine, "Game Summary");
		summary.setTitleJustification(TitledBorder.CENTER);
		setBorder(summary);
	}
	
	// Add player method of previewing in summary panel
	public void addPlayer(Player player) {
		this.player.put(player.getPlayerId(), new JLabel(player.getPlayerId() +" "+ player.getPlayerName() +" "+player.getPoints()));
		add(this.player.get(player.getPlayerId()));
		playerBet.put(player.getPlayerId(), new JLabel("No bet placed"));
		add(playerBet.get(player.getPlayerId()));
		playerResult.put(player.getPlayerId(), new JLabel("No result displayed"));
		add(playerResult.get(player.getPlayerId()));
		
		updateUI();
		
	}
	
	// Remove player method of previewing in summary panel
	public void removePlayer() {
		removeAll();
		Collection<Player> allPlayers = gameEngine.getAllPlayers();
		for (Player player : allPlayers) {
			add(new JLabel(player.getPlayerId() +" "+ player.getPlayerName() +" "+player.getPoints()));
		}
		
		updateUI();
	}
	
	public void updateSummaryPanel(Player player, DicePair dicePair) {
		updatePlayerBetResult(player);
	}
	

	
	private void updatePlayerBetResult(Player player) {
		playerResult.get(player.getPlayerId()).setText(player.getResult().toString());
	}
	


	public void updateBetInfo(Player activePlayer, String betEntered) {
		playerBet.get(activePlayer.getPlayerId()).setText(betEntered);
			
	}
	
	public void updateBetCancel(Player activePlayer) {
		playerBet.get(activePlayer.getPlayerId()).setText("No bet placed");
	}
	
	public void autoSpin() {

		if(checkPlayerResults()) {
			new HouseListener(gameEngine, gameWindow).actionPerformed(null);
		}

		
	}

	private boolean checkPlayerResults() {
		for (Map.Entry<String, JLabel> entry : playerResult.entrySet()){
			JLabel value = entry.getValue();
			if(value.getText().equals("No result displayed")){
				return false;
			}
			
		}
		return true;
	
	}

	public void summary() {
		Collection<Player> players = gameEngine.getAllPlayers();
		ArrayList<Player> toBeRemoved = new ArrayList<Player>();
		for (Player player : players) {
			if(player.getPoints() == 0) {
				toBeRemoved.add(player);
			}
		}
		
		for (Player player : toBeRemoved) {
			this.player.remove(player.getPlayerId());
			playerBet.remove(player.getPlayerId());
			playerResult.remove(player.getPlayerId());
			gameEngine.removePlayer(player);
			removePlayer();
			gameWindow.getMenuAndToolPanel().getToolBar().removePlayer();
		}

		
		for (Map.Entry<String, JLabel> entry : player.entrySet()){
			String key = entry.getKey();
			JLabel value = entry.getValue();
			int pointsOld = Integer.parseInt(value.getText().split(" ")[2]);
			
			Player player = gameEngine.getPlayer(key);
			
			int pointsCurrent = player.getPoints();
			
			int pointsDifference = pointsOld - pointsCurrent;
			String winloss = "";
			if(pointsDifference < 0) {
				winloss = "Won " + Integer.toString(-1*pointsDifference) + " points";
			}else {
				winloss = "Lost " + Integer.toString(pointsDifference) + " points";
			}
			value.setText(player.getPlayerId() +" "+ player.getPlayerName() +" "+player.getPoints()+ "  "+ winloss );
		}
	}
	
	public void DeletePlayer(Player player) {
		this.player.remove(player.getPlayerId());
		playerBet.remove(player.getPlayerId());
		playerResult.remove(player.getPlayerId());
		
	}


}
