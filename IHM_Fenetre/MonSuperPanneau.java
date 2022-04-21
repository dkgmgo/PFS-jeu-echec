package IHM_Fenetre;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Calculs_Application.Plateau;

//cette classe est faite principalement pour pouvoir dessiner dans su l'echiquier qui est un panneau elle l'initialise aussi.
public class MonSuperPanneau extends JPanel {
	private Image image = null;
	private Plateau p;

	public MonSuperPanneau(String chemin, int TAILLE_FENETRE, Jeu j) { // plateau
		super();
		this.image = getImage(chemin);
		this.setLayout(null);
		this.setBounds((TAILLE_FENETRE - 480) / 2, (TAILLE_FENETRE - 480) / 2, 480, 480);
		this.setBackground(null);
		p = j.getPlateauDeJeu();
	}

	public MonSuperPanneau(int TAILLE_FENETRE, Jeu j) {// plateau sans image
		super();
		this.setLayout(null);
		this.setBounds((TAILLE_FENETRE - 480) / 2, (TAILLE_FENETRE - 480) / 2, 480, 480);
		this.setBackground(null);
		p = j.getPlateauDeJeu();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, this);
		} else {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if ((i + j) % 2 != 0) {
						g.setColor(Color.darkGray);
						g.fillRect(i * 60, j * 60, 60, 60);
					} else {
						g.setColor(Color.lightGray);
						g.fillRect(i * 60, j * 60, 60, 60);
					}
				}
			}
		}
	}

	public Image getImage(String chemin) {
		Image i = null;
		try {
			i = ImageIO.read(getClass().getResource(chemin));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}

	public void paint(Graphics g) {
		super.paint(g);
		// dessin de la case selectionnée
		Dessin.dessinnerCases(p, g);
	}
}
