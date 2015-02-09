package zaba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Igra extends JFrame{
	private static final long serialVersionUID = 1L;
	
	
	
	private static Igra instanca = null;
	Platno platno = new Platno();
	public static boolean pocetak = true;
	
	private Igra (){
	//setuje se meni
		JMenuBar meni = new JMenuBar();
		setJMenuBar(meni);
		JMenu igra = new JMenu("Igra");
		JMenuItem novaIgra = new JMenuItem("Nova igra");
		JMenuItem izlazak = new JMenuItem("Izlaz iz igre");
		meni.add(igra);
		igra.add(novaIgra);
		igra.add(izlazak);
		setSize(800, 600);
		setTitle("Zabokrecina");
		setLocationRelativeTo(null);
		setResizable(false);
	
		add(platno);
		//Kretanje karaktera
		addKeyListener(new KeyListener(){
		
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == 'w')
					if(platno.getKarakter().getKoordinataY() >0)
					platno.getKarakter().pomerigore();
				if(e.getKeyChar() == 'a')
					if(platno.getKarakter().getKoordinataX() >20)
					platno.getKarakter().pomerilevo();
				if(e.getKeyChar() == 's')
					if(platno.getKarakter().getKoordinataY() <480)
					platno.getKarakter().pomeridole();
				if(e.getKeyChar() == 'd')
					if(platno.getKarakter().getKoordinataX() <700)
					platno.getKarakter().pomeridesno();
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		/* kad kliknemo na novu igru startuje se nova igra*/
		novaIgra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				platno.init();
				pocetak = false;
				//new Gravitacija();
			}
		});
		
		/* pritiskom na izlaz gasi se igra*/
		izlazak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}

	public static Igra getInstanca() {
		if(instanca == null){
			instanca = new Igra();
		}
		return instanca;
	}
	
	
	

}
