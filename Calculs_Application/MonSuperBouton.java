package Calculs_Application;
/* Cette classe a pour but de charger les images et les assimiler à des boutons pour nous permettre de faire appel à Actionlistener 
 * dans la partie Fenetre. J'hesite beaucoup d'ailleurs à l'associer à cette partie mais pour le moment, la compter comme parametre
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
		this.setIcon(img); // pensez à g.drawImage() si ca marche pas
		this.setBorder(null); // pour la beauté
		this.setContentAreaFilled(false);
	}

	/*
	 * @param chemin, chemin d'acces au fichier image il est de la forme
	 * "images/pieceCouleur"
	 * 
	 * @param texte, texte à coté du bouton (par exemple pour les pieces capturées)
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
