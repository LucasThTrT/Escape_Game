package com.jeu;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
	
	private static final long serialVersionUID = 1L; // évite les erreurs de compatibilité (enlève l'avertissement)

	public Fenetre (int WIDTH_IMG, int HEIGHT_IMG) {
		setTitle("ESCAPE GAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH_IMG, HEIGHT_IMG);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
	}
	
}
