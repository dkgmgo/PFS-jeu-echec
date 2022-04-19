package Calculs_Application;

import java.util.LinkedList;

public class Cavalier extends Piece {

	private final int valeur = 3;
	private String img;

	public Cavalier(boolean c, int[] p) {
		super(c, p);
		if (this.couleur == true)
			img = "images/cavalierB.png";
		else
			img = "images/cavalierN.png";
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
		boolean b = p.getPieces()[ligne][colonne].couleur;
		LinkedList<int[]> sortie = new LinkedList<int[]>();

		if (ligne + 1 < 8 && colonne + 2 < 8) {
			if (p.getPieces()[ligne + 1][colonne + 2] == null && ligne + 1 < 8 && colonne + 2 < 8)
				sortie.add(new int[] { ligne + 1, colonne + 2, 0 });
			if (p.getPieces()[ligne + 1][colonne + 2] != null && (p.getPieces()[ligne + 1][colonne + 2].couleur != b))
				sortie.add(new int[] { ligne + 1, colonne + 2, 1 });
		}
		if (ligne + 2 < 8 && colonne + 1 < 8) {
			if (p.getPieces()[ligne + 2][colonne + 1] == null && ligne + 2 < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne + 2, colonne + 1, 0 });
			if (p.getPieces()[ligne + 2][colonne + 1] != null && (p.getPieces()[ligne + 2][colonne + 1].couleur != b))
				sortie.add(new int[] { ligne + 2, colonne + 1, 1 });
		}
		if (ligne - 1 >= 0 && colonne - 2 >= 0) {
			if (p.getPieces()[ligne - 1][colonne - 2] == null && ligne - 1 < 8 && colonne - 2 < 8)
				sortie.add(new int[] { ligne - 1, colonne - 2, 0 });
			if (p.getPieces()[ligne - 1][colonne - 2] != null && (p.getPieces()[ligne - 1][colonne - 2].couleur != b))
				sortie.add(new int[] { ligne - 1, colonne - 2, 1 });
		}
		if (ligne - 2 >= 0 && colonne - 1 >= 0) {
			if (p.getPieces()[ligne - 2][colonne - 1] == null && ligne - 2 < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne - 2, colonne - 1, 0 });
			if (p.getPieces()[ligne - 2][colonne - 1] != null && (p.getPieces()[ligne - 2][colonne - 1].couleur != b))
				sortie.add(new int[] { ligne - 2, colonne - 1, 1 });
		}
		if (ligne - 2 >= 0 && colonne + 1 < 8) {
			if (p.getPieces()[ligne - 2][colonne + 1] == null && ligne - 2 < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne - 2, colonne + 1, 0 });
			if (p.getPieces()[ligne - 2][colonne + 1] != null && (p.getPieces()[ligne - 2][colonne + 1].couleur != b))
				sortie.add(new int[] { ligne - 2, colonne + 1, 1 });
		}
		if (ligne + 2 < 8 && colonne - 1 >= 0) {
			if (p.getPieces()[ligne + 2][colonne - 1] == null && ligne + 2 < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne + 2, colonne - 1, 0 });
			if (p.getPieces()[ligne + 2][colonne - 1] != null && (p.getPieces()[ligne + 2][colonne - 1].couleur != b))
				sortie.add(new int[] { ligne + 2, colonne - 1, 1 });
		}
		if (ligne + 1 < 8 && colonne - 2 >= 0) {
			if (p.getPieces()[ligne + 1][colonne - 2] == null && ligne - 2 < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne + 1, colonne - 2, 0 });
			if (p.getPieces()[ligne + 1][colonne - 2] != null && (p.getPieces()[ligne + 1][colonne - 2].couleur != b))
				sortie.add(new int[] { ligne + 1, colonne - 2, 1 });
		}
		if (ligne - 1 >= 0 && colonne + 2 < 8) {
			if (p.getPieces()[ligne - 1][colonne + 2] == null && ligne - 1 < 8 && colonne + 2 < 8)
				sortie.add(new int[] { ligne - 1, colonne + 2, 0 });
			if (p.getPieces()[ligne - 1][colonne + 2] != null && (p.getPieces()[ligne - 1][colonne + 2].couleur != b))
				sortie.add(new int[] { ligne - 1, colonne + 2, 1 });
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

//le probleme le plus probable est le test couleur
}