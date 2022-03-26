package IHM_Fenetre;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JPanel;

import Calculs_Application.Plateau;

public class Dessin {
//cette classe nous permettra de reduire la taille du code de la classe jeu

	
	public static void dessinnerPieces(Plateau p, JPanel e, MouseListener jeu) {

		for (int i = 1; i < 8; i++) {
			for (int j = 1; j < 8; j++) {
				if (p.getPieces()[i][j] != null) {
					p.getPieces()[i][j].getBouton().setBounds(i * 60, j * 60, 60, 60);
					e.add(p.getPieces()[i][j].getBouton());
					p.getPieces()[i][j].getBouton().addMouseListener(jeu);
				}
			}
		}
	}
	
	public static void redessinerPieces(Plateau p, JPanel e) {
		for (int i = 1; i < 8; i++) {
			for (int j = 1; j < 8; j++) {
				if (p.getPieces()[i][j] != null) {
					p.getPieces()[i][j].getBouton().setBounds(p.getPieces()[i][j].getPlacement()[0] * 60, p.getPieces()[i][j].getPlacement()[1] * 60, 60, 60);
					e.add(p.getPieces()[i][j].getBouton());
					p.getPieces()[i][j].getBouton().repaint();
				}		
			}
		}
	}

	
	public static void dessinnerCases(Plateau p, Graphics g) {
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
