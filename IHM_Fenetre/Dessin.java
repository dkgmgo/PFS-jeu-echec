package IHM_Fenetre;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

import Calculs_Application.Cavalier;
import Calculs_Application.Fou;
import Calculs_Application.Joueur;
import Calculs_Application.MonSuperBouton;
import Calculs_Application.Piece;
import Calculs_Application.Pion;
import Calculs_Application.Plateau;
import Calculs_Application.Reine;
import Calculs_Application.Tour;

public class Dessin {
	// cette classe nous permettra de reduire la taille du code de la classe jeu
	private static MonSuperBouton[] pc1;
	private static MonSuperBouton[] pc2;
	private static int[] posR = new int[2];

	public static void dessinnerPieces(Plateau p, JPanel e, MouseListener jeu) {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (p.getPieces()[i][j] != null) {
					p.getPieces()[i][j].getBouton().setBounds(i * 60, j * 60, 60, 60);
					e.add(p.getPieces()[i][j].getBouton());
				}
			}
		}
	}

	public static void redessinerPieces(Plateau p, JPanel e, MouseListener jeu, boolean tour) {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (p.getPieces()[i][j] != null) {
					p.getPieces()[i][j].getBouton().setBounds(p.getPieces()[i][j].getPlacement()[0] * 60,
							p.getPieces()[i][j].getPlacement()[1] * 60, 60, 60);
					e.add(p.getPieces()[i][j].getBouton());
					p.getPieces()[i][j].getBouton().addMouseListener(jeu);
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
		
		//dessin d'un roi en echec
		if(p.roiEnEchec()[0] != 0) {
			Color jauneTrans = new Color(255, 255, 0, 128);
			g.setColor(jauneTrans);
			if(p.roiEnEchec()[0] == 1)
				posR = p.getPosRoiAdverse(true);
			else if(p.roiEnEchec()[0] == 2)
				posR = p.getPosRoiAdverse(false);
			g.fillRect(posR[0]*60, posR[1]*60, 60, 60);
		}
	}

	public static String secToMinSec(int n) {
		String s = "";
		int sec = 0, min = 0;
		min = n / 60;
		sec = n % 60;
		if (min <= 9)
			s += "0" + min + " : ";
		else
			s += min + " : ";
		if (sec <= 9)
			s += "0" + sec;
		else
			s += sec;
		return s;
	}

	public static void initPiecesCapturees(Plateau p, JPanel g, JPanel d) {

		pc1 = new MonSuperBouton[5];
		pc2 = new MonSuperBouton[5];
		pc1[0] = new MonSuperBouton("images/pionB.png", "x 0", 20, 0 * 75 + 75, 60, 75);
		pc2[0] = new MonSuperBouton("images/pionN.png", "x 0", 20, 0 * 75 + 75, 60, 75);
		pc1[1] = (new MonSuperBouton("images/cavalierB.png", "x 0", 20, 1 * 75 + 75, 60, 75));
		pc2[1] = (new MonSuperBouton("images/cavalierN.png", "x 0", 20, 1 * 75 + 75, 60, 75));
		pc1[2] = (new MonSuperBouton("images/fouB.png", "x 0", 20, 2 * 75 + 75, 60, 75));
		pc2[2] = (new MonSuperBouton("images/fouN.png", "x 0", 20, 2 * 75 + 75, 60, 75));
		pc1[3] = (new MonSuperBouton("images/tourB.png", "x 0", 20, 3 * 75 + 75, 60, 75));
		pc2[3] = (new MonSuperBouton("images/tourN.png", "x 0", 20, 3 * 75 + 75, 60, 75));
		pc1[4] = (new MonSuperBouton("images/reineB.png", "x 0", 20, 4 * 75 + 75, 60, 75));
		pc2[4] = (new MonSuperBouton("images/reineN.png", "x 0", 20, 4 * 75 + 75, 60, 75));
		
		for (int i = 0; i < 5; i++) {
			g.add(pc1[i]);
			d.add(pc2[i]);
		}

	}

	public static void majPiecesCapturees(Plateau p) {
		int[] tab1 = p.j1.getPiecesCapturees();
		int[] tab2 = p.j2.getPiecesCapturees();
		for (int i = 0; i < 5; i++) {
			pc1[i].setTextePerso("x" + tab2[i]);
			pc1[i].repaint();
			pc2[i].setTextePerso("x" + tab1[i]);
			pc2[i].repaint();
		}
	}

}
