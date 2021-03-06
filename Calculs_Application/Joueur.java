package Calculs_Application;

public class Joueur {
	private String identifiant;
	private String mdp;
	private int score;
	protected boolean couleur;
	// public int tempsRestant;
	protected int[] piecesCapturees = new int[5];

	public Joueur(String id, String mdp, int s, boolean b) {
		identifiant = id;
		this.mdp = mdp;
		score = s;
		this.couleur = b;
		for (int i = 0; i < 5; i++) {
			piecesCapturees[i] = 0;
		}
	}

	public void capture(Piece p) {
		if (p instanceof Pion)
			piecesCapturees[0]++;
		else if (p instanceof Cavalier)
			piecesCapturees[1]++;
		else if (p instanceof Fou)
			piecesCapturees[2]++;
		else if (p instanceof Tour)
			piecesCapturees[3]++;
		else if (p instanceof Reine)
			piecesCapturees[4]++;
	}

	// chaque pi?ce rapporte un certain nombre de points, on calcule le score avec
	// toutes les pi?ces capturees
	public int calculScore(Joueur adversaire) {
		int sortie = 0;
		for (int i = 0; i < 5; i++) {
			int valeur = 0;
			if (i == 0)
				valeur = 1;
			else if (i == 1)
				valeur = 3;
			else if (i == 2)
				valeur = 3;
			else if (i == 3)
				valeur = 5;
			else if (i == 4)
				valeur = 9;
			sortie += adversaire.piecesCapturees[i] * valeur;
		}
		sortie = 39 - sortie;
		return sortie;
	}

	public int[] getPiecesCapturees() {
		return piecesCapturees;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}