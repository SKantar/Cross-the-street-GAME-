package zaba;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Autici {
	
	private int pozicijaX;
	private int pozicijaY;
	private static final int DUZINA = 100;
	private static final int SIRINA = 80;
	private Image autic = Toolkit.getDefaultToolkit().getImage("autic.gif");
	
	public Autici(int pozicijaX,int pozicijaY){ 
        this.pozicijaX = pozicijaX;
        this.pozicijaY = pozicijaY;
    } 
//Iscrtava autic
	public void slikaj(Graphics g){
		g.drawImage(autic,pozicijaX,pozicijaY,DUZINA,SIRINA,null);
	}
//pomera autic u levo 	
	public void pomeri(){
		pozicijaX --;
	}
//geteri i seteri
	public int getPozicijaX() {
		return pozicijaX;
	}

	public static int getDuzina() {
		return DUZINA;
	}

	
	
	
	
	
}
