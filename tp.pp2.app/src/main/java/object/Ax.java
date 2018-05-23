package object;

import java.awt.Point;


public class Ax extends GameObject{
	public int damage=90;
	public int shootingRange=1;

	public Ax(Point coordinate, Point size, int vida) {
		super(coordinate, size, vida);
	}
	
	public void colissionAvatar(){
		this.vida= 0;
	}
	public void colissionAvatarWithShield(){
		this.vida= 0;
	}
	public void colissionAx(){
		this.vida= 0;
	}
	public void colissionBazooka(){
		this.vida= 0;
	}
	public void colissionShotgun(){
		this.vida= 0;
	}
	public void colissionAcero(){
		this.vida= 0;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getShootingRange() {
		return shootingRange;
	}
	public void setShootingRange(int shootingRange) {
		this.shootingRange = shootingRange;
	}
}
