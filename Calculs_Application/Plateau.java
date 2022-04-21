package Calculs_Application;

import java.util.LinkedList;

import IA.MaSuperIA;

public class Plateau {

	// initialisation attributs du plateau
	private Piece[][] pieces = new Piece[8][8];
	private int[] caseSelectionnee = new int[2];
	private LinkedList<int[]> destinationsValides = new LinkedList<int[]>();
	private int ligne = 0, colonne = 0;
	public Joueur j1;
	public Joueur j2;
	public boolean gameWithAI = false;

	/*
	 * ici on va fonctionner avec 2 constructeurs, un pour les tests et un réel
	 * 
	 * aucun parametres
	 */
	// test

	/*
	 * public Plateau() { pieces[2][2] = new Fou(false, new int[] { 2, 2 });
	 * pieces[4][2] = new Cavalier(false, new int[] { 4, 2 }); pieces[4][4] = new
	 * Tour(true, new int[] { 4, 4 }); pieces[1][3] = new Pion(true, new int[] { 1,
	 * 3 }); pieces[5][2] = new Reine(true, new int[] { 5, 2 }); pieces[4][3] = new
	 * Roi(false, new int[] { 4, 3 }); caseSelectionnee[0] = -1; caseSelectionnee[1]
	 * = -1; j1 = new Joueur("nom1", "mdp1", 0, true); j2 = new Joueur("nom2",
	 * "mdp2", 0, false); }
	 */

	// réel
	public Plateau() {// tester grande boucle //pions
		for (int i = 0; i < 8; i++) {
			pieces[i][1] = new Pion(false, new int[] { i, 1 });
			pieces[i][6] = new Pion(true, new int[] { i, 6 }); // rois et reines
			pieces[3][0] = new Reine(false, new int[] { 3, 0 });
			pieces[3][7] = new Reine(true, new int[] { 3, 7 });
			pieces[4][0] = new Roi(false, new int[] { 4, 0 });
			pieces[4][7] = new Roi(true, new int[] { 4, 7 }); // le reste
		}
		for (int i = 0; i < 2; i++) {
			int a;
			boolean b;
			if (i == 0) {
				a = 0;
				b = false;
			} else {
				a = 7;
				b = true;
			}
			pieces[1][a] = new Cavalier(b, new int[] { 1, a });
			pieces[6][a] = new Cavalier(b, new int[] { 6, a });
			pieces[2][a] = new Fou(b, new int[] { 2, a });
			pieces[5][a] = new Fou(b, new int[] { 5, a });
			pieces[0][a] = new Tour(b, new int[] { 0, a });
			pieces[7][a] = new Tour(b, new int[] { 7, a });
		}
		caseSelectionnee[0] = -1;
		caseSelectionnee[1] = -1;

		if (!gameWithAI)
			j1 = new Joueur("nom1", "mdp1", 0, true);
		else
			j1 = new MaSuperIA(this, true);
		j2 = new Joueur("nom2", "mdp2", 0, false);
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
	public void clicCase(int abs, int ord, boolean tour) {
		if (caseSelectionnee[0] == -1 && caseSelectionnee[1] == -1 && pieces[abs / 60][ord / 60] != null
				&& peutBouger(abs / 60, ord / 60, tour)) { // selection
			caseSelectionnee = quelleCase(abs, ord);
			ligne = quelleCase(abs, ord)[0];
			colonne = quelleCase(abs, ord)[1];
			destinationsValides = pieces[caseSelectionnee[0]][caseSelectionnee[1]].deplacement(this);
		} else if (pieces[abs / 60][ord / 60] == null) { // deplacement simple
			caseSelectionnee = quelleCase(abs, ord);
			for (int[] dest : destinationsValides) {
				if (dest[0] == caseSelectionnee[0] && (dest[1] == caseSelectionnee[1])) {
					bouger();
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

		if (j1.couleur == pieces[caseSelectionnee[0]][caseSelectionnee[1]].couleur) {
			j2.capture(pieces[caseSelectionnee[0]][caseSelectionnee[1]]);
		} else {
			j1.capture(pieces[caseSelectionnee[0]][caseSelectionnee[1]]);
		}

		pieces[caseSelectionnee[0]][caseSelectionnee[1]].bouton.setImage(null);
		if (p instanceof Fou) {
			pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Fou(p.couleur,
					new int[] { caseSelectionnee[0], caseSelectionnee[1] });
		} else if (p instanceof Pion) { // cas de la promotion inclu
			if ((p.couleur == false && caseSelectionnee[1] == 7) || (p.couleur == true && caseSelectionnee[1] == 0)) {
				pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Reine(p.couleur,
						new int[] { caseSelectionnee[0], caseSelectionnee[1] });
			} else {
				pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Pion(p.couleur,
						new int[] { caseSelectionnee[0], caseSelectionnee[1] });
			}
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

		// pour la capture (on remplit la liste pieceCapturees de chaque joueur en
		// fonction des captures effectuées)

		// remettre la boucle

		pieces[ligne][colonne].bouton.setImage(null);
		pieces[ligne][colonne] = null;
	}

	public void bouger() {
		Piece p = pieces[ligne][colonne];
		if (p instanceof Fou) {
			pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Fou(p.couleur,
					new int[] { caseSelectionnee[0], caseSelectionnee[1] });
		} else if (p instanceof Pion) { // cas de la promotion inclu
			if ((p.couleur == false && caseSelectionnee[1] == 7) || (p.couleur == true && caseSelectionnee[1] == 0)) {
				pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Reine(p.couleur,
						new int[] { caseSelectionnee[0], caseSelectionnee[1] });
			} else {
				pieces[caseSelectionnee[0]][caseSelectionnee[1]] = new Pion(p.couleur,
						new int[] { caseSelectionnee[0], caseSelectionnee[1] });
			}
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

		pieces[ligne][colonne].bouton.setImage(null);
		pieces[ligne][colonne] = null;
	}

	public int[] roiEnEchec() {// renvoi 1 si le roi noir est en echec et 2 si c'est le roi blanc qui est en
								// echec et en plus on la position du joueur qui met le roi en echec
		int[] sortie = new int[3];
		sortie[0] = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (pieces[i][j] != null) {
					int[] pos = getPosRoiAdverse(pieces[i][j].couleur);
					for (int[] dest : pieces[i][j].deplacement(this)) {
						if (dest[0] == pos[0] && dest[1] == pos[1]) {
							if (pieces[pos[0]][pos[1]].couleur)
								sortie[0] = 2;
							else
								sortie[0] = 1;
							sortie[1] = pieces[i][j].getPlacement()[0];
							sortie[2] = pieces[i][j].getPlacement()[1];
							break;
						}
					}
				}
				if (sortie[0] != 0)
					break;
			}
			if (sortie[0] != 0)
				break;
		}
		return sortie;
		// dessiner le roi mater avec une couleur differente (jaune)
	}

	public int[] getPosRoiAdverse(boolean couleur) {// recupere la position du roi adverse à une piece en temps réel
		int[] sortie = null;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (pieces[i][j] != null && pieces[i][j].couleur != couleur && pieces[i][j] instanceof Roi) {
					sortie = pieces[i][j].placement;
					break;
				}
			}
			if (sortie != null)
				break;
		}
		return sortie;
	}

	public boolean roiOutOfmoves(boolean couleur) { // verifie si un roi peut encore se deplacer prend sa couleur en
													// parametre
		boolean sortie = false;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (pieces[i][j] != null && pieces[i][j] instanceof Roi && pieces[i][j].couleur == couleur) {
					sortie = pieces[i][j].deplacement(this).isEmpty();
					break;
				}
			}
		}
		return sortie;
	}

	public int echecEtMat() {
		// **faire une liste de piec pouvant proteger le roi, la remplir et faire teste
		// d'apartenance dans clic case
		// **condition**
		// le roi est en echec --> roiEnEchec()
		// le roi ne peut plus se deplacer --> roiOutOfMoves()

		// test
		if (roiEnEchec()[0] == 1 && roiOutOfmoves(false))
			return 1;
		if (roiEnEchec()[0] == 2 && roiOutOfmoves(true))
			return 2;
		return 0;
	}

	public void roque() {
		// **dessiner cet case avec une couleur differente pour la repérer (violet)
		// **condition**
		// le roi n'est pas en echec --> roiEnEchec()
		// le roi n'a pas bouger
		// la tour n'a pas bouger
		// le roi n'est pas en echec
		// l'espace entre la tour et le roi est vide
		// l'espace entre le roi et la tour n'est pas prenable par l'adversaire

	}

	// methode à completer
	public boolean peutBouger(int x, int y, boolean tour) { // rempli la liste des pieces autorisée à bougé et verifie
															// si la piece en parametre fais partie de cette liste
		LinkedList<int[]> piecesPouvantBouger = new LinkedList<int[]>();
		if (pieces[x][y].couleur != tour) // si c'est pas ton tour de jeu tu peux pas bouger
			return false;

		// une piece doit protéger son roi
		if ((roiEnEchec()[0] == 1 && tour == false) || ((roiEnEchec()[0] == 2 && tour == true))) {
			// si c'est ton tour mais ton roi est en echec
			piecesPouvantBouger.add(getPosRoiAdverse(!tour));
			// verdict pour la position en parametre
			return contientPos(piecesPouvantBouger, x, y);
		}

		// si on arrive à ce point alors toutes les pieces peuvent bouger
		return true;
	}

	public boolean contientPos(LinkedList<int[]> liste, int x, int y) {
		boolean sortie = false;
		for (int[] pos : liste) {
			if (pos[0] == x && pos[1] == y)
				return true;
		}
		return sortie;
	}
}
