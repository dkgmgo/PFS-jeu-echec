package IHM_Fenetre;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import BD.ConnectionBD;
import Calculs_Application.Plateau;

public class Jeu extends JFrame implements ActionListener, MouseListener {
	private Plateau plateauDeJeu;
	private final int TAILLE_FENETRE = 700;
	private JPanel panneauPrincipal;
	private JPanel echiquier;
	private JPanel haut;
	private JPanel bas;
	private JPanel gauche;
	private JPanel droite;
	private JLabel pseudo1;
	private JLabel pseudo2;
	private JLabel temps1;
	private JLabel temps2;
	public JButton time1;
	public JButton time2;
	private Timer affichage;
	private Timer gestionTemps;
	private int cptTops1 = 0;
	private int cptTops2 = 0;
	private int tempsEnSec = 0;
	public boolean tour;
	private Victoire finDePartie;

	// Constructeur
	public Jeu(String nom1, String mdp1, String nom2, String mdp2, int t, int c, ConnectionBD connection) {
		this.setTitle("Jeu d'Echec");
		this.setSize(TAILLE_FENETRE, TAILLE_FENETRE);
		this.setLocation(300, 50);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//le temps
		affichage = new Timer(100, this);
		gestionTemps = new Timer(1000, this);
		tempsEnSec = t;
		if (c == 1)
			tour = false;
		else if (c == -1 || c == 0)
			tour = true;

		// initialisation du plateau
		plateauDeJeu = new Plateau(nom1, mdp1, nom2, mdp2);
		
		//ajout des nouveaux joueurs
		connection.ajouterInfos(plateauDeJeu.j1);
		connection.ajouterInfos(plateauDeJeu.j2);
		

		// les panneaux
		
		// principal
		panneauPrincipal = new JPanel();
		panneauPrincipal.setLayout(null);
		panneauPrincipal.setBackground(new Color(200, 150, 120));
		this.setContentPane(panneauPrincipal);

		// echiquier
		echiquier = new MonSuperPanneau("images/echiquier1.png", TAILLE_FENETRE, this);
		echiquier.addMouseListener(this);

		// haut
		haut = new JPanel();
		haut.setLayout(null);
		haut.setBackground(null);
		haut.setBounds((TAILLE_FENETRE - 480) / 2, 0, 480, (TAILLE_FENETRE - 480) / 2);

		// bas
		bas = new JPanel();
		bas.setLayout(null);
		bas.setBackground(null);
		bas.setBounds((TAILLE_FENETRE - 480) / 2, (TAILLE_FENETRE - 480) / 2 + 480, 480, (TAILLE_FENETRE - 480) / 2);

		// gauche
		gauche = new JPanel();
		gauche.setLayout(null);
		gauche.setBackground(null);
		gauche.setBounds(0, 0, (TAILLE_FENETRE - 480) / 2, TAILLE_FENETRE);

		// droite
		droite = new JPanel();
		droite.setLayout(null);
		droite.setBackground(null);
		droite.setBounds(590, 0, (TAILLE_FENETRE - 480) / 2, TAILLE_FENETRE);

		// joueurs ce code peut etre simplifié avec de smethodes static dans dessin
		pseudo1 = new JLabel(nom1);
		pseudo1.setBounds(0, 85, 100, 20);
		haut.add(pseudo1);

		pseudo2 = new JLabel(nom2);
		pseudo2.setBounds(0, 0, 100, 20);
		bas.add(pseudo2);

		temps1 = new JLabel("");
		temps1.setBounds(250, 85, 200, 20);
		haut.add(temps1);

		temps2 = new JLabel("");
		temps2.setBounds(250, 0, 200, 20);
		bas.add(temps2);

		time1 = new JButton("Finaliser");
		time1.setBounds(100, 85, 100, 20);
		time1.addActionListener(this);
		haut.add(time1);

		time2 = new JButton("Finaliser");
		time2.setBounds(105, 5, 100, 20);
		time2.addActionListener(this);
		bas.add(time2);

		// initialisations venant de dessin
		Dessin.dessinnerPieces(plateauDeJeu, echiquier, this);
		Dessin.initPiecesCapturees(plateauDeJeu, gauche, droite);

		// finalement
		panneauPrincipal.add(echiquier);
		panneauPrincipal.add(bas);
		panneauPrincipal.add(haut);
		panneauPrincipal.add(gauche);
		panneauPrincipal.add(droite);
		affichage.start();
		gestionTemps.start();
	}

	public Plateau getPlateauDeJeu() {
		return plateauDeJeu;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == time1) {
			tour = true;
		}
		if (e.getSource() == time2) {
			tour = false;
		}

		if (e.getSource() == gestionTemps) {
			if (!tour)
				cptTops1++;
			else
				cptTops2++;
		}

		if (e.getSource() == affichage) {
			Dessin.redessinerPieces(plateauDeJeu, echiquier, this, tour);
			Dessin.majPiecesCapturees(plateauDeJeu);
			afficherTemps();
			// plateauDeJeu.echecEtMat();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = echiquier.getMousePosition().x;
		int y = echiquier.getMousePosition().y;
		plateauDeJeu.clicCase(x, y, tour);
		echiquier.repaint();
		if (plateauDeJeu.echecEtMat() == 1) {
			finDePartie = new Victoire(2);
			this.setVisible(false);
		} else if (plateauDeJeu.echecEtMat() == 2) {
			finDePartie = new Victoire(1);
			this.setVisible(false);
		} else if (plateauDeJeu.partieNulle()) {
			finDePartie = new Victoire(0);
			this.setVisible(false);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void afficherTemps() {
		int t1 = tempsEnSec - cptTops1;
		int t2 = tempsEnSec - cptTops2;
		String s1 = "Temps Restant : " + Dessin.secToMinSec(t1);
		String s2 = "Temps Restant : " + Dessin.secToMinSec(t2);
		temps1.setText(s1);
		temps2.setText(s2);
	}
}
