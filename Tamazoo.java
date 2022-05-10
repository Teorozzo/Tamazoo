package it.unibs.fp.tamazoo;

import java.util.ArrayList;
import it.unibs.fp.mylib.BelleStringhe;
import it.unibs.fp.mylib.InputDati;

public class Tamazoo {

	private static final String INSERT_SATISFACTION = "Inserisci la soddisfazione: ";
	private static final String INSERT_SATIETY = "Inserisci la sazieta: ";
	private static final String INSERT_NAME = "Inserisci il nome: ";
	protected static final String STATUS_FORMAT = "%-20s |%-20s |%-6.2f |%-6.2f|";
	private static final String NEWLINE = "\n-----------------------------------------------------------";
	private static final String STATUS_FORMAT_HEADER = "%s\nZOO %s%s\n%-20s |%-20s |%-6s |%-6s|";
	String zooName;
	ArrayList <Tamabase> tamas;
	String[] nameList;
	
	/**
	 * Costruttore Tamazoo
	 */
	public Tamazoo(String zooName) {
		this.zooName = zooName;
		tamas = new ArrayList<Tamabase>();
	}
	
	/**
	 * Aggiunge un tamagotchi allo zoo
	 */
	public void addTama() {
		tamas.add(randomTama());
	}
	
	/**
	 * Stampa la lista dei tamagotchi presenti nello zoo
	 */
	public void printZoo() {
		System.out.println(String.format(STATUS_FORMAT_HEADER,NEWLINE,zooName,NEWLINE, "NOME","TIPO","SAZ","SODD"));
		for(int i=0; i<tamas.size(); i++) {
			System.out.println(tamas.get(i).toString());
		}
		
		
	}
	
	/**
	 * Genera un numero casuale tra 1 e 3
	 * <br>Il numero corrisponde ad un tamagotchi. 
	 */
	public Tamabase randomTama() {
		int selection = (int) (Math.random()*3)+1;
		
		switch(selection) {
			case 1:
				return newTamabase();
			case 2:
				return newTamagordo();
			case 3:
				return newTamatriste();
			default:
				System.out.println("NESSUN TAMAGOTCHI CREATO");
				return null;
		}
	}
	
	/**
	 * Crea un tamabase
	 */
	public Tamabase newTamabase() {
		
		String Name = BelleStringhe.primaLetteraMaiuscola(InputDati.leggiStringaNonVuota(INSERT_NAME));
		double Satiety = InputDati.leggiIntero(INSERT_SATIETY, 0, 100);
		double Satisfaction = InputDati.leggiIntero(INSERT_SATISFACTION, 0, 100);
		
		Tamabase tama = new Tamabase(Name,Satiety,Satisfaction);
		
		return tama;
	}
	
	/**
	 * Crea un tamagordo
	 */
	public Tamabase newTamagordo() {
		
		String Name = BelleStringhe.primaLetteraMaiuscola(InputDati.leggiStringaNonVuota(INSERT_NAME));
		double Satiety = InputDati.leggiIntero(INSERT_SATIETY, 0, 100);
		double Satisfaction = InputDati.leggiIntero(INSERT_SATISFACTION, 0, 100);
		
		Tamabase tama = new Tamagordo(Name,Satiety,Satisfaction);
		
		return tama;
	}
	/**
	 * Crea un tamagordo
	 */
	public Tamabase newTamatriste() {
		
		String Name = BelleStringhe.primaLetteraMaiuscola(InputDati.leggiStringaNonVuota(INSERT_NAME));
		double Satiety = InputDati.leggiIntero(INSERT_SATIETY, 0, 100);
		double Satisfaction = InputDati.leggiIntero(INSERT_SATISFACTION, 0, 100);
		
		Tamabase tama = new Tamatriste(Name,Satiety,Satisfaction);
		
		return tama;
	}

	public ArrayList<Tamabase> getTamas() {
		return tamas;
	}
	
	/**
	 * Estrae una lista con tutti i nomi dei tamagotchi, serve per creare il menu di selezione
	 * @return lista di nomi
	 */
	public String[] getNameList() {
		ArrayList <String> names = new ArrayList <String>();
		for(int i=0; i<tamas.size();i++) {
			names.add(tamas.get(i).getName());
		}
		nameList = new String[ names.size() ];
        names.toArray(nameList);
		return nameList;
		
	}
	
	
}

