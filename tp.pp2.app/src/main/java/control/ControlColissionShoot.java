package control;

import java.awt.Point;

import javax.swing.JOptionPane;

import object.GameObject;
import object.Weapon;
import tablero.Map;

public class ControlColissionShoot extends GameObjectController{

	public ControlColissionShoot(GameObject avatar, Map map, Weapon arma) {
		super(avatar, map, arma);
	}
	
	@SuppressWarnings("unused")
	private void controlLive() {
		if( this.avatar.getVida() <=0 ){
			 JOptionPane.showMessageDialog(null, "GAME OVER !");
		}
	}
	private void controlLiveInConsole() {
		if( this.avatar.getVida() <=0 ){
			 System.out.println("\nGAME OVER!\n");
		}
	}
	
	private void controlPlayerLiveInConsole(GameObject enemy) {
		if( this.avatar.getVida() <=0 ){
			 System.out.println("\nGAME OVER!\n");
			 System.out.println("Vida del Avatar Perdedor: "+ this.avatar.getVida());
			 System.out.println("Vida del Avatar Ganador: "+ enemy.getVida()+"\n");
			 borrarAvatarDelMapa();
		}
	}
	private void borrarAvatarDelMapa() {
		if(this.avatar.getPosition() != null){
			map.deleteBoxGameObject(this.avatar.getPosition());
		}
		
	}

	public void colissionWeapon(GameObject g, Weapon w){
		int finalDamage= w.getDamage() / g.getReduceDamage();
		w.setActive(false);
		g.setVida(g.getVida() - finalDamage);
		
		//controlLive();
		controlLiveInConsole();
	}
	public void colissionWeaponByEnemy(GameObject g, Weapon w, GameObject e){
		int finalDamage= w.getDamage() / g.getReduceDamage();
		w.setActive(false);
		g.setVida(g.getVida() - finalDamage);
		controlPlayerLiveInConsole(e);
		//controlPlayerLiveInConsole(e);
	}
	
	public Integer disparar(GameObject g){
		int cantShootingRange=0;
		WeaponController w= new WeaponController(avatar, map, arma);
		arma.setOrientation(avatar.getOrientation());
		Point old;
		for(int i=0; i < arma.getShootingRange(); i++ ){
			old= arma.getPosition();
			w.avanzar(arma.getPosition());
			if(old.equals(arma.getPosition())){
				puntoChoque= controlColissionPoint(arma, cantShootingRange, w);
				controlChoqueConEnemy(puntoChoque, g);
				return cantShootingRange;
			}
			cantShootingRange= cantShootingRange+1;
		}
		
		return cantShootingRange;
	}
	
	private void controlChoqueConEnemy(Point puntoChoque2, GameObject g) {
		if(puntoChoque2.equals(g.getPosition())){
			colissionWeapon(g, arma);
		}
		
	}


	private Point controlColissionPoint(Weapon arma, int cantShootingRange, WeaponController w) {
		Point p= null;
		for(int i=0; i < cantShootingRange+1; i++ ){
			p= w.avanzarRangoDisparo(arma.getPosition());
		}
		return p;
	}


	public boolean isWeaponrecorridaCompleta(Integer cantShootingRange){
		return (arma.getShootingRange().equals(cantShootingRange));
	}
	
	
	public boolean isColission(Integer cantShootingRange){
		boolean i= isWeaponrecorridaCompleta(cantShootingRange);
		boolean r= !i;
		return r;
	}
}
