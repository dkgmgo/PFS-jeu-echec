package IHM_Fenetre;

import javax.swing.JFrame;
import javax.swing.Timer;
import Calculs_Application.Plateau;
import java.util.LinkedList;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Jeu extends JFrame implements ActionListener, MouseListener {
	private Plateau plateauDeJeu;
	private Dessin dessins;
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
	private JButton time1;
	private JButton time2;
	private Timer timer;
	private int cptTops = 0;

	// Constructeur
	public Jeu() {
		this.setTitle("Jeu d'Echec");
		this.setSize(TAILLE_FENETRE, TAILLE_FENETRE);
		this.setLocation(300, 50);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		timer = new Timer(1000, this);

		// initialisation du plateau
		plateauDeJeu = new Plateau();

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

		// droite

		// joueurs ce code peut etre simplifié avec de smethodes static dans dessin
		pseudo1 = new JLabel("joueur 1");
		pseudo1.setBounds(0, 85, 100, 20);
		haut.add(pseudo1);

		pseudo2 = new JLabel("joueur 2");
		pseudo2.setBounds(0, 0, 100, 20);
		bas.add(pseudo2);

		temps1 = new JLabel("temps Joueur 1");
		temps1.setBounds(300, 85, 100, 20);
		haut.add(temps1);

		temps2 = new JLabel("temps Joueur 2");
		temps2.setBounds(300, 0, 100, 20);
		bas.add(temps2);

		time1 = new JButton("Finaliser");
		time1.setBounds(100, 85, 100, 20);
		haut.add(time1);

		time2 = new JButton("Finaliser");
		time2.setBounds(105, 5, 100, 20);
		bas.add(time2);

		// ajout des pieces à l'échiquier
		Dessin.dessinnerPieces(plateauDeJeu, echiquier, this);

		// finalement
		panneauPrincipal.add(echiquier);
		panneauPrincipal.add(bas);
		panneauPrincipal.add(haut);
		timer.start();
		this.setVisible(true);
	}

	public Plateau getPlateauDeJeu() {
		return plateauDeJeu;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			cptTops++;
			Dessin.redessinerPieces(plateauDeJeu);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = echiquier.getMousePosition().x;
		int y = echiquier.getMousePosition().y;
		plateauDeJeu.clicCase(x, y);
		echiquier.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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
}
