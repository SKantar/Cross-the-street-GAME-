package zaba;

import javax.swing.JFrame;

public class GlavnaKlasa {

	/**
	 * @param args
	 */


//Kristijan Kocic
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Igra igra = Igra.getInstanca();
		igra.setVisible(true);
		igra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
