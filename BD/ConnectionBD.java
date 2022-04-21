package BD;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Calculs_Application.Joueur;


public class ConnectionBD {
	
	private final String serveurBD = "fimi-bd-srv1.insa-lyon.fr";
    private final String portBD = "3306";
    private final String nomBD = "DB_22_53_1";
    private final String loginBD = "U_GR53_1";
    private final String motdepasseBD = "U_GR53_1";
    private Connection connection = null ;
    
    private PreparedStatement insertQuery = null;
    
    public static void main(String[] args) {
    	
    	ConnectionBD conn = new ConnectionBD ();
    	
    	try {
    		conn.connexion();
    		conn.creerRequetesParametrees(new Joueur ("i", "m", 0, false)); //un exemple
    		//conn.ecrireFichier("C:\\Users\\Mounir\\Desktop\\fichiers");
    	}
    	catch (Exception ex) {
    		System.out.println();
    		System.out.println("/!\\ Exception lors de l'exécution: " + ex.getMessage());
    	}

  
    }
    
    public void connexion() throws Exception {

        try {
        	String urlJDBC = "jdbc:mariadb://" +this.serveurBD + ":" + this.portBD + "/" + this.nomBD;

            System.out.println("Connexion à " + urlJDBC);
            connection = DriverManager.getConnection(urlJDBC, this.loginBD, this.motdepasseBD);
            System.out.println("Connexion établie...");
            
        }
        catch (Exception ex) {
            ex.printStackTrace(System.err);
            throw new Exception("Erreur dans la méthode connexionBD()");
        }

    }
    
    public int creerRequetesParametrees(Joueur joueur) throws Exception {
        try {
        	this.insertQuery = this.connection.prepareStatement("INSERT INTO echec VALUES (joueur.identifiant, joueur.mdp, joueur.score, joueur.tempsDeJeu)");
        	System.out.println("Joueur "+joueur+" a été ajouté à la base");
        	return this.insertQuery.executeUpdate(); 
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.err);
            throw new Exception("Erreur dans la méthode creerRequetesParametrees()");
        }
    }

    
    /*public void ecrireFichier(String cheminVersDossier) throws Exception {
        try {
        	String nomFichier = "donneesJoueur";
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream (cheminVersDossier + "/" + nomFichier)));
            writer.print("nom joueur 1 : ");
            writer.close();
        } 
        catch (Exception ex) {
            ex.printStackTrace(System.err);
            throw new Exception("Erreur dans la méthode ecrireFichier()");
        }
    }*/

}
