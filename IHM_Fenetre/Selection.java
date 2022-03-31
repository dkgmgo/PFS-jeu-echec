package IHM_Fenetre;

import java.awt.Color;
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


public class Selection extends JFrame implements ActionListener{
	
	//attributs
	private String nom1 = "";
	private String nom2 = "";
	private int temps = 0;
	boolean b2 = false;

	//premiere fenetre 
	private JPanel menu1;
	
		//Inscription	
	private JLabel nomJoueur;
	private JLabel inscription = new JLabel ("S'inscrire");
	private JLabel pseudoInscription;
	private JLabel mdpInscription;
	private JTextField choixPseudoInscription;
	private JTextField choixMdpInscription;
	
		//Connexion
	private JLabel connexion = new JLabel ("Se connecter");
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
	
	
	public Selection () {
		this.setTitle("Jeu d'echecs");
		this.setSize(600,600);
		this.setLocation(300,200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			//les JLabel
		nomJoueur = new JLabel ("Joueur 1, c'est a vous ! ");
		nomJoueur.setSize(190, 30);
		nomJoueur.setLocation(260, 10);
		 
		inscription.setSize(100,50);
		inscription.setLocation(100, 100);
		inscription.setBackground(Color.red);
		
		pseudoInscription = new JLabel ("Pseudo : ");
		pseudoInscription.setSize(100, 30);
		pseudoInscription.setLocation(100, 160);
		
		mdpInscription = new JLabel ("Mot de passe : ");
		mdpInscription.setSize(130, 30);
		mdpInscription.setLocation(100, 260);
	
		connexion.setSize(100, 50);
		connexion.setLocation(350, 100);
		connexion.setBackground(Color.red);
		
		pseudoConnexion = new JLabel ("Pseudo : ");
		pseudoConnexion.setSize(100, 30);
		pseudoConnexion.setLocation(350, 160);
		
		mdpConnexion = new JLabel ("Mot de passe : ");
		mdpConnexion.setSize(130, 30);
		mdpConnexion.setLocation(350, 260);
		
		tempsDeJeu = new JLabel ("Temps de jeu (en min) : ");
		tempsDeJeu.setSize(200, 50);
		tempsDeJeu.setLocation(220, 100);
		
		choixDebut = new JLabel ("Qui commence ? ");
		choixDebut.setSize(150, 50);
		choixDebut.setLocation(300, 230);
			
			//boutons
		cestParti.setBounds(200, 450, 200, 50);
		cestParti.addActionListener (this) ;
		cestParti.setBackground(Color.RED);
		
		joueur1.setBounds(280, 300, 110, 50);
		joueur1.addActionListener (this) ;
		joueur1.setBackground(Color.yellow);
		
		joueur2.setBounds(420, 300, 110, 50);
		joueur2.addActionListener (this) ;
		joueur2.setBackground(Color.yellow);
		
		lancerPartie.setBounds(310, 380, 200, 70);
		lancerPartie.addActionListener (this) ;
		lancerPartie.setBackground(Color.RED);
		
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
		
		classement.setBounds(30, 100, 150, 400);
		classement.setBorder(BorderFactory.createTitledBorder("Classement : " ));
		classement.setBorder(BorderFactory.createTitledBorder("Classement : " ));
		
		
		//creation conteneurs
			//menu1
		menu1 = new JPanel ();
		menu1.setLayout(null);
		menu1.setSize(600, 600);
		menu1.setBackground(Color.yellow);
		
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
		menu2.setSize(600, 600);
		menu2.setBackground(Color.WHITE);
		
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
		
		// interaction avec le bouton cestParti pour lancer le menu1 pour le joueur 2 puis ensuite lancer le menu2
		//on a initialise un boolean b2 qui ne prend la valeur true que lorsque le menu1 pour le joueur 2 est ouvert
		//a ce moment la lorsqu'on réappuiera sur le bouton cestParti, c'est le menu2 qui s'ouvrira
		
		if (e.getSource()== cestParti && b2==false){
			
			//on stocke les noms des joueurs dans les attributs nom1 et nom2, pour pouvoir les utiliser dans les autres fenêtres
			
			if (choixPseudoInscription.getText().isEmpty() && !choixPseudoConnexion.getText().isEmpty()) {
				nom1= choixPseudoConnexion.getText();
				nomJoueur.setText("Joueur 2, c'est a vous ! ");
				b2=true;
			} else if (choixPseudoConnexion.getText().isEmpty() && !choixPseudoInscription.getText().isEmpty()) {
				nom1= choixPseudoInscription.getText();
				nomJoueur.setText("Joueur 2, c'est a vous ! ");
				b2=true;
			} else {
				JOptionPane.showMessageDialog(this,"Veuillez entrer un pseudo");
			}
			
			
			choixPseudoInscription.setText("");
			choixPseudoConnexion.setText("");
			choixMdpInscription.setText("");
			choixMdpConnexion.setText("");
			
			menu1.repaint();
			
		}  else if (e.getSource()== cestParti && b2==true){
			
			if (choixPseudoInscription.getText().isEmpty() && !choixPseudoConnexion.getText().isEmpty()) {
				nom2= choixPseudoConnexion.getText();
				menu1.setVisible(false);
				menu2.setVisible(true);
			} else if (choixPseudoConnexion.getText().isEmpty() && !choixPseudoInscription.getText().isEmpty()) {
				nom2= choixPseudoInscription.getText();
				menu1.setVisible(false);
				menu2.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this,"Veuillez entrer un pseudo");
			}
			
		} 
		
		joueur1.setText(this.nom1);
		joueur2.setText(this.nom2);
		
		if(e.getSource()==lancerPartie) {
			temps = Integer.valueOf(choixTemps.getText());
			menu2.setVisible(false);
			j = new Jeu(nom1, nom2, temps);
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
