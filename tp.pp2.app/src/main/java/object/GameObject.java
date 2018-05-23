package object;

import java.awt.Point;

import enums.Orientation;
import states.StateMove;
import tablero.ObjectGraphic;

public class GameObject extends ObjectGraphic{

	protected Point size;
	protected int vida;
	protected Orientation orientation;
	private StateMove stateMove;
	
	public GameObject(Point position, Point size, int vida, Orientation orientation) {
		super(position);
		this.size = size;	
		this.vida= vida;
		this.orientation= orientation;
	}

	public Point getSize() {
		return size;
	}
	public void setSize(Point size) {
		this.size = size;
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
}
