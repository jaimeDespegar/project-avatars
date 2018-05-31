package control;

import java.awt.Point;

import javax.swing.JOptionPane;

import enums.Orientation;
import object.GameObject;
import object.Weapon;
import tablero.Map;

public class GameObjectController {
	protected GameObject avatar;
	protected Map map;
	protected Weapon arma;
	protected Point nextPointUp=null;
	protected Point previousPointUp= null;
	protected Point nextPointDown= null;
	protected Point previousPointDown= null;
	protected Point nextPointLeft= null;
	protected Point previousPointLeft= null;
	protected Point nextPointRight= null;
	protected Point previousPointRight= null;
	protected Point puntoChoque=null;
	
	public GameObjectController(GameObject avatar, Map map, Weapon arma) {
		this.avatar= avatar;
		this.map= map;
		this.arma= arma;
	}


	//GETTER & SETTER
	public GameObject getAvatar() {
		return avatar;
	}
	public void setAvatar(GameObject avatar) {
		this.avatar = avatar;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Weapon getArma() {
		return arma;
	}
	public void setArma(Weapon arma) {
		this.arma = arma;
	}
	
	//ASIGNAR POSICION LIBRE
	public Point asignarPrimerPosicionLibre(Map map){
		return null;
	}
	
	public Point asignarUltimaPosicionLibre(Map map){
		return null;
	}
	
	public void avanzar(Point positionAvatar){
	}
	
	public void retroceder(Point positionAvatar){
	}
	
	public void girarHaciaDerecha(){
	}
	
	public void girarHaciaIzquierda(){
	}
	
	@SuppressWarnings("unused")
	private void controlLive() {
		if( this.avatar.getVida() <=0 ){
			 JOptionPane.showMessageDialog(null, "GAME OVER !");
		}
	}
	private void controlLiveInConsole() {
		if( this.avatar.getVida() <=0 ){
			 System.out.println("GAME OVER!");
		}
	}
	public void colissionWeapon(GameObject g, Weapon w){
		int finalDamage= w.getDamage() / g.getReduceDamage();
		w.setActive(false);
		g.setVida(g.getVida() - finalDamage);
		
		//controlLive();
		controlLiveInConsole();
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