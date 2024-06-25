package com.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener{

	@Override
	public void keyPressed(KeyEvent arg0) {
		// DROITE
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {Main.scene.setDx(1);}
		// GAUCHE
		else if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {Main.scene.setDx(-1);}
		// HAUT
		else if (arg0.getKeyCode() == KeyEvent.VK_UP) {Main.scene.setDy(1);}
		// BAS
		else if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {Main.scene.setDy(-1);}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		Main.scene.setDx(0);
		Main.scene.setDy(0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}	
	
}