package zaba;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Pozadina {
	
	public Pozadina (){
		
	}
//iscrtava pozadinu igrice
	public void slikaj(Graphics g){
		g.drawImage(slika, 0, 0, 800, 600, null);
	}
	
	Image slika = Toolkit.getDefaultToolkit().getImage("pozadina.jpg");
	

}
