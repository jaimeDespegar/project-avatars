package object;

import java.awt.Point;


public class Shotgun extends GameObject{
	public int damage=70;
	public int shootingRange=3;
	
	public int getShootingRange() {
		return shootingRange;
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
	public void setShootingRange(int shootingRange) {
		this.shootingRange = shootingRange;
	}
	public Shotgun(Point coordinate, Point size, int vida) {
		super(coordinate, size, vida);
	}
}