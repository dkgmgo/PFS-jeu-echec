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
			this.insertQuery = this.connection
					.prepareStatement("INSERT INTO echec (Pseudo, Mdp, Score) VALUES (?, ?, ?)");
			this.selectQuery = this.connection.createStatement();
		} catch (SQLException ex) {
			ex.printStackTrace(System.err);
			throw new Exception("Erreur dans la méthode creerRequetesParametrees()");
		}
	}

	// fonction à modifier pour eviter les doublons et gérér les
	// connexions/inscription
	public int ajouterInfos(Joueur joueur) {

		try {
			this.insertQuery.setString(1, joueur.getIdentifiant());
			this.insertQuery.setString(2, joueur.getMdp());
			this.insertQuery.setDouble(3, joueur.getScore());
			System.out.println("Le joueur " + joueur.getIdentifiant() + "  a été ajouté à la base");
			return this.insertQuery.executeUpdate();
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
				sortie += results.getString(1) + "  " + results.getInt(2) + "\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sortie;
	}

	public void majScore(String Pseudo, int score) {

	}
}
