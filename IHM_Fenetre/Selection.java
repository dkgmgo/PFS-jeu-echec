package IHM_Fenetre;

import Calculs_Application.Plateau;
import java.util.LinkedList; 
import javax.swing.*;
import java.awt.Color;
import java.awt.event.* ;
import java.awt.* ;
import java.awt.Window;


public class Selection extends JFrame implements ActionListener {
	
	//attributs
	private String nom1 = "";
	private String nom2 = "";
	private int temps = 0;
	
	//première fenêtre 
	private JPanel menu1;
	
		//Inscription	
	private JLabel nomJoueur;
	private JLabel inscription;
	private JLabel pseudoInscription;
	private JLabel mdpInscription;
	private JTextField choixPseudoInscription;
	private JTextField choixMdpInscription;
	
		//Connexion
	private JLabel connexion;
	private JLabel pseudoConnexion;
	private JLabel mdpConnexion;
	private JTextField choixPseudoConnexion;
	private JTextField choixMdpConnexion;
	
	private JButton cestParti = new JButton ("C'est parti ! ");
	
	//deuxième fenêtre
	private JPanel menu2;
	
	private JScrollPane classement = new JScrollPane ();
	private JLabel tempsDeJeu;
	private JTextField choixTemps;
	private JLabel choixDebut;
	private JButton joueur1 ;
	private JButton joueur2 ;
	private JButton lancerPartie = new JButton ("Lancer la partie");
	
	
	public Selection (Plateau p) {
		this.setTitle("Jeu d'échecs");
		this.setSize(600,600);
		this.setLocation(300,200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			//les JLabel
		nomJoueur = new JLabel ("Joueur 1, à vous ! ");
		nomJoueur.setSize();
		nomJoueur.setLocation();
		
		inscription = new JLabel ("S'inscrire");
		inscription.setSize();
		inscription.setLocation();
		
		pseudoInscription = new JLabel ("Pseudo : ");
		pseudoInscription.setSize();
		pseudoInscription.setLocation();
		
		mdpInscription = new JLabel ("Mot de passe : ");
		mdpInscription.setSize();
		mdpInscription.setLocation();
		
		connexion = new JLabel ("Se connecter");
		connexion.setLocation();
		connexion.setLocation();
		
		pseudoConnexion = new JLabel ("Pseudo : ");
		pseudoConnexion.setSize();
		pseudoConnexion.setLocation();
		
		mdpConnexion = new JLabel ("Mot de passe : ");
		mdpConnexion.setSize();
		mdpConnexion.setLocation();
		
		tempsDeJeu = new JLabel ("Temps de jeu (en min) : ");
		tempsDeJeu.setSize();
		tempsDeJeu.setLocation();
		
		choixDebut = new JLabel ("Qui commence ? ");
		choixDebut.setSize();
		choixDebut.setLocation();
			
			//boutons
		cestParti.setBounds();
		cestParti.addActionListener (this) ;
		cestParti.setBackground();
		
		joueur1.setBounds();
		joueur1.addActionListener (this) ;
		joueur1.setBackground();
		
		joueur2.setBounds();
		joueur2.addActionListener (this) ;
		joueur2.setBackground();
		
		lancerPartie.setBounds();
		lancerPartie.addActionListener (this) ;
		lancerPartie.setBackground();
		
			//textfields
		choixPseudoInscription = new JTextField ("");
		choixPseudoInscription.setBounds();
		
		choixMdpInscription = new JTextField ("");
		choixMdpInscription.setBounds();	

		choixPseudoConnexion = new JTextField ("");
		choixPseudoConnexion.setBounds();
		
		choixMdpConnexion = new JTextField ("");
		choixMdpConnexion.setBounds();
				
		choixTemps = new JTextField ("");
		choixTemps.setBounds();
		
		//création conteneurs
			//menu1
		menu1 = new JPanel ();
		menu1.setLayout(null);
		menu1.setBounds();
		menu1.setBackground();
		
		menu1.add(nomJoueur);
		menu1.add(inscription);
		menu1.add(pseudoInscription);
		menu1.add(mdpInscription);
		menu1.add(connexion);
		menu1.add(pseudoConnexion);
		menu1.add(mdpConnexion);
		
		menu1.add(choixPseudoInscription);
		menu1.add(choixMdpInscription);
		menu1.add(choixPseudoConnexion);
		menu1.add(choixMdpConnexion);
		
		menu1.add(cestParti);
		
			//menu2
		menu2 = new JPanel ();
		menu2.setLayout(null);
		menu2.setBounds();
		menu2.setBackground();
		
		menu2.add(classement);
		menu2.add(tempsDeJeu);
		menu2.add(choixDebut);
		menu2.add(choixTemps);
		
		menu2.add(joueur1);
		menu2.add(joueur2);
		menu2.add(lancerPartie);
		menu2.setVisible(false);
		
		this.add(menu1);
		this.add(menu2);
		this.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		int i=1;
		// interaction avec le bouton cestParti pour lancer le menu pour le joueur 2 puis ensuite lancer le menu2
		//on a initialisé un entier i qui ne prend la valeur 2 que lorsque le menu pour le joueur 2 est ouvert
		
		if (e.getSource()== cestParti && i!=2){
			if (choixPseudoInscription.getText() == "") {
				nom1= choixPseudoConnexion.getText();
			} else {
				nom1= choixPseudoInscription.getText();
			}
			
			nomJoueur.setText("Joueur 2, c'est à vous ! ");
			i=2;
		}
		
		if (e.getSource()== cestParti && i==2){
			if (choixPseudoInscription.getText() == "") {
				nom2= choixPseudoConnexion.getText();
			} else {
				nom2= choixPseudoInscription.getText();
			}
			menu1.setVisible(false);
			menu2.setVisible(true);
		}
		
		temps = Integer.parseInt(choixTemps.getText());
		
		if(e.getSource()==lancerPartie) {
			menu2.setVisible(false);
		}
		
	}


	public String getNom1() {
		return nom1;
	}


	public String getNom2() {
		return nom2;
	}


	public int getTemps() {
		return temps;
	}

}