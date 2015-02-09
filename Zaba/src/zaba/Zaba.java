package zaba;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Zaba {
// koordinate zabe
	private int koordinataY;
	private int koordinataX;
		public Zaba(){
			koordinataY = 480;
			koordinataX = 380;
		}
// funkcija koja prikazuje sliku zabe na ekranu		
		public void slikaj(Graphics g){
			g.drawImage(zaba,koordinataX,koordinataY,80,80,null);
		}
// Geteri i seteri		
		public void pomerigore(){
			koordinataY-=20;
		}
		public void pomeridole(){
			koordinataY+=20;
		}
		public void pomerilevo(){
			koordinataX-=20;
		}
		public void pomeridesno(){
			koordinataX+=20;
		}
		
		
		
		
		public int getKoordinataY() {
			return koordinataY;
		}

		public int getKoordinataX() {
			return koordinataX;
		}
		
		


		public void setKoordinataY(int koordinataY) {
			this.koordinataY = koordinataY;
		}

		public void setKoordinataX(int koordinataX) {
			this.koordinataX = koordinataX;
		}




		Image zaba = Toolkit.getDefaultToolkit().getImage("zaba.gif");
}
