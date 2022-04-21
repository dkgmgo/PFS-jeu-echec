package BD;
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
    		conn.creerRequetesParametrees(); 
    		conn.ajouterInfos(new Joueur ("cest", "moi", 0, false)); //un exemple
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
    
    public void creerRequetesParametrees() throws Exception {
    	
        try {
        	this.insertQuery = this.connection.prepareStatement("INSERT INTO echec (Pseudo, Mdp, Score) VALUES (?, ?, ?)");
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.err);
            throw new Exception("Erreur dans la méthode creerRequetesParametrees()");
        }
    }
    
    public int ajouterInfos (Joueur joueur) {
    	
    	try {
	    	this.insertQuery.setString(1, joueur.identifiant);
	    	this.insertQuery.setString(2, joueur.mdp);
	    	this.insertQuery.setDouble(3, joueur.score);
	    	System.out.println("Le joueur "+joueur.identifiant+"  a été ajouté à la base");
	    	return this.insertQuery.executeUpdate();
    	}
    	catch (SQLException ex) {
            ex.printStackTrace(System.err);
            return -1;
        }    	
    }

}
