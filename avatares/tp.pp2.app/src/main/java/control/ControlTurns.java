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
}