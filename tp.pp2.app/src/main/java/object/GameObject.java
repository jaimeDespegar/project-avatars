package object;

import java.awt.Point;

import enums.Orientation;
import states.StateMove;

public class GameObject {
	protected Point coordinate;
	protected Point size;
	protected int vida;
	protected Orientation orientation;
	private StateMove stateMove;
	
	public GameObject(Point coordinate, Point size, int vida, Orientation orientation) {
		this.coordinate = coordinate;
		this.size = size;	
		this.vida= vida;
		this.orientation= orientation;
	}
	
	public Point getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Point coordinate) {
		this.coordinate = coordinate;
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
