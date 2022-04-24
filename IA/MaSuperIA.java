package IA;

import Calculs_Application.Joueur;
import Calculs_Application.Piece;
import Calculs_Application.Plateau;

public class MaSuperIA extends Joueur{
	private Plateau plateau;
	
	public MaSuperIA(Plateau p, boolean c) {
		super("IA/Bot", "", 0, c);
		this.plateau = p;
		//attribution des valeurs des pieces selon la couleur
		//positif pour les noirs, négatif pour les blancs
	}
	
	public int valeurPiece(Piece p) {
		int sortie = p.getValeur(); 
		if(p.getCouleur() == couleur)
			return sortie;
		else
			return sortie * -1;
	}
}
