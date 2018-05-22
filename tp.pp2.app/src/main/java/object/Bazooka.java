package object;

import java.awt.Point;

public class Bazooka extends GameObject{
	
	public Bazooka(Point coordinate, Point size, int vida) {
		super(coordinate, size, vida);
	}
	
	public void Colission_Avatar(){
		this.vida= 0;
	}
	public void Colission_AvatarWithShield(){
		this.vida= 0;
	}
	public void Colission_Ax(){
		this.vida= 0;
	}
	public void Colission_Bazooka(){
		this.vida= 0;
	}
	public void Colission_Shotgun(){
		this.vida= 0;
	}
	public void Colission_Acero(){
		this.vida= 0;
	}
}

