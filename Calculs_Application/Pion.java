package Calculs_Application;

import java.util.LinkedList;

public class Pion extends Piece {

	private final int valeur = 1;

	public Pion(boolean c, int[] p) {
		super(c, p);
		if (this.couleur == true)
			img = "images/pionB.png";
		else
			img = "images/pionN.png";
		bouton = new MonSuperBouton(img, placement[0], placement[1]);
	}

	/*
	 * @param p, le plateau tout entier
	 * 
	 * c'est une serie de tests qui donne les deplacements de la piece en général et
	 * si il y'a capture
	 */
	public LinkedList<int[]> deplacement(Plateau p) {
		int ligne = placement[0], colonne = placement[1];

		LinkedList<int[]> sortie = new LinkedList<int[]>();
		boolean b = p.getPieces()[ligne][colonne].couleur;
		if (b) {
			if ( colonne == 6 && p.getPieces()[ligne][colonne - 2] == null && p.getPieces()[ligne][colonne - 1] == null)
					sortie.add(new int[] { ligne, colonne - 2, 0 });
			if (ligne >= 0 && colonne > 0 && ligne <= 7 && colonne <= 7) {
				if (p.getPieces()[ligne][colonne - 1] == null && ligne < 8 && colonne - 1 < 8)
					sortie.add(new int[] { ligne, colonne - 1, 0 });
				if (ligne != 0 && p.getPieces()[ligne - 1][colonne - 1] != null
						&& (p.getPieces()[ligne - 1][colonne - 1].couleur != b))
					sortie.add(new int[] { ligne - 1, colonne - 1, 1 });
				if (ligne != 7 && p.getPieces()[ligne + 1][colonne - 1] != null
						&& (p.getPieces()[ligne + 1][colonne - 1].couleur != b)) 
					sortie.add(new int[] { ligne + 1, colonne - 1, 1 });
			}
		} else {
			if (colonne == 1 && p.getPieces()[ligne][colonne + 2] == null && p.getPieces()[ligne][colonne + 1] == null)
					sortie.add(new int[] { ligne, colonne + 2, 0 });
			if (ligne >= 0 && colonne >= 0 && ligne <= 7 && colonne < 7) {
				if (p.getPieces()[ligne][colonne + 1] == null && ligne < 8 && colonne + 1 < 8)
					sortie.add(new int[] { ligne, colonne + 1, 0 });
				if (ligne != 7 && p.getPieces()[ligne + 1][colonne + 1] != null
						&& (p.getPieces()[ligne + 1][colonne + 1].couleur != b))
					sortie.add(new int[] { ligne + 1, colonne + 1, 1 });
				if (ligne != 0 && p.getPieces()[ligne - 1][colonne + 1] != null
						&& (p.getPieces()[ligne - 1][colonne + 1].couleur != b))
					sortie.add(new int[] { ligne - 1, colonne + 1, 1 });
			}
		}
		return sortie;
	}
	
	public String getImg () {
		return img;
	}
	
	public int getValeur() {
		return valeur;
	}

	public void setPlacement(int[] placement) {
		this.placement = placement;
	}

	public MonSuperBouton getBouton() {
		return bouton;
	}

	// prevoir les promotions, et aussi la gestion des couleur
}