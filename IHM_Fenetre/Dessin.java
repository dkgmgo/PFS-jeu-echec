package IHM_Fenetre;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

import Calculs_Application.Plateau;

public class Dessin {
//cette classe nous permettra de créer une instance de dessin pour reduire la taille du code de la classe jeu

	public Dessin(Plateau p, Graphics g, JPanel e) {

		// dessin du plateau
	/*	for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 != 0) {
					g.setColor(Color.darkGray);
					g.fillRect(i * 60, j * 60, 60, 60);
				} else {
					g.setColor(Color.lightGray);
					g.fillRect(i * 60, j * 60, 60, 60);
				}
			}
		}*/

		// dessin des pieces
		for (int i = 1; i < 8; i++) {
			for (int j = 1; j < 8; j++) {
				if(p.getPieces()[i][j] != null)
					e.add(p.getPieces()[i][j].getBouton());
			}
		}

		// dessin de la case selectionnée
		int[] caseSelectionnee = p.getCaseSelectionnee();
		Color rougeTrans = new Color(255, 0, 0, 128); // couleur transparente
		g.setColor(rougeTrans);
		if (caseSelectionnee[0] != -1 && caseSelectionnee[1] != -1) {
			g.fillRect(caseSelectionnee[0] * 60, caseSelectionnee[1] * 60, 60, 60);
		}

		// dessin des destinations valides
		LinkedList<int[]> destinationsValides = p.getDestinationsValides();
		Color vertTrans = new Color(0, 255, 0, 128);
		Color bleuTrans = new Color(0, 0, 255, 128);
		if (caseSelectionnee[0] != -1 && caseSelectionnee[1] != -1) { // attention !!!
			for (int[] dest : destinationsValides) {
				if (dest[2] == 0)
					g.setColor(vertTrans);
				else
					g.setColor(bleuTrans);
				g.fillRect(dest[0] * 60, dest[1] * 60, 60, 60);
			}
		}
	}
}
