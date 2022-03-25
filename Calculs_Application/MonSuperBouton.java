package Calculs_Application;
/* Cette classe a pour but de charger les images et les assimiler � des boutons pour nous permettre de faire appel � Actionlistener 
 * dans la partie Fenetre. J'hesite beaucoup d'ailleurs � l'associer � cette partie mais pour le moment, la compter comme parametre
 * d'une piece facilitera son ajout dans la fenetre de jeu avec un "panel.add()"
 * */

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MonSuperBouton extends JButton {

	/*
	 * @param chemin, chemin d'acces au fichier image il est de la forme
	 * "images/pieceCouleur" instance un super bouton
	 */
	public MonSuperBouton(String chemin) {
		super();
		ImageIcon img = getImage(chemin);
		this.setIcon(img); // pensez � g.drawImage() si ca marche pas
		this.setBorder(null); // pour la beaut�
		this.setContentAreaFilled(false);
	}

	/*
	 * @param chemin, chemin d'acces au fichier image il est de la forme
	 * "images/pieceCouleur"
	 * 
	 * @param texte, texte � cot� du bouton (par exemple pour les pieces captur�es)
	 * 
	 */
	public MonSuperBouton(String chemin, String texte) {
		super();
		ImageIcon img = getImage(chemin);
		this.setIcon(img);
		this.setText(texte);
		this.setBorder(null);
		this.setContentAreaFilled(false);
	}

	public ImageIcon getImage(String chemin) {
		Image i = null;
		try {
			i = ImageIO.read(getClass().getResource(chemin));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon img = new ImageIcon(i);
		return img;
	}
}
