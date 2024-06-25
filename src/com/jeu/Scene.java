package com.jeu;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Scene extends JPanel{

	private static final long serialVersionUID = 1L;
	
	// IL FAUT 4 IMG DE FOND DONC ON CRÉE UNE LISTE D'IMG
	private ImageFond[] fonds;
	
	private ImageIcon icoPerso;
	private Image imgPerso;
	
	static final int HEIGHT_IMG = 360;
	static final int WIDTH_IMG = 700;

	private int dx;
	private int dy;
	
	public Scene() {
		
		super();
		
		fonds = new ImageFond[4];

		// INITIALISATION DES POSITIONS DES 4 IMAGES !!
		// fond [0] = (0;0)
		// fond [1] = (1;0)
		// fond [2] = (0;1)
		// fond [3] = (1;1)
		
		// Pour x on regarde la parité de i pair --> x = 1 sinon x = 0
		// Pour y on regarde si i > 2 --> y = 1 sinon y = 0
		
		for (int i = 0; i < 4; i++) { 						
				fonds[i] = new ImageFond((i%2)*WIDTH_IMG, ((int) i/2) *HEIGHT_IMG, "p" + String.valueOf(i) + ".png"); 
				}
		
		this.dx = 0;
		this.dy = 0;
			
		// icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.jpeg"));
		// this.imgFond1 = this.icoFond.getImage();
		icoPerso = new ImageIcon(getClass().getResource("/images/perso.png"));
		this.imgPerso = this.icoPerso.getImage();
		
		this.setFocusable(true);
		this.requestFocusInWindow();         // Pour être sûr d'avoir le focus
		this.addKeyListener(new Clavier());  // On gère ces évènements avec la classe Clavier
		
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}
	
	
	public int getDx() {return dx;}
	public void setDx(int dx) {this.dx = dx;}

	public int getDy() {return dy;}
	public void setDy(int dy) {this.dy = dy;}


	public void deplacementFond() {
		for (ImageFond imageFond : fonds) {
	        int xFond = imageFond.getxFond();
	        int yFond = imageFond.getyFond();
	        imageFond.setxFond(xFond + dx);
	        imageFond.setyFond(yFond + dy);
	        
        // PERMANENCE DE FOND
	        
	        // POUR X
	        if (imageFond.getxFond() <= - WIDTH_IMG) {                         // RECOLLEMENT A DROITE
	        	imageFond.setxFond(WIDTH_IMG); 				
	        } else if (imageFond.getxFond() >= WIDTH_IMG) {                    // RECOLLEMENT A GAUCHE
	        	imageFond.setxFond(- WIDTH_IMG);
	        }
	        
	        // POUR Y
	        if (imageFond.getyFond() <= - HEIGHT_IMG) {                         // RECOLLEMENT EN HAUT
	        	imageFond.setyFond(HEIGHT_IMG); 				
	        } else if (imageFond.getyFond() >= HEIGHT_IMG) {                    // RECOLLEMENT EN BAS
	        	imageFond.setyFond(- HEIGHT_IMG);
	        }
	    }
	}
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		// Graphics g2 = (Graphics2D)g; devrez améliorer le rendu mais voir avec et sans
		
		this.deplacementFond();
		
		//g.drawImage(this.imgFond1, this.xFond1, this.yFond1, null);
		for (ImageFond imageFond : fonds) {
            g.drawImage(imageFond.getImgFond(), imageFond.getxFond(), imageFond.getyFond(), null);
        }
		g.drawImage(this.imgPerso, (int) WIDTH_IMG/2, (int) HEIGHT_IMG/2, null);
	}
}
