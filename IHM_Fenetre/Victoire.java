package IHM_Fenetre;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Calculs_Application.Roi;

public class Victoire extends JFrame{
	
	private final int TAILLE_FENETRE = 300;
	private JPanel victoireBlanc;
	private JPanel victoireNoir;
	private JPanel panneauPrincipal;

	
	public Victoire() {
		this.setTitle("Victoire !");
		this.setSize(TAILLE_FENETRE, TAILLE_FENETRE);
		this.setLocation(200, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panneauPrincipal = new JPanel(); //récupéré de Jeu mais à modif
		panneauPrincipal.setLayout(null);
		panneauPrincipal.setBackground(new Color(200, 150, 120));
		this.setContentPane(panneauPrincipal);
		
		victoireBlanc = new MonSuperPanneau("BlackWin.png", TAILLE_FENETRE, this);
		victoireNoir = new MonSuperPanneau("WhiteWin.png", TAILLE_FENETRE, this);
		
		panneauPrincipal.add(victoireBlanc);
		panneauPrincipal.add(victoireNoir);
		
	public void afficherMessageVictoire() {
		if(Roi.roiEnEchec()==1) { //victoire des blancs ; c'est pas Roi qu'il faut mettre mais quoi ?
			victoireBlanc.setVisible(true);
			else if () // compléter : si victoire des blancs, si compteur des noirs finit, si compteur des blancs finit
		}
	}
		
	