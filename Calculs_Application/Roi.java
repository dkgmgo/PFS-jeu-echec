package Calculs_Application;

import java.util.LinkedList;

public class Roi extends Piece {

	private final int valeur = 0;
	private String img;

	public Roi(boolean c, int[] p) {
		super(c, p);
		if (this.couleur == true)
			img = "images/roiB.png";
		else
			img = "images/roiN.png";
		bouton = new MonSuperBouton(img);
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
		if (ligne > 0 && colonne > 0 && ligne < 7 && colonne < 7) {
			if (p.getPieces()[ligne + 1][colonne - 1] == null && ligne + 1 < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne + 1, colonne - 1, 0 });
			if (p.getPieces()[ligne + 1][colonne - 1] != null && (p.getPieces()[ligne + 1][colonne - 1].couleur != b))
				sortie.add(new int[] { ligne + 1, colonne - 1, 1 });
			if (p.getPieces()[ligne + 1][colonne + 1] == null && ligne + 1 < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne + 1, colonne + 1, 0 });
			if (p.getPieces()[ligne + 1][colonne + 1] != null && (p.getPieces()[ligne + 1][colonne + 1].couleur != b))
				sortie.add(new int[] { ligne + 1, colonne + 1, 1 });
			if (p.getPieces()[ligne - 1][colonne - 1] == null && ligne - 1 < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne - 1, colonne - 1, 0 });
			if (p.getPieces()[ligne - 1][colonne - 1] != null && (p.getPieces()[ligne - 1][colonne - 1].couleur != b))
				sortie.add(new int[] { ligne - 1, colonne - 1, 1 });
			if (p.getPieces()[ligne - 1][colonne + 1] == null && ligne - 1 < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne - 1, colonne + 1, 0 });
			if (p.getPieces()[ligne - 1][colonne + 1] != null && (p.getPieces()[ligne - 1][colonne + 1].couleur != b))
				sortie.add(new int[] { ligne - 1, colonne + 1, 1 });
			if (p.getPieces()[ligne + 1][colonne] == null && ligne + 1 < 8 && colonne < 8)
				sortie.add(new int[] { ligne + 1, colonne, 0 });
			if (p.getPieces()[ligne + 1][colonne] != null && (p.getPieces()[ligne + 1][colonne].couleur != b))
				sortie.add(new int[] { ligne + 1, colonne, 1 });
			if (p.getPieces()[ligne][colonne - 1] == null && ligne < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne, colonne - 1, 0 });
			if (p.getPieces()[ligne][colonne - 1] != null && (p.getPieces()[ligne][colonne - 1].couleur != b))
				sortie.add(new int[] { ligne, colonne - 1, 1 });
			if (p.getPieces()[ligne][colonne + 1] == null && ligne < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne, colonne + 1, 0 });
			if (p.getPieces()[ligne][colonne + 1] != null && (p.getPieces()[ligne][colonne + 1].couleur != b))
				sortie.add(new int[] { ligne, colonne + 1, 1 });
			if (p.getPieces()[ligne - 1][colonne] == null && ligne - 1 < 8 && colonne < 8)
				sortie.add(new int[] { ligne - 1, colonne, 0 });
			if (p.getPieces()[ligne - 1][colonne] != null && (p.getPieces()[ligne - 1][colonne].couleur != b))
				sortie.add(new int[] { ligne - 1, colonne, 1 });
		} else if (ligne == 0 && colonne == 0) {
			if (p.getPieces()[ligne + 1][colonne + 1] == null && ligne + 1 < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne + 1, colonne + 1, 0 });
			if (p.getPieces()[ligne][colonne + 1] == null && ligne < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne, colonne + 1, 0 });
			if (p.getPieces()[ligne + 1][colonne] == null && ligne + 1 < 8 && colonne < 8)
				sortie.add(new int[] { ligne + 1, colonne, 0 });
		} else if (ligne == 0 && colonne == 7) {
			if (p.getPieces()[ligne + 1][colonne - 1] == null && ligne + 1 < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne + 1, colonne - 1, 0 });
			if (p.getPieces()[ligne][colonne - 1] == null && ligne < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne, colonne - 1, 0 });
			if (p.getPieces()[ligne + 1][colonne] == null && ligne + 1 < 8 && colonne < 8)
				sortie.add(new int[] { ligne + 1, colonne, 0 });
		} else if (ligne == 7 && colonne == 0) {
			if (p.getPieces()[ligne - 1][colonne + 1] == null && ligne - 1 < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne - 1, colonne + 1, 0 });
			if (p.getPieces()[ligne][colonne + 1] == null && ligne < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne, colonne + 1, 0 });
			if (p.getPieces()[ligne - 1][colonne] == null && ligne - 1 < 8 && colonne < 8)
				sortie.add(new int[] { ligne - 1, colonne, 0 });
		} else if (ligne == 7 && colonne == 7) {
			if (p.getPieces()[ligne - 1][colonne - 1] == null && ligne - 1 < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne - 1, colonne - 1, 0 });
			if (p.getPieces()[ligne][colonne - 1] == null && ligne < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne, colonne - 1, 0 });
			if (p.getPieces()[ligne - 1][colonne] == null && ligne + 1 < 8 && colonne < 8)
				sortie.add(new int[] { ligne - 1, colonne, 0 });
		} else if (ligne == 0) {
			if (p.getPieces()[ligne + 1][colonne - 1] == null && ligne + 1 < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne + 1, colonne - 1, 0 });
			if (p.getPieces()[ligne + 1][colonne - 1] != null && (p.getPieces()[ligne + 1][colonne - 1].couleur != b))
				sortie.add(new int[] { ligne + 1, colonne - 1, 1 });
			if (p.getPieces()[ligne + 1][colonne + 1] == null && ligne + 1 < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne + 1, colonne + 1, 0 });
			if (p.getPieces()[ligne + 1][colonne + 1] != null && (p.getPieces()[ligne + 1][colonne + 1].couleur != b))
				sortie.add(new int[] { ligne + 1, colonne + 1, 1 });
			if (p.getPieces()[ligne + 1][colonne] == null && ligne + 1 < 8 && colonne < 8)
				sortie.add(new int[] { ligne + 1, colonne, 0 });
			if (p.getPieces()[ligne + 1][colonne] != null && (p.getPieces()[ligne + 1][colonne].couleur != b))
				sortie.add(new int[] { ligne + 1, colonne, 1 });
			if (p.getPieces()[ligne][colonne - 1] == null && ligne < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne, colonne - 1, 0 });
			if (p.getPieces()[ligne][colonne - 1] != null && (p.getPieces()[ligne][colonne - 1].couleur != b))
				sortie.add(new int[] { ligne, colonne - 1, 1 });
			if (p.getPieces()[ligne][colonne + 1] == null && ligne < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne, colonne + 1, 0 });
			if (p.getPieces()[ligne][colonne + 1] != null && (p.getPieces()[ligne][colonne + 1].couleur != b))
				sortie.add(new int[] { ligne, colonne + 1, 1 });
		} else if (colonne == 0) {
			if (p.getPieces()[ligne + 1][colonne + 1] == null && ligne + 1 < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne + 1, colonne + 1, 0 });
			if (p.getPieces()[ligne + 1][colonne + 1] != null && (p.getPieces()[ligne + 1][colonne + 1].couleur != b))
				sortie.add(new int[] { ligne + 1, colonne + 1, 1 });
			if (p.getPieces()[ligne - 1][colonne + 1] == null && ligne - 1 < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne - 1, colonne + 1, 0 });
			if (p.getPieces()[ligne - 1][colonne + 1] != null && (p.getPieces()[ligne - 1][colonne + 1].couleur != b))
				sortie.add(new int[] { ligne - 1, colonne + 1, 1 });
			if (p.getPieces()[ligne + 1][colonne] == null && ligne + 1 < 8 && colonne < 8)
				sortie.add(new int[] { ligne + 1, colonne, 0 });
			if (p.getPieces()[ligne + 1][colonne] != null && (p.getPieces()[ligne + 1][colonne].couleur != b))
				sortie.add(new int[] { ligne + 1, colonne, 1 });
			if (p.getPieces()[ligne][colonne + 1] == null && ligne < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne, colonne + 1, 0 });
			if (p.getPieces()[ligne][colonne + 1] != null && (p.getPieces()[ligne][colonne + 1].couleur != b))
				sortie.add(new int[] { ligne, colonne + 1, 1 });
			if (p.getPieces()[ligne - 1][colonne] == null && ligne - 1 < 8 && colonne < 8)
				sortie.add(new int[] { ligne - 1, colonne, 0 });
			if (p.getPieces()[ligne - 1][colonne] != null && (p.getPieces()[ligne - 1][colonne].couleur != b))
				sortie.add(new int[] { ligne - 1, colonne, 1 });
		} else if (ligne == 7) {
			if (p.getPieces()[ligne - 1][colonne - 1] == null && ligne - 1 < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne - 1, colonne - 1, 0 });
			if (p.getPieces()[ligne - 1][colonne - 1] != null && (p.getPieces()[ligne - 1][colonne - 1].couleur != b))
				sortie.add(new int[] { ligne - 1, colonne - 1, 1 });
			if (p.getPieces()[ligne - 1][colonne + 1] == null && ligne - 1 < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne - 1, colonne + 1, 0 });
			if (p.getPieces()[ligne - 1][colonne + 1] != null && (p.getPieces()[ligne - 1][colonne + 1].couleur != b))
				sortie.add(new int[] { ligne - 1, colonne + 1, 1 });
			if (p.getPieces()[ligne - 1][colonne] == null && ligne + 1 < 8 && colonne < 8)
				sortie.add(new int[] { ligne + 1, colonne, 0 });
			if (p.getPieces()[ligne - 1][colonne] != null && (p.getPieces()[ligne - 1][colonne].couleur != b))
				sortie.add(new int[] { ligne - 1, colonne, 1 });
			if (p.getPieces()[ligne][colonne - 1] == null && ligne < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne, colonne - 1, 0 });
			if (p.getPieces()[ligne][colonne - 1] != null && (p.getPieces()[ligne][colonne - 1].couleur != b))
				sortie.add(new int[] { ligne, colonne - 1, 1 });
			if (p.getPieces()[ligne][colonne + 1] == null && ligne < 8 && colonne + 1 < 8)
				sortie.add(new int[] { ligne, colonne + 1, 0 });
			if (p.getPieces()[ligne][colonne + 1] != null && (p.getPieces()[ligne][colonne + 1].couleur != b))
				sortie.add(new int[] { ligne, colonne + 1, 1 });
		} else if (colonne == 7) {
			if (p.getPieces()[ligne + 1][colonne - 1] == null && ligne + 1 < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne + 1, colonne - 1, 0 });
			if (p.getPieces()[ligne + 1][colonne - 1] != null && (p.getPieces()[ligne + 1][colonne - 1].couleur != b))
				sortie.add(new int[] { ligne + 1, colonne - 1, 1 });
			if (p.getPieces()[ligne - 1][colonne - 1] == null && ligne - 1 < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne - 1, colonne - 1, 0 });
			if (p.getPieces()[ligne - 1][colonne - 1] != null && (p.getPieces()[ligne - 1][colonne - 1].couleur != b))
				sortie.add(new int[] { ligne - 1, colonne - 1, 1 });
			if (p.getPieces()[ligne + 1][colonne] == null && ligne + 1 < 8 && colonne < 8)
				sortie.add(new int[] { ligne + 1, colonne, 0 });
			if (p.getPieces()[ligne + 1][colonne] != null && (p.getPieces()[ligne + 1][colonne].couleur != b))
				sortie.add(new int[] { ligne + 1, colonne, 1 });
			if (p.getPieces()[ligne][colonne - 1] == null && ligne < 8 && colonne - 1 < 8)
				sortie.add(new int[] { ligne, colonne - 1, 0 });
			if (p.getPieces()[ligne][colonne - 1] != null && (p.getPieces()[ligne][colonne - 1].couleur != b))
				sortie.add(new int[] { ligne, colonne - 1, 1 });
			if (p.getPieces()[ligne - 1][colonne] == null && ligne - 1 < 8 && colonne < 8)
				sortie.add(new int[] { ligne - 1, colonne, 0 });
			if (p.getPieces()[ligne - 1][colonne] != null && (p.getPieces()[ligne - 1][colonne].couleur != b))
				sortie.add(new int[] { ligne - 1, colonne, 1 });
		}

		LinkedList<int[]> danger = new LinkedList<int[]>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (p.getPieces()[i][j] != null) {
					if (p.getPieces()[i][j].couleur != b) {
						LinkedList<int[]> dangerParPiece = p.getPieces()[i][j].deplacement(p);
						for (int[] d : dangerParPiece)
							danger.add(d);
					}
				}
			}
		}
		for (int[] d : danger) {
			if (sortie.contains(d))
				sortie.remove(d);
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
	// prevoir mat et revoir couleurs
}