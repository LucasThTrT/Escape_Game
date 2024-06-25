package com.jeu;

public class Main {
	
	public static Scene scene;  // Récupérable par les autres class via le Main

	public static void main(String[] args) {
		
		// Création de la fenetre de Jeu
		Fenetre fenetre = new Fenetre(Scene.WIDTH_IMG, Scene.HEIGHT_IMG);
		
		// Création Objet Scene
		scene = new Scene();
		
		fenetre.setContentPane(scene);  // On met le contenu de la scene dans la fenetre
		fenetre.setVisible(true);
	}

}
