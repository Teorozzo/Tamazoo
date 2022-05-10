package it.unibs.fp.tamazoo;

public class Tamagordo extends Tamabase{

	public Tamagordo(String name, double satiety, double satisfaction) {
		super(name, satiety, 100);
		type = "TamaGordo";
	}

	@Override
	public void daiCarezze(int carezze) {
		setSatiety(Math.max( MIN_LIMIT, (getSatiety()-(carezze*2)) ));
	}
	
	@Override
	public boolean isTriste() {
		return ( satiety<MIN_FELICE );
	}
	
	@Override
	public boolean isMorto() {
		return (satiety==MIN_LIMIT);
	}
}