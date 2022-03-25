package Calculs_Application;

import java.util.LinkedList;

public class Fou extends Piece {

	private final int valeur = 3;
	private String img;

	public Fou(boolean c, int[] p) {
		super(c, p);
		if (this.couleur == true)
			img = "images/fouB.png";
		else
			img = "images/fouN.png";
		bouton = new MonSuperBouton(img);
	}

	public LinkedList<int[]> deplacement(Plateau p) {
		int ligne = placement[0], colonne = placement[1];
		LinkedList<int[]> sortie = new LinkedList<int[]>();
		boolean b = p.getPieces()[ligne][colonne].couleur;
		for (int i = 1; i < 8; i++) {
			if (ligne + i < 8 && colonne + i < 8) {
				if (p.getPieces()[ligne + i][colonne + i] == null && ligne + i < 8 && colonne + i < 8)
					sortie.add(new int[] { ligne + i, colonne + i, 0 });
				if (p.getPieces()[ligne + i][colonne + i] != null
						&& (p.getPieces()[ligne + i][colonne + i].couleur != b)) {
					sortie.add(new int[] { ligne + i, colonne + i, 1 });
					break;
				}
				if (p.getPieces()[ligne + i][colonne + i] != null
						&& (p.getPieces()[ligne + i][colonne + i].couleur == b))
					break;
			}
		}
		for (int i = 1; i < 8; i++) {
			if (ligne - i >= 0 && colonne - i >= 0) {
				if (p.getPieces()[ligne - i][colonne - i] == null && ligne - i < 8 && colonne - i < 8)
					sortie.add(new int[] { ligne - i, colonne - i, 0 });
				if (p.getPieces()[ligne - i][colonne - i] != null
						&& (p.getPieces()[ligne - i][colonne - i].couleur != b)) {
					sortie.add(new int[] { ligne - i, colonne - i, 1 });
					break;
				}
				if (p.getPieces()[ligne - i][colonne - i] != null
						&& (p.getPieces()[ligne - i][colonne - i].couleur == b))
					break;
			}
		}
		for (int i = 1; i < 8; i++) {
			if (ligne - i >= 0 && colonne + i < 8) {
				if (p.getPieces()[ligne - i][colonne + i] == null && ligne - i < 8 && colonne + i < 8)
					sortie.add(new int[] { ligne - i, colonne + i, 0 });
				if (p.getPieces()[ligne - i][colonne + i] != null
						&& (p.getPieces()[ligne - i][colonne + i].couleur != b)) {
					sortie.add(new int[] { ligne - i, colonne + i, 1 });
					break;
				}
				if (p.getPieces()[ligne - i][colonne + i] != null
						&& (p.getPieces()[ligne - i][colonne + i].couleur == b))
					break;
			}
		}
		for (int i = 1; i < 8; i++) {
			if (ligne + i < 8 && colonne - i >= 0) {
				if (p.getPieces()[ligne + i][colonne - i] == null && ligne + i < 8 && colonne - i < 8)
					sortie.add(new int[] { ligne + i, colonne - i, 0 });
				if (p.getPieces()[ligne + i][colonne - i] != null
						&& (p.getPieces()[ligne + i][colonne - i].couleur != b)) {
					sortie.add(new int[] { ligne + i, colonne - i, 1 });
					break;
				}
				if (p.getPieces()[ligne + i][colonne - i] != null
						&& (p.getPieces()[ligne + i][colonne - i].couleur == b))
					break;
			}
		}
		return sortie;
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

}