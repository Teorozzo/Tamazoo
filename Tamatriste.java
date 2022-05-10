package it.unibs.fp.tamazoo;

public class Tamatriste extends Tamabase {

	public Tamatriste(String name, double satiety, double satisfaction) {
		super(name, satiety, 1);
		type = "TamaTriste";
	}
	
	@Override
	public void daiCarezze(int carezze) {
		setSatiety(Math.max( MIN_LIMIT, (getSatiety()-(carezze/2)) ));
	}
	
	@Override
	public void daiBiscotto(int biscotti) {
		for(int i=0; i<biscotti;i++) {
			setSatiety(Math.min((getSatiety()*1.1),MAX_LIMIT));
		}
	}
	
	@Override
	public boolean isTriste() {
		return true;
	}
	
	@Override
	public boolean isMorto() {
		return (satiety==MIN_LIMIT || satiety==MAX_LIMIT);
	}
}
