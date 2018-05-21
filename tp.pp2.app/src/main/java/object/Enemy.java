package object;

import java.awt.Point;
import java.util.HashMap;

public class Enemy {
	protected Point coordinate;
	protected Point size;
	protected boolean escudo;
	protected int vida;
	
	public Enemy(Point coordinate, Point size, int vida, boolean escudo) {
		this.coordinate = coordinate;
		this.size = size;	
		this.vida= vida;
		this.escudo= escudo;
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
	public boolean isEscudo() {
		return escudo;
	}
	public void setEscudo(boolean escudo) {
		this.escudo = escudo;
	}

	//USER STORY 9
	public Point assignFreePosition(HashMap mapa){ //el mapa contiene(Point posición, Object objeto)
		Point freePosition= new Point(0,0); //valido inicial
		//CONTROLO UNA POSICIÓN LIBRE DEL MAPA
		return freePosition;
	}
}

