package com.jeu;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageFond {
	
	private Image imgFond;
	
	private int xFond;
	private int yFond;
	
	public ImageFond(int xFond, int yFond, String nomFond) {
		
		this.xFond = xFond;
		this.yFond = yFond;
		
		ImageIcon icoFond = new ImageIcon(getClass().getResource("/images/p1.png"));
		this.imgFond = icoFond.getImage();
		}

	// public ImageIcon getIcoFond() {return icoFond;}
    // public void setIcoFond(ImageIcon icoFond) {this.icoFond = icoFond;}

	public Image getImgFond() {return imgFond;}
	public void setImgFond(Image imgFond) {this.imgFond = imgFond;}

	public int getxFond() {return xFond;}
	public void setxFond(int xFond) {this.xFond = xFond;}

	public int getyFond() {return yFond;}
	public void setyFond(int yFond) {this.yFond = yFond;}
	
} 