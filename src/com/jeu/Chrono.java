package com.jeu;

public class Chrono implements Runnable {
	
	private final int PAUSE = 3;  // temps d'attente entre 2 Tours de boucles

	@Override
	public void run() {
		
		while(true) {	
			Main.scene.repaint();
			// Pause de 3ms
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {}  // Opération qui peut levé une exception
		}
	}
}
