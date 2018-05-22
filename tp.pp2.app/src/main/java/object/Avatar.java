package object;

import java.awt.Point;

public class Avatar extends GameObject{
	
	public Avatar(Point coordinate, Point size, int vida) {
		super(coordinate, size, vida);
	}
	
	public void Colission_AvatarWithShield(){
		this.vida= this.vida - 0;
	}
	public void Colission_Ax(){
		this.vida= this.vida - 90;
	}
	public void Colission_Bazooka(){
		this.vida= this.vida - 80;
	}
	public void Colission_Shotgun(){
		this.vida= this.vida - 70;
	}
	
}

