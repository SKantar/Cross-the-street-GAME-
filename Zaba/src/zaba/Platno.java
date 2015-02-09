package zaba;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Platno extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	
	private Pozadina pozadina;
	private int brojac = 0;
	private int brojac2 = 0;
	private boolean pomocna = true;
	private Kraj slikakraja;
	private Putici putici;
	private PredjenaIgrica predjenaigrica;
	private Zaba karakter;
	private boolean kraj;
	private boolean krajj;
	private ArrayList<Autici> autici1 = new ArrayList<Autici>();
	private ArrayList<Autici> autici2 = new ArrayList<Autici>();
	private ArrayList<Autici> autici3 = new ArrayList<Autici>();
	private final int DELAY = 12;                                    // vreme pauze izmedju 2 iscrtavanja 
	private Thread animator;  
	private SledeciNivo sledeci_nivo;
	private int nivo = 1;
	private static final int OMG = 30000;
	//Provera da li se preklapaju autici pri setovanju koordinata na 1,2,3 puticu
	boolean moze1(int a,int k){
		for(int j= 0; j < k; j++){
			if((a > autici1.get(j).getPozicijaX()-Autici.getDuzina()) && (a < autici1.get(j).getPozicijaX()+ Autici.getDuzina())) return false;
		}
		return true;
	}
	
	boolean moze2(int a,int k){
		for(int j= 0; j < k; j++){
			if((a >autici2.get(j).getPozicijaX()-Autici.getDuzina()) && (a < autici2.get(j).getPozicijaX()+ Autici.getDuzina())) return false;
		}
		return true;
	}
	
	boolean moze3(int a,int k){
		for(int j= 0; j < k; j++){
			if((a > autici3.get(j).getPozicijaX()-Autici.getDuzina()) && (a < autici3.get(j).getPozicijaX()+ Autici.getDuzina())) return false;
		}
		return true;
	}
	
	
	//Konstruktor
	public Platno(){
		pozadina = new Pozadina();
		slikakraja = new Kraj();
		putici = new Putici();
		karakter = new Zaba();
		sledeci_nivo = new SledeciNivo();
		predjenaigrica = new PredjenaIgrica();
		kraj = true;
		krajj = true;
		int a;
	//Random setuje koordinate autica uz proveru preklapanja	
		Random r = new Random();
		for(int i =0; i < 100; i++){
			
			a = r.nextInt(OMG);
			while(!moze1(a,i)){
				a = r.nextInt(OMG);
				System.out.println(!moze1(a,i));
			}
			autici1.add(new Autici(a,400));
			
			
			a = r.nextInt(OMG);
			while(!moze2(a,i)){
				a = r.nextInt(OMG);
			}
			autici2.add(new Autici(a,240));
			
			a = r.nextInt(OMG);
			while(!moze3(a,i)){
				a = r.nextInt(OMG);
			}
			autici3.add(new Autici(a,80));
			
		}
		
	}
	private int t;
//Iscrtavanje slika
	public void paint(Graphics g){
		brojac ++;
		if(Igra.pocetak){
			predjenaigrica.slikaj(g);
		}
		else {
		if(kraj && krajj){
		t = sledecinivo();
		System.out.println(t);
		if(t == 1){
		if(kraj()) krajj = false;
		pozadina.slikaj(g);
		putici.slika(g);
		karakter.slikaj(g);
		for(int i = 0; i < 100; i ++){           // pomera gornje i donje prepreke 
            autici1.get(i).slikaj(g);
            autici2.get(i).slikaj(g);
            autici3.get(i).slikaj(g);           
        }
		Font mali = new Font("Times new roman", Font.BOLD, 20);                         // ispisuje trenutno stanje poena i nivo-a
		g.setColor(Color.red);
		g.setFont(mali);
		g.drawString("Nivo : " +nivo,50, 25);
		}
		else if(t == 2){
			sledeci_nivo.slikaj(g);
			Font mali = new Font("Times new roman", Font.BOLD, 60);                         // ispisuje trenutno stanje poena i nivo-a
			g.setColor(Color.red);
			g.setFont(mali);
			g.drawString("Cestitam, idete u sledeci nivo",0,200);
		}
	
		}
		
		else {
			if(krajj == false){
				slikakraja.slikaj(g);
				Font mali = new Font("Times new roman", Font.BOLD, 80);                         // ispisuje trenutno stanje poena i nivo-a
				g.setColor(Color.red);
				g.setFont(mali);
				g.drawString("Vise srece drugi put",0,200);
			}
			else{
				predjenaigrica.slikaj(g);
				Font mali = new Font("Times new roman", Font.BOLD, 100);                         // ispisuje trenutno stanje poena i nivo-a
				g.setColor(Color.red);
				g.setFont(mali);
				g.drawString("Uspesno ste zavrsili igru",0,80);
			}
		}
		if(brojac == brojac2) pomocna = true;
		}
		Toolkit.getDefaultToolkit().sync(); 
        g.dispose(); 
	}


	public void addNotify() { 
        super.addNotify(); 
        animator = new Thread(this); 
        animator.start();

    } 
      
/* izvrsava pomeranja i repaint */      
    public void run() { 
        long prevremena, vremenskarazlika, spavanje; 
        prevremena = System.currentTimeMillis(); 
        while (true) {             // pomera margine 
            for(int i = 0; i < 100; i ++){           // pomera gornje i donje prepreke 
                autici1.get(i).pomeri(); 
                autici2.get(i).pomeri();
                autici3.get(i).pomeri();
            }
            
            repaint(); 
            if(pomocna){
            	brojac2 = brojac+200;
            }
            vremenskarazlika = System.currentTimeMillis() - prevremena; 
            spavanje = DELAY - nivo - vremenskarazlika; 
  
            if (spavanje < 0) 
                spavanje = 2; 
            try { 
                Thread.sleep(spavanje); 
            } catch (InterruptedException e) { 
                System.out.println("interrupted"); 
            } 
  
            prevremena = System.currentTimeMillis(); 
        } 
    }

	public Zaba getKarakter() {
		return karakter;
	} 
	//Da li je karakter udario u autic
	private boolean kraj(){
		if(karakter.getKoordinataY()>320 && karakter.getKoordinataY()< 480){
			for(int j= 0; j < autici1.size() ; j++){
				if((karakter.getKoordinataX() >autici1.get(j).getPozicijaX()-80) && (karakter.getKoordinataX() < autici1.get(j).getPozicijaX()+ 80)) return true;
			}
		}
		
		if(karakter.getKoordinataY()>160 && karakter.getKoordinataY()< 320){
			for(int j= 0; j < autici1.size() ; j++){
				if((karakter.getKoordinataX() >autici2.get(j).getPozicijaX()-80) && (karakter.getKoordinataX() < autici2.get(j).getPozicijaX()+ 80)) return true;
			}
		}
		
		if(karakter.getKoordinataY()>0 && karakter.getKoordinataY()< 160){
			for(int j= 0; j < autici1.size() ; j++){
				if((karakter.getKoordinataX() >autici3.get(j).getPozicijaX()-80) && (karakter.getKoordinataX() < autici3.get(j).getPozicijaX()+ 80)) return true;
			}
		}
		return false;
			
	}
	//Vraca sve promenljive na pocetno stanje radi nove igre i novog nivoa
	public void init(){
		int a;
		kraj = true;
		krajj = true;
		karakter.setKoordinataY(480);
		karakter.setKoordinataX(380);
		Random r = new Random();
		for(int i =0; i < 100; i++){
			
			a = r.nextInt(OMG);
			while(!moze1(a,i)){
				a = r.nextInt(OMG);
			}
			autici1.set(i,new Autici(a,400));
			
			
			a = r.nextInt(OMG);
			while(!moze2(a,i)){
				a = r.nextInt(OMG);
			}
			autici2.set(i,new Autici(a,240));
			
			a = r.nextInt(OMG);
			while(!moze3(a,i)){
				a = r.nextInt(OMG);
			}
			autici3.set(i,new Autici(a,80));
			
		}
		
	}
	//Da li je predjen nivo, odnosno da li treba preci u sledeci
	private int sledecinivo(){
		if(karakter.getKoordinataY() == 0 || (brojac <= brojac2 && !pomocna) ){
			if(brojac2 == brojac){
				pomocna = true;
				nivo ++;
				init();
			}
			pomocna = false;
			if(nivo == 5){
				kraj = false;
				return 3;
			}
			return 2;
		}
		if(brojac2 == brojac)
			pomocna = true;
	return 1;
	}
	
	

}
