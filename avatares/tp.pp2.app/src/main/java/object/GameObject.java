package object;

import enums.Orientation;

public class GameObject extends ObjectGraphic{

	protected Integer vida;
	protected Orientation orientation;
	protected Integer reduceDamage;

	public GameObject( Integer vida, Orientation orientation) {
		this.vida= vida;
		this.orientation= orientation;
	}

	public void gameObjectMaxHealthy(){
		this.vida= 100;
	}
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Integer getReduceDamage() {
		return reduceDamage;
	}

	public void setReduceDamage(Integer reduceDamage) {
		this.reduceDamage = reduceDamage;
	}

}