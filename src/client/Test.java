package client;

import javax.swing.SwingUtilities;

import view.GameWindow;

public class Test {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GameWindow();
				
			}
		});
	}
}
 