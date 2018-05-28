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
	
	public void colissionWeapon(GameObject go, Weapon w){
		Integer finalDamage= w.damage / go.reduceDamage;
		w.isActive= false;
		go.vida= go.vida - finalDamage;
	}
}
