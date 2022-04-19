package Calculs_Application;

import java.util.LinkedList;

public abstract class Piece {
	protected boolean couleur;
	protected MonSuperBouton bouton;
	protected int[] placement;
	protected String img;

	public Piece(boolean c, int[] p) {
		this.couleur = c;
		if (p[0] >= 0 && p[0] <= 7 && p[1] >= 0 && p[1] <= 7)
			this.placement = p;
	}

	public boolean getCouleur() {
		return this.couleur;
	}

	public int[] getPlacement() {
		return placement;
	}

	public abstract LinkedList<int[]> deplacement(Plateau p);

	public abstract int getValeur();

	public abstract void setPlacement(int[] placement);

	public abstract MonSuperBouton getBouton();
}
