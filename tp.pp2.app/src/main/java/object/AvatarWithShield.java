package object;

import java.awt.Point; 

public class AvatarWithShield extends GameObject{
	
	public AvatarWithShield(Point coordinate, Point size, int vida) {
		super(coordinate, size, vida);
	}
	
	public void Colission_Avatar(){
		this.vida= this.vida - 0;
	}
	public void Colission_Ax(){
		this.vida= this.vida - 45;
	}
	public void Colission_Bazooka(){
		this.vida= this.vida - 40;
	}
	public void Colission_Shotgun(){
		this.vida= this.vida - 35;
	}
	
}

