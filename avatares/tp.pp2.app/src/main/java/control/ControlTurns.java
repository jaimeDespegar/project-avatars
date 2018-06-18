package control;

import object.Turns;

public class ControlTurns {
	GameObjectController j1;
	GameObjectController j2;
	Turns t;
	int turnoGeneralActual= 1;
	
	public ControlTurns(GameObjectController jugador1, GameObjectController jugador2){
		this.j1= jugador1;
		this.j2= jugador2;
		t= new Turns();
	}

	//Getters y Setters
	public GameObjectController getJ1() {
		return j1;
	}
	public void setJ1(GameObjectController j1) {
		this.j1 = j1;
	}
	public GameObjectController getJ2() {
		return j2;
	}
	public void setJ2(GameObjectController j2) {
		this.j2 = j2;
	}
	public Turns getT() {
		return t;
	}
	public void setT(Turns t) {
		this.t = t;
	}
	
	
	//SOLO DESPUES DE DISPARAR, EL JUGADOR TERMINA SU TURNO
	public void controlDisparo(){
			elTurnoEsDelJugador();
	}
	public Integer elTurnoEsDelJugador(){
		numeroDeTurnoActual();
		return controlPlayerTurno(); 
	}
	public Integer controlPlayerTurno(){
		if((turnoGeneralActual%2) == 0){//LE TOCA AL JUGADOR 1
			System.out.println("ES TURNO DEL JUGADOR 1");
			return 0;
		}
		if((turnoGeneralActual%2) == 1){//LE TOCA AL JUGADOR 2
			System.out.println("ES TURNO DEL JUGADOR 2");
			return 1;
		}
		return null;
	}
	public Integer numeroDeTurnoActual(){
		turnoGeneralActual= this.j1.getCantDisparos() + this.j2.getCantDisparos();
		this.t.setTurno(turnoGeneralActual);
		return turnoGeneralActual;
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