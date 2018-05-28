package object;

import java.awt.Point;

import enums.Orientation;
import tablero.ObjectGraphic;

public class Weapon extends ObjectGraphic{
	protected Integer damage;
	protected Integer shootingRange;
	protected boolean isActive;
	protected Orientation orientation;
	private Point position;
	
	public Weapon(Integer damage, Integer shootingRange, boolean isActive,Orientation orientation){
		isActive= true;
		this.damage= damage;
		this.shootingRange= shootingRange;
		this.isActive= isActive;
		this.orientation= orientation;
	}

	public Integer getDamage() {
		return damage;
	}
	public void setDamage(Integer damage) {
		this.damage = damage;
	}
	public Integer getShootingRange() {
		return shootingRange;
	}
	public void setShootingRange(Integer shootingRange) {
		this.shootingRange = shootingRange;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Orientation getOrientation() {
		return orientation;
	}
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	public void colissionObject(){
		this.isActive=false;
	}

	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	
	public void colissionGameObject(Weapon w){
		w.isActive= false;
	}
	
	public void colissionStructure(Weapon w){
		w.isActive= false;
	}
}
