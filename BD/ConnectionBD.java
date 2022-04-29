package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Calculs_Application.Joueur;

public class ConnectionBD {

	private final String serveurBD = "fimi-bd-srv1.insa-lyon.fr";
	private final String portBD = "3306";
	private final String nomBD = "DB_22_53_1";
	private final String loginBD = "U_GR53_1";
	private final String motdepasseBD = "U_GR53_1";
	private Connection connection = null;

	private PreparedStatement insertQuery = null;
	private Statement selectQuery = null;
	private PreparedStatement updateQuery = null;

	public ConnectionBD() {

		try {
			this.connexion();
			this.creerRequetesParametrees();
		} catch (Exception ex) {
			System.out.println();
			System.out.println("/!\\ Exception lors de l'exécution: " + ex.getMessage());
		}

	}

	public void connexion() throws Exception {

		try {
			String urlJDBC = "jdbc:mariadb://" + this.serveurBD + ":" + this.portBD + "/" + this.nomBD;

			System.out.println("Connexion à " + urlJDBC);
			connection = DriverManager.getConnection(urlJDBC, this.loginBD, this.motdepasseBD);
			System.out.println("Connexion établie...");

		} catch (Exception ex) {
			ex.printStackTrace(System.err);
			throw new Exception("Erreur dans la méthode connexionBD()");
		}
	}

	public void creerRequetesParametrees() throws Exception {

		try {
			//Pour l'insertion de tuples (joueurs) - réutilsée dans la méthode ajouterInfos
			this.insertQuery = this.connection.prepareStatement("INSERT INTO echec (Pseudo, Mdp, Score) VALUES (?, ?, ?)");
			
			//Pour la sélection de données - réutilisée dans la méthode classement
			this.selectQuery = this.connection.createStatement();
			
			//pour la maj du score - réutilisée dans la méthode majScore
			this.updateQuery = this.connection.prepareStatement("UPDATE echec SET Score = ?, TempsDeJeu = ? WHERE Pseudo = ?");
					
		} catch (SQLException ex) {
			ex.printStackTrace(System.err);
			throw new Exception("Erreur dans la méthode creerRequetesParametrees()");
		}
	}

	// fonction à modifier pour eviter les doublons et gérér les
	// connexions/inscription
	public int ajouterInfos(Joueur joueur) {

		try {
			if (this.onConnait(joueur.getIdentifiant())=="") { //cette condition permet de verifier si le joueur n'existe pas déjà
				this.insertQuery.setString(1, joueur.getIdentifiant());
				this.insertQuery.setString(2, joueur.getMdp());
				this.insertQuery.setDouble(3, joueur.getScore());
				System.out.println("Le joueur " + joueur.getIdentifiant() + "  a été ajouté à la base");
				return this.insertQuery.executeUpdate();
			} else {
				return -1;
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.err);
			return -1;
		}
	}

	public String classement() {
		String sortie = "";
		ResultSet results;
		String query = "SELECT Pseudo, Score FROM echec ORDER BY Score desc, Pseudo asc";
		try {
			results = selectQuery.executeQuery(query);
			while (results.next()) {
				sortie += results.getString(1) + "    score :    " + results.getInt(2) + "\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sortie;
	}

	public int majScore(String Pseudo, int score, double temps) {
		try {
			this.updateQuery.setDouble(1, ancienScore(Pseudo)+score);
			this.updateQuery.setDouble(2, ancienTemps(Pseudo)+temps);
			this.updateQuery.setString(3, Pseudo);
			System.out.println("Le score du joueur "+Pseudo+" a été mis à jour !");
			return this.updateQuery.executeUpdate();
		}
		catch (SQLException ex) {
			ex.printStackTrace(System.err);
			return -1;
		}
	}
	
	public String onConnait (String p) {
		String res = "";
		try {
			String query = "SELECT DISTINCT Mdp FROM echec WHERE Pseudo = ?";
			PreparedStatement pst = this.connection.prepareStatement(query);
			pst.setString(1, p);
			ResultSet rs = pst.executeQuery();
			if (rs.next()){
				res = rs.getString(1);
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace(System.err);
		}
		return res;
	}
	
	public int ancienScore(String pseudo) {
		int sortie =0;
		pseudo += '"';
		pseudo = '"'+pseudo;
		ResultSet results;
		String query = "SELECT Score FROM echec WHERE pseudo = "+pseudo;
		try {
			results = selectQuery.executeQuery(query);
			while (results.next()) {
				sortie += results.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sortie;
	}
	
	public int ancienTemps(String pseudo) {
		int sortie =0;
		pseudo += '"';
		pseudo = '"'+pseudo;
		ResultSet results;
		String query = "SELECT TempsDeJeu FROM echec WHERE pseudo = "+pseudo;
		try {
			results = selectQuery.executeQuery(query);
			while (results.next()) {
				sortie += results.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sortie;
	}
	

}
