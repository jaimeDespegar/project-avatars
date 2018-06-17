package object;

import java.awt.Point; 
import enums.Orientation;

public class GameObject extends ObjectGraphic{

	protected Integer vida;
	protected Orientation orientation;
	//private StateMove stateMove;
	private Point position;
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
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	public Integer getReduceDamage() {
		return reduceDamage;
	}
	public void setReduceDamage(Integer reduceDamage) {
		this.reduceDamage = reduceDamage;
	}
}
