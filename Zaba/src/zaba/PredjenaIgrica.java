package zaba;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class PredjenaIgrica {
	public PredjenaIgrica(){
		
	}
//Iscrtava sliku koja se pojavljuje na kraju igrice ukoliko predjete sve nivoe
	public void slikaj(Graphics g){
		g.drawImage(slika, 0, 0, 800, 600, null);
	}
	
	Image slika = Toolkit.getDefaultToolkit().getImage("krajigrice.jpg");

}
