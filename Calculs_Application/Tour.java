package Calculs_Application;

import java.util.LinkedList;

public class Tour extends Piece {

	private final int valeur = 5;
	private String img;

	public Tour(boolean c, int[] p) {
		super(c, p);
		if (this.couleur == true)
			img = "images/tourB.png";
		else
			img = "images/tourN.png";
		bouton = new MonSuperBouton(img, placement[0], placement[1]); 
	}

	public LinkedList<int[]> deplacement(Plateau p) {
		int ligne = placement[0], colonne = placement[1];
		LinkedList<int[]> sortie = new LinkedList<int[]>();
		boolean b = p.getPieces()[ligne][colonne].couleur;
		for (int i = 1; i < 8; i++) {
			if (ligne + i < 8) {
				if (p.getPieces()[ligne + i][colonne] == null && ligne + i < 8 && colonne < 8)
					sortie.add(new int[] { ligne + i, colonne, 0 });
				if (p.getPieces()[ligne + i][colonne] != null && (p.getPieces()[ligne + i][colonne].couleur != b)) {
					sortie.add(new int[] { ligne + i, colonne, 1 });
					break;
				}
				if (p.getPieces()[ligne + i][colonne] != null && (p.getPieces()[ligne + i][colonne].couleur == b))
					break;
			}
		}
		for (int i = 1; i < 8; i++) {
			if (ligne - i >= 0) {
				if (p.getPieces()[ligne - i][colonne] == null && ligne - i < 8 && colonne < 8)
					sortie.add(new int[] { ligne - i, colonne, 0 });
				if (p.getPieces()[ligne - i][colonne] != null && (p.getPieces()[ligne - i][colonne].couleur != b)) {
					sortie.add(new int[] { ligne - i, colonne, 1 });
					break;
				}
				if (p.getPieces()[ligne - i][colonne] != null && (p.getPieces()[ligne - i][colonne].couleur == b))
					break;
			}
		}
		for (int i = 1; i < 8; i++) {
			if (colonne + i < 8) {
				if (p.getPieces()[ligne][colonne + i] == null && ligne < 8 && colonne + i < 8)
					sortie.add(new int[] { ligne, colonne + i, 0 });
				if (p.getPieces()[ligne][colonne + i] != null && (p.getPieces()[ligne][colonne + i].couleur != b)) {
					sortie.add(new int[] { ligne, colonne + i, 1 });
					break;
				}
				if (p.getPieces()[ligne][colonne + i] != null && (p.getPieces()[ligne][colonne + i].couleur == b))
					break;
			}
		}
		for (int i = 1; i < 8; i++) {
			if (colonne - i >= 0) {
				if (p.getPieces()[ligne][colonne - i] == null && ligne < 8 && colonne < 8)
					sortie.add(new int[] { ligne, colonne - i, 0 });
				if (p.getPieces()[ligne][colonne - i] != null && (p.getPieces()[ligne][colonne - i].couleur != b)) {
					sortie.add(new int[] { ligne, colonne - i, 1 });
					break;
				}
				if (p.getPieces()[ligne][colonne - i] != null && (p.getPieces()[ligne][colonne - i].couleur == b))
					break;
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
}