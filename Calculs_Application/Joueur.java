package Calculs_Application;

import java.awt.Color;
import java.util.LinkedList;

public class Joueur {
	private String identifiant;
	private String mdp;
	private double score;
	private boolean couleur;
	private long temps;
	private LinkedList<Piece> piecesCapturees;

	public Joueur(String id, String mdp, double s, boolean b, Color couleur) {
		this.identifiant = id;
		this.mdp = mdp;
		this.score = s;
		this.couleur = (couleur == Color.white); // couleur est un boolean qui vaut true si la couleur est blanche et
													// false sinon
		LinkedList<Piece> piecesMangees = new LinkedList<Piece>();
	}

	public void capture(Piece p) {
		this.piecesCapturees.add(p);
	}

	// chaque pièce rapporte un certain nombre de points, on calcule le score avec
	// toutes les pièces capturees
	public double calculScore() {
		double s = 0;
		for (Piece p : piecesCapturees) {
			s += p.getValeur();
		}
		return s;
	}

	public LinkedList<Piece> getPiecesCapturees() {
		return piecesCapturees;
	}
}