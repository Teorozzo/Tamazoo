package it.unibs.fp.tamazoo;

public class Tamabase {

	
	protected static final int MAX_FELICE = 90;
	protected static final int MIN_FELICE = 30;
	protected static final int MIN_LIMIT = 0;
	protected static final int MAX_LIMIT = 100;
	String name;
	double satiety;
	double satisfaction;
	String status;
	String type;
	
	
	public Tamabase(String name, double satiety, double satisfaction) {
		super();
		this.name = name;
		this.satiety = satiety;
		this.satisfaction = satisfaction;
		type = "TamaBase";
		
	}

	public String getName() {
		return name;
	}

	public double getSatiety() {
		return satiety;
	}

	public void setSatiety(double satiety) {
		this.satiety = satiety;
	}

	public double getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(double satisfaction) {
		this.satisfaction = satisfaction;
	}

	public void visualizza() {
		System.out.println(toString());
		
	}
	
	
	public void daiCarezze(int carezze) {
		setSatisfaction(Math.min((getSatisfaction() + carezze),MAX_LIMIT));
		setSatiety(Math.max( MIN_LIMIT, (getSatiety()-(carezze/2)) ));
	}
	
	public void daiBiscotto(int biscotti) {
		for(int i=0; i<biscotti;i++) {
			setSatiety(Math.min((getSatiety()*1.1),MAX_LIMIT));
		}
		setSatisfaction(Math.max( MIN_LIMIT, (getSatisfaction()-(biscotti/4)) ));
	}
	
	
	public boolean isTriste() {
		return ( satiety<MIN_FELICE ||satiety>MAX_FELICE ||satisfaction<MIN_FELICE);
	}
	
	public boolean isMorto() {
		return (satiety==MIN_LIMIT || satiety==MAX_LIMIT || satisfaction==MIN_LIMIT);
	}
	
	public String toString() {
		StringBuffer status = new StringBuffer();
		status.append(String.format(Tamazoo.STATUS_FORMAT, name,type,satiety,satisfaction));
		if(!isMorto()) {
			if(isTriste()) {
				status.append("\n ATTENZIONE! il tamagotchi è triste");
			}
		}else
			status.append("\n TROPPO TARDI, E' MORTO");
		
		return status.toString();

	}

}
