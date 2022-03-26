package Calculs_Application;

import java.util.LinkedList;

public class Plateau {

	// initialisation attributs du plateau
	private Piece[][] pieces = new Piece[8][8];
	private int[] caseSelectionnee = new int[2];
	private LinkedList<int[]> destinationsValides = new LinkedList<int[]>();
	private int ligne = 0, colonne = 0;

	/*
	 * ici on va fonctionner avec 2 constructeurs, un pour les tests et un réel
	 * 
	 * aucun parametres
	 */
	// test
	public Plateau() {
		pieces[2][2] = new Fou(false, new int[] { 2, 2 });
		pieces[4][2] = new Cavalier(false, new int[] { 4, 2 });
		pieces[4][4] = new Tour(true, new int[] { 4, 4 });
		pieces[1][3] = new Pion(true, new int[] { 1, 3 });
		pieces[5][2] = new Reine(true, new int[] { 5, 2 });
		pieces[4][3] = new Roi(false, new int[] { 4, 3 });
		caseSelectionnee[0] = -1;
		caseSelectionnee[1] = -1;
	}
	// réel

	/*
	 * public Plateau() {//tester grande boucle //pions for (int i = 0; i < 8; i++)
	 * { pieces[i][1] = new Pion(false, new int[] { i, 1 }); pieces[i][6] = new
	 * Pion(true, new int[] { i, 6 }); } // rois et reines pieces[3][0] = new
	 * Reine(false,new int[] {3,0}); pieces[3][7] = new Reine(true, new int[]
	 * {3,7}); pieces[4][0] = new Roi(false, new int[] {4,0}); pieces[4][7] = new
	 * Roi(true, new int[] {4,7}); //le reste for (int i = 0; i < 2; i++) { int a;
	 * boolean b; if (i == 0) { a = 0; b = false; } else { a = 7; b = true; }
	 * pieces[0][a] = new Cavalier(b, new int [] {0,a}); pieces[7][a] = new
	 * Cavalier(b, new int [] {7,a}); pieces[1][a] = new Fou(b, new int [] {1, a});
	 * pieces[6][a] = new Fou(b, new int [] {6, a}); pieces[2][a] = new Tour(b, new
	 * int[] {2, a}); pieces[5][a] = new Tour(b, new int[] {5, a}); }
	 * caseSelectionnee[0] = -1; caseSelectionnee[1] = -1; }
	 */

	public LinkedList<Piece> pieceMangee(Joueur j) {
		return j.getPiecesCapturees();
	}

	public void clicCaseClavier() {

	}

	public int[] quelleCase(int abs, int ord) {
		int[] sortie = new int[2];
		sortie[0] = abs / 60;
		sortie[1] = ord / 60;
		return sortie;
	}

	/*
	 * @param abs, ord les coordonnées du pointeur de la souris
	 * 
	 * grace à cette fonction on sait si il y'a selection, capture, ou deplacement
	 * methode sensible à bien voir et tester le cas avec ligne et colonne et faire
	 * la reflexivité si ca bouge pas
	 */
	public void clicCase(int abs, int ord) {
		if (caseSelectionnee[0] == -1 && caseSelectionnee[1] == -1 && pieces[abs / 60][ord / 60] != null) { // selection
			caseSelectionnee = quelleCase(abs, ord);
			ligne = quelleCase(abs, ord)[0];
			colonne = quelleCase(abs, ord)[1];
			destinationsValides = pieces[caseSelectionnee[0]][caseSelectionnee[1]].deplacement(this);
		} else if (pieces[abs / 60][ord / 60] == null) { // deplacement simple
			caseSelectionnee = quelleCase(abs, ord);
			for (int[] dest : destinationsValides) {
				if (dest[0] == caseSelectionnee[0] && (dest[1] == caseSelectionnee[1])) {
					System.out.println("ok");
					bouger();
					pieces[ligne][colonne].bouton.setImage(null);
					pieces[ligne][colonne] = null;
				}
			}
			destinationsValides.clear();
			caseSelectionnee[0] = -1;
			caseSelectionnee[1] = -1;
		} else if (pieces[abs / 60][ord / 60] != null) { // capture !!
			caseSelectionnee = quelleCase(abs, ord);
			for (int[] dest : destinationsValides) {
				if (dest[0] == caseSelectionnee[0] && (dest[1] == caseSelectionnee[1])) {
					capturer();
					pieces[ligne][colonne].bouton.setImage(null);
					pieces[ligne][colonne] = null;
				}
			}
			destinationsValides.clear();
			caseSelectionnee[0] = -1;
			caseSelectionnee[1] = -1;
		} else if (caseSelectionnee[0] != -1 || caseSelectionnee[1] != -1) { // deselection
			caseSelectionnee[0] = -1;
			caseSelectionnee[1] = -1;
			destinationsValides.clear();
		}
	}

	public Piece[][] getPieces() {
		return pieces;
	}

	public int[] getCaseSelectionnee() {
		return caseSelectionnee;
	}

	public LinkedList<int[]> getDestinationsValides() {
		return destinationsValides;
	}

	public void capturer() {
		Piece p = pieces[ligne][colonne];
		pieces[caseSelectionnee[0]][caseSelectionnee[1]].bouton.setImage(null);
		if (p instanceof Fou) {
			pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Fou(p.couleur,
					new int[] { caseSelectionnee[0], caseSelectionnee[1] });
		} else if (p instanceof Pion) {
			pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Pion(p.couleur,
					new int[] { caseSelectionnee[0], caseSelectionnee[1] });
		} else if (p instanceof Cavalier) {
			pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Cavalier(p.couleur,
					new int[] { caseSelectionnee[0], caseSelectionnee[1] });
		} else if (p instanceof Tour) {
			pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Tour(p.couleur,
					new int[] { caseSelectionnee[0], caseSelectionnee[1] });
		} else if (p instanceof Roi) {
			pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Roi(p.couleur,
					new int[] { caseSelectionnee[0], caseSelectionnee[1] });
		} else if (p instanceof Reine) {
			pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Reine(p.couleur,
					new int[] { caseSelectionnee[0], caseSelectionnee[1] });
		}
	}

	public void bouger() {
		Piece p = pieces[ligne][colonne];
		if(pieces[caseSelectionnee[0]][caseSelectionnee[1]]!=null) {
			pieces[caseSelectionnee[0]][caseSelectionnee[1]].bouton.setImage(null);
		}
		if (p instanceof Fou) {
			pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Fou(p.couleur,
					new int[] { caseSelectionnee[0], caseSelectionnee[1] });
		} else if (p instanceof Pion) {
			pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Pion(p.couleur,
					new int[] { caseSelectionnee[0], caseSelectionnee[1] });
		} else if (p instanceof Cavalier) {

			pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Cavalier(p.couleur,
					new int[] { caseSelectionnee[0], caseSelectionnee[1] });
		} else if (p instanceof Tour) {
			pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Tour(p.couleur,
					new int[] { caseSelectionnee[0], caseSelectionnee[1] });
		} else if (p instanceof Roi) {
			pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Roi(p.couleur,
					new int[] { caseSelectionnee[0], caseSelectionnee[1] });
		} else if (p instanceof Reine) {
			pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Reine(p.couleur,
					new int[] { caseSelectionnee[0], caseSelectionnee[1] });
		}
	}
}
