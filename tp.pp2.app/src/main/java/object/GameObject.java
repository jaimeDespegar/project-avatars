package object;


import java.awt.Point;

import enums.Orientation;
import states.StateMove;
import tablero.ObjectGraphic;


public class GameObject extends ObjectGraphic{

	protected Integer vida;
	protected Orientation orientation;
	private StateMove stateMove;
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
	public StateMove getStateMove() {
		return stateMove;
	}
	public void setStateMove(StateMove stateMove) 
	{
		this.stateMove = stateMove;
	}
	public void doActionStateMove() {
		this.stateMove.control();
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
//	public void colissionWeapon(GameObject g, Weapon w){
//		int finalDamage= w.getDamage() / g.reduceDamage;
//		w.isActive= false;
//		this.vida= this.vida - finalDamage;
//	}
}
