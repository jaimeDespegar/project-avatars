package turnos;

import control.GameObjectController;
import object.GameObject;

public class ControlTurns {
	GameObject j1;
	GameObject j2;
	Turns t;
	
	public ControlTurns(GameObject jugador1, GameObject jugador2, Turns turno){
		this.j1= jugador1;
		this.j2= jugador2;
		this.t= turno;
	}

	//Getters y Setters
	public GameObject getJ1() {
		return j1;
	}
	public void setJ1(GameObject j1) {
		this.j1 = j1;
	}
	public GameObject getJ2() {
		return j2;
	}
	public void setJ2(GameObject j2) {
		this.j2 = j2;
	}
	public Turns getT() {
		return t;
	}
	public void setT(Turns t) {
		this.t = t;
	}
	
	
	//SOLO DESPUES DE DISPARAR, EL JUGADOR TERMINA SU TURNO
	public void controlActualTurns(GameObjectController go){
		go.getCantDisparos();
		if(go.getArma().isActive()){//se realizo un disparo "go.disparar(avatar)"
			t.actualizarTurno();
		}
	}
	
	public Integer elTurnoEsDelJugador(){
		return controlPlayerTurno(t); 
	}
	
	public Integer controlPlayerTurno(Turns t){
		if((t.getTurno()%2) == 0){//LE TOCA AL JUGADOR 1
			return 0;
		}
		if((t.getTurno()%2) == 1){//LE TOCA AL JUGADOR 2
			return 1;
		}
		return null;
	}
	
	//EL JUGADOR SOLAMENTE PUEDE MOVERSE 1 VEZ POR TURNO
	public void controlOneMovenement(GameObjectController go){
		
	}
	
	//EL JUGADOR PUEDE GIRAR LAS VECES QUE DESEA POR TURNO
	public void controlGirar(GameObjectController go){
		
	}
	
	public void changeTurns(GameObjectController go){
		
	}
}
