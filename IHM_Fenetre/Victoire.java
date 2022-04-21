package IHM_Fenetre;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Victoire extends JFrame implements ActionListener {

	private final int TAILLE_FENETRE = 700;
	private JPanel panneauPrincipal;
	private JLabel affiche;
	private JButton menu;

	public Victoire(int gagnant) {
		this.setTitle("Fin de Partie");
		this.setSize(TAILLE_FENETRE, TAILLE_FENETRE);
		this.setLocation(200, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// initialisation du panneau
		panneauPrincipal = new JPanel();
		panneauPrincipal.setLayout(null);
		this.setContentPane(panneauPrincipal);

		// initialisation de l'image
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		Selection.setRappel(true);
	}
}
