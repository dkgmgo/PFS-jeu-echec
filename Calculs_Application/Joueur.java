package Calculs_Application;

import java.awt.Color;
import java.util.LinkedList;

public class Joueur {
	protected String identifiant;
	protected String mdp;
	protected double score;
	protected boolean couleur;
	//public int tempsRestant;
	protected int[] piecesCapturees = new int[5];

	public Joueur(String id, String mdp, double s, boolean b) {
		this.identifiant = id;
		this.mdp = mdp;
		this.score = s;
		this.couleur = b; // couleur est un boolean qui vaut true si la couleur est noire et
													// false sinon
		for(int i =0;i<5; i++) {
			piecesCapturees[i] =0;
		}
	}

	public void capture(Piece p) {
		if(p instanceof Pion)
			piecesCapturees[0]++;
		else if(p instanceof Cavalier)
			piecesCapturees[1]++;
		else if(p instanceof Fou)
			piecesCapturees[2]++;
		else if(p instanceof Tour)
			piecesCapturees[3]++;
		else if(p instanceof Reine)
			piecesCapturees[4]++;
	}

	// chaque pièce rapporte un certain nombre de points, on calcule le score avec
	// toutes les pièces capturees
	public double calculScore() {
		int sortie  = 0;
		for(int i =0; i<5; i++) {
			int valeur = 0;
			if(i == 0)
				valeur = 1;
			else if(i == 1)
				valeur = 3;
			else if(i == 2)
				valeur = 3;
			else if(i == 3)
				valeur = 5;
			else if(i == 4)
				valeur = 9;
			sortie += piecesCapturees[i] * valeur;
		}
		return sortie;
	}

	public int[] getPiecesCapturees() {
		return piecesCapturees;
	}
}