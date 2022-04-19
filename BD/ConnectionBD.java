package BD;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBD {
	
	private final String serveurBD = "172.20.10.2";
    private final String portBD = "3306";
    private final String nomBD = "echec";
    private final String loginBD = "root";
    private final String motdepasseBD = "1234";
    
    public static void main(String[] args) {
    	
    	ConnectionBD conn = new ConnectionBD ();
    	
    	try {
    		conn.connexion();
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
            Connection connection = DriverManager.getConnection(urlJDBC, this.loginBD, this.motdepasseBD);
            System.out.println("Connexion établie...");
            
        }
        catch (Exception ex) {
            ex.printStackTrace(System.err);
            throw new Exception("Erreur dans la méthode connexionBD()");
        }

    }
    
    public void ecrireFichier(String cheminVersDossier) throws Exception {
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
    }

}
