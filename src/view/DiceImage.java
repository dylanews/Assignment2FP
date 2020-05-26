package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DiceImage extends JFrame {
	DiceImage() {
		
		setLayout (new FlowLayout());
		add(new Dice());
		add (new Dice());
		setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public static void main (String[] args) {
		new DiceImage();
		
	}
}
