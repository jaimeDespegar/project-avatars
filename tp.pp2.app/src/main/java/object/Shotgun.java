package object;


import enums.Orientation;


public class Shotgun extends GameObject{
	private int damage=70;
	private int shootingRange=3;
	
	public Shotgun(int vida, Orientation orientation) {
		super(vida, orientation);
	}
	
	
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
	
}