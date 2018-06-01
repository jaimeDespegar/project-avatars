package control;

import java.awt.Point;

import javax.swing.JOptionPane;

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
	
//	public void colissionWeapon(GameObject g, Weapon w){
//	}
//	
//	public Integer disparar(GameObject g){
//		int cantShootingRange=0;		
//		return cantShootingRange;
//	}
//	
//	public boolean isWeaponrecorridaCompleta(Integer cantShootingRange){
//		return (arma.getShootingRange().equals(cantShootingRange));
//	}
//	
//	public boolean isColission(Integer cantShootingRange){
//		boolean i= isWeaponrecorridaCompleta(cantShootingRange);
//		boolean r= !i;
//		return r;
//	}
}