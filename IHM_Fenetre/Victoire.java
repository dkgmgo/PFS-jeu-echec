package IHM_Fenetre;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BD.ConnectionBD;
import Calculs_Application.Joueur;
import Calculs_Application.Plateau;

public class Victoire extends JFrame implements ActionListener {

	private final int TAILLE_FENETRE = 700;
	private JPanel panneauPrincipal;
	private JLabel affiche;
	private JButton menu;
	private Joueur j1;
	private Joueur j2;
	private int gagnant;
	private ConnectionBD conn;
	private double temps;

	public Victoire(int gagnant, Plateau plateauDeJeu, ConnectionBD conn, double temps) {
		this.setTitle("Fin de Partie");
		this.setSize(TAILLE_FENETRE, TAILLE_FENETRE);
		this.setLocation(200, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// initialisation du panneau
		panneauPrincipal = new JPanel();
		panneauPrincipal.setLayout(null);
		panneauPrincipal.setBackground(Color.white);
		this.setContentPane(panneauPrincipal);

		// initialisation de l'image
		this.gagnant = gagnant;
		String chemin = "";
		if (gagnant == 1)
			chemin = "images/BlackWin.png";
		else if (gagnant == 2)
			chemin = "images/WhiteWin.png";
		else
			chemin = "images/Nulle.png";
		ImageIcon img = new ImageIcon(getClass().getResource(chemin));
		affiche = new JLabel(img);
		affiche.setBounds(0, 0, TAILLE_FENETRE, TAILLE_FENETRE);

		// le bouton
		menu = new JButton("Revenir au Menu de Selection");
		menu.setBounds(200, 15, 300, 50);
		menu.setBackground(Color.lightGray);
		menu.addActionListener(this);

		panneauPrincipal.add(affiche);
		panneauPrincipal.add(menu);
		this.setVisible(true);
		
		//les joueurs et la maj du score
		j1 = plateauDeJeu.j1;
		j2 = plateauDeJeu.j2;
		this.conn = conn;
		this.temps = temps;
		maj();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		Selection.setRappel(true);
	}

	public void maj() {
		if(gagnant == 2) {
			conn.majScore(j1.getIdentifiant(), j1.calculScore(j2), temps);
			conn.majScore(j2.getIdentifiant(), j1.calculScore(j2) * -1, temps);
		}
		else if(gagnant == 1) {
			conn.majScore(j2.getIdentifiant(), j2.calculScore(j1), temps);
			conn.majScore(j1.getIdentifiant(), j2.calculScore(j1) * -1, temps);
		}
		else {
			conn.majScore(j1.getIdentifiant(), 0, temps);
			conn.majScore(j2.getIdentifiant(), 0, temps);
		}
	}
}
