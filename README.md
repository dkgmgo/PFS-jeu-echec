## ###PFS-jeu-echec###
# projet de fin de semestre jeu d'échecs



# 4 packages differents:


* package Calcul_Application: - Plateau.java classe la plus importante, contient toutes les méthodes de jeu
			      - Joueur.java objet definissant un joueur
			      - Piece.java objet definissant une piece avec ses filles (6)
                              - MonSuperBouton.java bouton dessiner avec une image grace à la redéfinition de methode

* package IHM_Fenetre: - Selection.java Contient les menus
		       - Jeu.java represente le visuel lors du déroulemnt d'une partie
		       - Dessin.java classe dont le smethodes sont en static dans le but d'alléger le code de la classe jeu
		       - MonSuperPanneau.java un panneau particulier qui en réalité est l'échiquier
		       - Victoire.java classe permettant de gerer le visuel durant les fin de partie

* package BD: - ConnectionBD.java classe permettant de se connecter et de gerer notre BD

* package IA: - MaSuperIA.java objet représentant l'IA et ses propriétés (incomplet)


# 2 dossiers "images" contenus dans les packages contenant les images utilisées dans la programmation



# un CR contenant l'UML, le Semainier et quelques explications



# un README


