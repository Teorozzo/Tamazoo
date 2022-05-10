package it.unibs.fp.tamazoo;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class MainTest {

	public static void main(String[] args) {
		
		Tamazoo zoo = new Tamazoo("Cavrelle");
		
		zoo.getTamas().add(new Tamabase("Piero",50.0,50.0));
		zoo.getTamas().add(new Tamabase("Luca",30.0,80.0));
		zoo.getTamas().add(new Tamatriste("Silvia",10.0,30.0));
		zoo.getTamas().add(new Tamagordo("Ciccio",30.0,30.0));
		zoo.getTamas().add(zoo.randomTama());
		
		
		for(int i=0;i<100;i++) {
		zoo.printZoo();
		
		DAI_BISCOTTO(zoo);
		
		DAI_CAREZZE(zoo);
		
		//removeTama(zoo);

		}
		zoo.printZoo();
	}

	private static void removeTama(Tamazoo zoo) {
		MyMenu menuTamas = new MyMenu("Scegli tama da eliminare", zoo.getNameList());
		int toRemove=menuTamas.scegli()-1;
		zoo.tamas.remove(toRemove);
	}

	private static void DAI_BISCOTTO(Tamazoo zoo) {
		int biscotto = InputDati.leggiIntero("\nnumero biscotto-->", 0, 20);
		for(int i = 0; i<zoo.tamas.size() || zoo.tamas.size()!=0;i++) {
			
			zoo.tamas.get(i).daiBiscotto(biscotto);
			if(zoo.tamas.get(i).isMorto()) {
				System.out.println(zoo.tamas.get(i).getName()+" è morto di fame");
				zoo.tamas.remove(i);
			}
		}
	}
	
	private static void DAI_CAREZZE(Tamazoo zoo) {
		int carezza = InputDati.leggiIntero("\nnumero carezze-->", 0, 20);
		for(int i = 0; i<zoo.tamas.size() || zoo.tamas.size()!=0;i++) {
			
			zoo.tamas.get(i).daiCarezze(carezza);
			if(zoo.tamas.get(i).isMorto()) {
				System.out.println(zoo.tamas.get(i).getName()+" è morto di tristezza");
				zoo.tamas.remove(i);
			}
		}
	}
}
