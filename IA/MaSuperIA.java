package IA;

import java.util.LinkedList;

import javax.swing.JPanel;

import Calculs_Application.Joueur;
import Calculs_Application.Piece;
import Calculs_Application.Plateau;

public class MaSuperIA extends Joueur {
	private Plateau plateau;
	private LinkedList<Piece> mesPieces = new LinkedList<Piece>();

	public MaSuperIA(Plateau p, boolean c) {
		super("IA/Bot", "", 0, c);
		this.plateau = p;
		majMesPieces();
		// attribution des valeurs des pieces selon la couleur
		// positif pour les noirs, négatif pour les blancs
	}

	public int valeurPiece(Piece p) {
		int sortie = p.getValeur();
		if (p.getCouleur() == couleur)
			return sortie;
		else
			return sortie * -1;
	}

	public void majMesPieces() {
		Piece[][] p = plateau.getPieces();
		mesPieces.clear();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (p[i][j] != null && p[i][j].getCouleur() == couleur)
					mesPieces.add(p[i][j]);
			}
		}
	}

	// faire jouer l'IA de facon aléatoire
	public void jouer(boolean tour) {
		majMesPieces();
		int i, n, x, y;
		do {
			n = mesPieces.size();
			i = (int) (Math.random() * (n-1));
			x = mesPieces.get(i).getPlacement()[0] * 60;
			y = mesPieces.get(i).getPlacement()[1] * 60;
		}while((plateau.getPieces()[x / 60][y / 60].deplacement(plateau).isEmpty()));
		plateau.clicCase(x, y, tour);
		System.out.println("ok" + x + " " + y);
		LinkedList<int[]> liste = plateau.getPieces()[x / 60][y / 60].deplacement(plateau);
		n = liste.size();
		i = (int) (Math.random() * (n-1));
		x = liste.get(i)[0] * 60;
		y = liste.get(i)[1] * 60;
		plateau.clicCase(x, y, tour);
	}
	
	public void recherche() {
		//
	}
	
	public int evaluation() {
		int sortie =0;
		//
		return sortie;
	}
	
	public void bouger() {
		//double cliCase
	}
	
	//teste tous les deplacement possibles au debut
	/*public void testTous(boolean tour, JPanel e) {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(plateau.getPieces()[i][j] != null) {
					LinkedList<int[]> liste = plateau.getPieces()[i][j].deplacement(plateau);
					if(!liste.isEmpty()) {
						for(int[] dest : liste) {
							plateau.clicCase(i*60, j*60, tour);
							plateau.clicCase(dest[0], dest[1], tour);
							e.repaint();
							plateau.clicCase(dest[0], dest[1], tour);
							plateau.clicCase(i*60, j*60, tour);
							e.repaint();
							System.out.println("ok");
						}
					}
				}
			}
		}
	}*/
}
