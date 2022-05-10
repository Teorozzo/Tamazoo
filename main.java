// file:///C:/Users/utente/Downloads/TamaZoo.pdf
package it.unibs.fp.tamazoo;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.BelleStringhe;
import it.unibs.fp.mylib.MyMenu;

public class main {

	private static final String INSERT_BISCUITS = "Inserisci il numero di biscotti";
	private static final String INSERT_HUGS = "Inserisci il numero di carezze";
	private static final int MAX_ACTION = 20;
	private static final int MIN_ACTION = 0;
	private static int scelta=0;
	private static String name;
	private static int biscotto=0;
	private static int carezza=0;
	private static final String Benvenuto = "Benvenuto nel tamazoo\nInserisci il nome del tuo zoo: ";

	
	
	private static final String[] MENU_LIST = {"Inserisci nuovo tama random","Stampa lista tama","Dai Biscotto","Dai Carezza","Elimina tamagotchi"};

	public static void main(String[] args) {
		
		name = BelleStringhe.primaLetteraMaiuscola(InputDati.leggiStringaNonVuota(Benvenuto));
		
		Tamazoo zoo = new Tamazoo(name);
		MyMenu menu = new MyMenu("Zoo "+name, MENU_LIST);
		
		do {
			scelta=menu.scegli();
		
			switch(scelta) {
			case 1:
				zoo.addTama();
				break;
				
			case 2:
				zoo.printZoo();
				break;
				
			case 3://daiBiscotto
				biscotto = InputDati.leggiIntero(INSERT_BISCUITS, MIN_ACTION, MAX_ACTION);
				for(int i = 0; i<zoo.tamas.size()||zoo.tamas.size()!=0;i++) {
					zoo.tamas.get(i).daiBiscotto(biscotto);
					if(zoo.tamas.get(i).isMorto()) {
						System.out.println(zoo.tamas.get(i).getName()+" è morto di fame");
						zoo.tamas.remove(i);
					}
				}
				
				break;
				
			case 4://daiCarezza
				carezza = InputDati.leggiIntero(INSERT_HUGS, MIN_ACTION, MAX_ACTION);
				for(int i = 0; (i<zoo.tamas.size() || zoo.tamas.size()!=0) ;i++) {
					zoo.tamas.get(i).daiCarezze(carezza);
					
					if(zoo.tamas.get(i).isMorto()) {
						System.out.println(zoo.tamas.get(i).getName()+" è morto di tristezza");
						zoo.tamas.remove(i);
					}
				}
				break;
				
			case 5:
				MyMenu menuTamas = new MyMenu("Scegli tama da eliminare", zoo.getNameList());
				int toRemove=menuTamas.scegli()-1;
				zoo.tamas.remove(toRemove);
			default:
				break;
			}
		}while(zoo.tamas.size()!=0 && scelta!=0);
		
		System.out.println("\nGIOCO CONCLUSO");
}
}
