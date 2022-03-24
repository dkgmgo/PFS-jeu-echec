package IHM_Fenetre;

import javax.swing.JFrame;
import javax.swing.Timer;
import Calculs_Application.Plateau;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import java.awt.Window;

public class Jeu extends JFrame implements ActionListener {
	private Plateau plateauDeJeu;
	private Dessin dessins;
	private final int TAILLE_FENETRE = 700;
	private JPanel monConteneur3;
	private JPanel echiquier;
	private JLabel affichagePseudo1;
	private JLabel affichagePseudo2;
	private JLabel tempsDeJeu1;
	private JLabel tempsDeJeu2;
	private Timer timer;
	int cptTops = 0;

	// Constructeur
	public Jeu() {
		this.setTitle("Jeu d'Echecs");
		this.setSize(TAILLE_FENETRE, TAILLE_FENETRE);
		this.setLocation(300, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		timer = new Timer(1000, this);
		plateauDeJeu = new Plateau();

		// revoir les set bounds et leur conteneurs
		tempsDeJeu1 = new JLabel("temps Jouer 2");

		tempsDeJeu2 = new JLabel("temps Joueur 2");

		affichagePseudo1 = new JLabel("joueur 1");

		affichagePseudo2 = new JLabel("joueur 2");

		// echiquier
		echiquier = new MonSuperPanneau("images/echiquier1.png");
		echiquier.setLayout(null);
		echiquier.setBounds((TAILLE_FENETRE - 480) / 2, (TAILLE_FENETRE - 480) / 2, 480, 480);
		echiquier.setBackground(Color.black);


		
		
		
		for (int i = 1; i < 8; i++) {
			for (int j = 1; j < 8; j++) {
				if(plateauDeJeu.getPieces()[i][j] != null) {
					plateauDeJeu.getPieces()[i][j].getBouton().setBounds(i*60, j*60, 60, 60);
					echiquier.add(plateauDeJeu.getPieces()[i][j].getBouton());
				}
			}
		}
		
		
		
		// finalement
		monConteneur3 = new JPanel();
		monConteneur3.setLayout(null);
		this.setContentPane(monConteneur3);
		monConteneur3.add(echiquier);
		this.setVisible(true);

		timer.start();

	}
	
	public void actionPerformed(ActionEvent e) {
		cptTops++;
		// méthode pour que les joueurs jouent en alterné
		tempsDeJeu1.setText(String.valueOf(cptTops));

	}

	public Plateau getPlateauDeJeu() {
		return plateauDeJeu;
	}
}
