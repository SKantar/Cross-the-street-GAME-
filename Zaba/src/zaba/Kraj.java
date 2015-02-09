package zaba;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Kraj {
public Kraj (){
		
	}
//Slika sliku koja se iscrtava kada autic udari karaktera	
	public void slikaj(Graphics g){
		g.drawImage(slika, 0, 0, 800, 600, null);
	}
	
	Image slika = Toolkit.getDefaultToolkit().getImage("kraj.gif");

}
