package zaba;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Putici {

		public Putici(){
			
		}
// Funkcija koja prikazuje puteve na ekranu
		
		public void slika(Graphics g){
			g.drawImage(putici,0,80,800,80,null);
			g.drawImage(putici,0,240,800,80,null);
			g.drawImage(putici,0,400,800,80,null);
		}
// Slika puta
		private Image putici = Toolkit.getDefaultToolkit().getImage("putic.gif");
}
