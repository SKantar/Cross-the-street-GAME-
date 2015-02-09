package zaba;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class SledeciNivo {
	
	public SledeciNivo() {

	}
	
// funkcija koja slika sliku izmedju dva nivoa
	public void slikaj(Graphics g){
		g.drawImage(slika, 0, 0, 800, 600, null);
	}
// Slika koja se pojavljuje izmedju dva nivoa
	Image slika = Toolkit.getDefaultToolkit().getImage("sledecinivo.gif");

}
