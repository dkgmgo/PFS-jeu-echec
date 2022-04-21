package IHM_Fenetre;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Calculs_Application.Joueur;


public class Selection extends JFrame implements ActionListener{
	
	//attributs
	private String nom1 = "";
	private String nom2 = "";
	private String mdp1 = "";
	private String mdp2 = "";
	
	boolean b2 = false;
	private int temps;
	public int commencer = -1;

	//premiere fenetre 
	private JPanel menu1;
	private JPanel cadre1;
	private JPanel cadre2;
	private JPanel cadre3;
	
		//Inscription	
	private JLabel nomJoueur;
	private JLabel inscription = new JLabel ("S'INSCRIRE");
	private JLabel pseudoInscription;
	private JLabel mdpInscription;
	private JTextField choixPseudoInscription;
	private JTextField choixMdpInscription;
	
		//Connexion
	private JLabel connexion = new JLabel ("SE CONNECTER");
	private JLabel pseudoConnexion;
	private JLabel mdpConnexion;
	private JTextField choixPseudoConnexion;
	private JTextField choixMdpConnexion;
	
	private JButton cestParti = new JButton ("C'est parti ! ");
	
	//deuxieme fenetre
	private JPanel menu2;
	
	private JScrollPane classement = new JScrollPane ();
	private JLabel tempsDeJeu;
	private JTextField choixTemps;
	private JLabel choixDebut;
	private JButton joueur1= new JButton ("") ;
	private JButton joueur2 = new JButton ("");
	private JButton lancerPartie = new JButton ("Lancer la partie");
	
	//le jeu
	private Jeu j;
	
	//gestion des fin de partie avec un retour au menu de selection
	private static boolean rappelSelection = false;
	private Timer check;
	
	
	//constructeur
	public Selection () {
		this.setTitle("Jeu d'echecs");
		this.setSize(600,600);
		this.setLocation(300,200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		check = new Timer(3000, this); // on regarde toutes les 3 secondes si il faut revenir au menu de s�lection
		
		cadre1 = new JPanel();
		//cadre1.setOpaque(false);
		cadre1.setSize(170, 230);
		cadre1.setLocation(90, 130);
		cadre1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		cadre1.setBackground(new Color (255,183,152));
		
		cadre3 = new JPanel();
		//cadre3.setOpaque(false);
		cadre3.setSize(300, 160);
		cadre3.setLocation(250,180);
		cadre3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		cadre3.setBackground(new Color (172,255,255));
		
		joueur1.setBounds(280, 250, 110, 50);
		joueur1.addActionListener (this) ;
		
		joueur2.setBounds(420, 250, 110, 50);
		
		cadre2 = new JPanel();
		//cadre2.setOpaque(false);
		cadre2.setSize(170, 230);
		cadre2.setLocation(340, 130);
		cadre2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		cadre2.setBackground(new Color (255,183,152));
		
			//les JLabel
		nomJoueur = new JLabel ("JOUEUR 1, C'EST A VOUS ! ", SwingConstants.CENTER);
		nomJoueur.setFont(new Font("Arial", Font.BOLD, 20));
		nomJoueur.setSize(400, 30);
		nomJoueur.setLocation(90, 30);
		 
		inscription.setSize(100,50);
		inscription.setLocation(100, 120);
		
		pseudoInscription = new JLabel ("Pseudo : ");
		pseudoInscription.setSize(100, 30);
		pseudoInscription.setLocation(100, 160);
		
		mdpInscription = new JLabel ("Mot de passe : ");
		mdpInscription.setSize(130, 30);
		mdpInscription.setLocation(100, 260);
	
		connexion.setSize(100, 50);
		connexion.setLocation(350, 120);
		
		pseudoConnexion = new JLabel ("Pseudo : ");
		pseudoConnexion.setSize(100, 30);
		pseudoConnexion.setLocation(350, 160);
		
		mdpConnexion = new JLabel ("Mot de passe : ");
		mdpConnexion.setSize(130, 30);
		mdpConnexion.setLocation(350, 260);
		
		tempsDeJeu = new JLabel ("TEMPS MAXIMUM (en min) : ");
		tempsDeJeu.setSize(200, 50);
		tempsDeJeu.setLocation(250, 95);
		
		choixDebut = new JLabel ("QUI COMMENCE ? ", SwingConstants.CENTER);
		choixDebut.setSize(300, 50);
		choixDebut.setLocation(260, 200);
			
			//boutons
		cestParti.setBounds(200, 450, 200, 50);
		cestParti.addActionListener (this);
		
		joueur1.setBounds(280, 250, 110, 50);
		joueur1.addActionListener (this) ;
		
		joueur2.setBounds(420, 250, 110, 50);
		joueur2.addActionListener (this) ;
		
		lancerPartie.setBounds(310, 380, 200, 70);
		lancerPartie.addActionListener (this);
		lancerPartie.setBackground(new Color (154,255,255));
		
			//textfields
		choixPseudoInscription = new JTextField ("");
		choixPseudoInscription.setBounds(100, 190, 150, 60);
		
		choixMdpInscription = new JTextField ("");
		choixMdpInscription.setBounds(100, 290, 150, 60);	

		choixPseudoConnexion = new JTextField ("");
		choixPseudoConnexion.setBounds(350, 190, 150, 60);
		
		choixMdpConnexion = new JTextField ("");
		choixMdpConnexion.setBounds(350, 290, 150, 60);
				
		choixTemps = new JTextField ("");
		choixTemps.setBounds(430, 100, 90, 50);
		
		classement.setBounds(30, 100, 200, 400);
		classement.setBorder(BorderFactory.createTitledBorder("Classement : " ));
		classement.setBorder(BorderFactory.createTitledBorder("Classement : " ));
		
		
		//creation conteneurs
			//menu1
		menu1 = new JPanel ();
		menu1.setLayout(null);
		menu1.setSize(600, 600);
		menu1.setBackground(new Color (255,204,153));
		

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
		

		menu1.add(cadre1);
		menu1.add(cadre2);
		
		menu1.add(cestParti);
		
			//menu2
		menu2 = new JPanel ();
		menu2.setLayout(null);
		menu2.setSize(600, 600);
		
		menu2.add(classement);
		menu2.add(tempsDeJeu);
		menu2.add(choixDebut);
		menu2.add(choixTemps);
		
		menu2.add(joueur1);
		menu2.add(joueur2);
		menu2.add(lancerPartie);
		
		menu2.add(cadre3);
		menu2.setBackground(new Color (204,255,255));
		menu2.setVisible(false);
		
		this.add(menu1);
		this.add(menu2);
		check.start();
		this.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		
		// interaction avec le bouton cestParti pour lancer le menu1 pour le joueur 2 puis ensuite lancer le menu2
		//on a initialise un boolean b2 qui ne prend la valeur true que lorsque le menu1 pour le joueur 2 est ouvert
		//a ce moment la lorsqu'on r√©appuiera sur le bouton cestParti, c'est le menu2 qui s'ouvrira
		
		if (e.getSource()== cestParti && b2==false){
			
			//on stocke les noms des joueurs dans les attributs nom1 et nom2, pour pouvoir les utiliser dans les autres fen√™tres
			
			if (choixPseudoInscription.getText().isEmpty() && !choixPseudoConnexion.getText().isEmpty()) {
				nom1= choixPseudoConnexion.getText();
				mdp1=choixMdpConnexion.getText();
				nomJoueur.setText("Joueur 2, c'est a vous ! ");
				nomJoueur.setFont(new Font("Serif", Font.BOLD, 20));
				nomJoueur.setSize(400, 30);
				nomJoueur.setLocation(90, 10);
				 
				b2=true;
			} else if (choixPseudoConnexion.getText().isEmpty() && !choixPseudoInscription.getText().isEmpty()) {
				nom1= choixPseudoInscription.getText();
				mdp1=choixMdpInscription.getText();
				nomJoueur.setText("JOUEUR 2, C'EST A VOUS ! ");		
				nomJoueur.setFont(new Font("Arial",Font.BOLD, 20));
				nomJoueur.setSize(400, 30);
				nomJoueur.setLocation(90, 30);
				 
				b2=true;
			} else {
				JOptionPane.showMessageDialog(this,"Veuillez entrer un pseudo");
				mdp1="1";
			}
			
			
			choixPseudoInscription.setText("");
			choixPseudoConnexion.setText("");
			choixMdpInscription.setText("");
			choixMdpConnexion.setText("");
			
			menu1.repaint();
			
		}  else if (e.getSource()== cestParti && b2==true){
			
			if (choixPseudoInscription.getText().isEmpty() && !choixPseudoConnexion.getText().isEmpty()) {
				nom2= choixPseudoConnexion.getText();
				mdp2=choixMdpConnexion.getText();
				menu1.setVisible(false);
				menu2.setVisible(true);
			} else if (choixPseudoConnexion.getText().isEmpty() && !choixPseudoInscription.getText().isEmpty()) {
				nom2= choixPseudoInscription.getText();
				mdp2=choixMdpInscription.getText();
				menu1.setVisible(false);
				menu2.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this,"Veuillez entrer un pseudo");
				mdp2="2";
			}
			
		} 
		
		joueur1.setText(this.nom1);
		joueur2.setText(this.nom2);
		
		//choix du joueur qui commence (si rien blancs)
		if (e.getSource()==joueur1) {
			commencer = 1;		//c'est le joueur 1 qui commence
		} else if (e.getSource()==joueur2) {
			commencer = 0;		// joueur 2 commence
		}
		
		//stockage de la donnÈe temps dans une variable si elle est donnÈe par le joueur. Sinon, temps = 60 min
		if (!choixTemps.getText().equals("")) {
			temps = Integer.valueOf(choixTemps.getText());
		} else {
			temps = 60;
		}
		
		
		if(e.getSource()==lancerPartie) {
			j = new Jeu(nom1, nom2, temps*30, commencer);
			menu2.setVisible(false);
			j.setVisible(true);
		}
		
		if(e.getSource() == check) {
			if(rappelSelection) {
				menu2.setVisible(true);
			}
		}
	}


	public String getNom1() {
		return nom1;
	}


	public String getNom2() {
		return nom2;
	}

	public static void setRappel(boolean b) {
		rappelSelection = b;
	}
}
