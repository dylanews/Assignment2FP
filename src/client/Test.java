package client;

import javax.swing.SwingUtilities;

import view.GameEngineWindow;

public class Test {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GameEngineWindow();
				
			}
		});
	}
}
 