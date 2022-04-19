package Calculs_Application;

import java.util.LinkedList;

public class Roi extends Piece {

	private final int valeur = 200;
	private String img;

	public Roi(boolean c, int[] p) {
		super(c, p);
		if (this.couleur == true)
			img = "images/roiB.png";
		else
			img = "images/roiN.png";
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
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(p.getPieces()[i][j] != null) {
					if(p.getPieces()[i][j].couleur  != b) {
						if(p.getPieces()[i][j] instanceof Pion) {
							LinkedList<int[]> a0 = p.getPieces()[i][j].deplacement(p);
							for(int[] dest : a0) {
								if(dest[2] == 1)
								danger.add(dest);
							}
						}
						if(p.getPieces()[i][j] instanceof Cavalier) {
							LinkedList<int[]> a1 = p.getPieces()[i][j].deplacement(p);
							for(int[] dest : a1) {
								danger.add(dest);
							}
						}
						if(p.getPieces()[i][j] instanceof Fou) {
							LinkedList<int[]> a2 = p.getPieces()[i][j].deplacement(p);
							for(int[] dest : a2) {
								danger.add(dest);
							}
						}
						if(p.getPieces()[i][j] instanceof Tour) {
							LinkedList<int[]> a3 = p.getPieces()[i][j].deplacement(p);
							for(int[] dest : a3) {
								danger.add(dest);
							}
						}
						if(p.getPieces()[i][j] instanceof Reine) {
							LinkedList<int[]> a4 = p.getPieces()[i][j].deplacement(p);
							for(int[] dest : a4) {
								danger.add(dest);
							}
						}
					}
				}
			}
		}
		
		boolean b1;
		for(int i=0; i<danger.size(); i++) {
			b1 = false;
			for(int j=0; j<sortie.size(); j++) {
				if(danger.get(i)[0] == sortie.get(j)[0] && danger.get(i)[1] == sortie.get(j)[1]) {
					sortie.remove(j);
					b1 = true;
					break;
				}
			}
			if(b1)
				continue;
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
	// prevoir mat et revoir couleurs
}