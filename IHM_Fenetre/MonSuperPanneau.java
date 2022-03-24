package IHM_Fenetre;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Calculs_Application.Plateau;

public class MonSuperPanneau extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image = null;

	public MonSuperPanneau(String chemin)
	{
		super();
	    this.image = getImage(chemin);
	    
	}


	public void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    if (image != null)
	    {
	        g.drawImage(image,0,0,this);
	    }
	}
	
	public Image getImage(String chemin) {
		Image i = null;
		try {
			i = ImageIO.read(getClass().getResource(chemin));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
}
