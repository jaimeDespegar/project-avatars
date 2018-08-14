package turnos;

import java.awt.AWTException;

import control.AvatarController;
import control.AvatarWithShieldController;
import control.GameObjectController;
import object.GameObject;

public class ControlTurns {
	AvatarController j1;
	AvatarWithShieldController j2;
	Turns t;
	Integer cantAvancesJ1=0;
	Integer cantDisparosJ1=0;
	Integer cantAvancesJ2=0;
	Integer cantDisparosJ2=0;
	
	public ControlTurns(AvatarController jugador1, AvatarWithShieldController jugador2, Turns turno){
		this.j1= jugador1;
		this.j2= jugador2;
		this.t= turno;
	}

	//Getters y Setters
	public AvatarController getJ1() {
		return j1;
	}

	public void setJ1(AvatarController j1) {
		this.j1 = j1;
	}

	public AvatarWithShieldController getJ2() {
		return j2;
	}

	public void setJ2(AvatarWithShieldController j2) {
		this.j2 = j2;
	}

	public Turns getT() {
		return t;
	}

	public void setT(Turns t) {
		this.t = t;
	}
	
	
//	//SOLO DESPUES DE DISPARAR, EL JUGADOR TERMINA SU TURNO
//	public void controlActualTurns(GameObjectController go){
//		go.getCantDisparos();
//		if(go.getArma().isActive()){//se realizo un disparo "go.disparar(avatar)"
//			t.actualizarTurno();
//		}
//	}
//	
//
//	public Integer elTurnoEsDelJugador(){
//		return controlPlayerTurno(t); 
//	}
//	
	public Integer controlPlayerTurno(Turns t){
		if((t.getTurno()%2) == 0){//LE TOCA AL JUGADOR 2
			System.out.println("ES TURNO DEL JUGADOR 2");
			return 0;
		}
		if((t.getTurno()%2) == 1){//LE TOCA AL JUGADOR 1
			System.out.println("ES TURNO DEL JUGADOR 1");
			return 1;
		}
		return null;
	}
	
	//EL JUGADOR SOLAMENTE PUEDE MOVERSE 1 VEZ POR TURNO
	public void controlOneMovenementJ1(Integer keyPressedInNow) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException 
	{
		if(keyPressedInNow.equals(this.j1.getKeyAvatarProperties().getElectionKeyAvatar().getKeyUp().getKeyValue()) && (cantAvancesJ1<1)){
			this.j1.controlAvatar(this.j1.getAvatar().getPosition(), keyPressedInNow, this.j2.getAvatar());
			cantAvancesJ1= cantAvancesJ1 +1;
		}
		
		if(keyPressedInNow.equals(this.j1.getKeyAvatarProperties().getElectionKeyAvatar().getKeyDown().getKeyValue()) && (cantAvancesJ1<1)){
			this.j1.controlAvatar(this.j1.getAvatar().getPosition(), keyPressedInNow, this.j2.getAvatar());
			cantAvancesJ1= cantAvancesJ1 +1;
		}
	}
	
	//EL JUGADOR PUEDE GIRAR LAS VECES QUE DESEA POR TURNO
	public void controlGirarJ1(Integer keyPressedInNow) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException 
	{
		if(keyPressedInNow.equals(this.j1.getKeyAvatarProperties().getElectionKeyAvatar().getKeyLeft().getKeyValue())){
			this.j1.controlAvatar(this.j1.getAvatar().getPosition(), keyPressedInNow, this.j2.getAvatar());
		}
		
		if(keyPressedInNow.equals(this.j1.getKeyAvatarProperties().getElectionKeyAvatar().getKeyRight().getKeyValue())){
			this.j1.controlAvatar(this.j1.getAvatar().getPosition(), keyPressedInNow, this.j2.getAvatar());
		}
	}
	
	//EL JUGADOR PUEDE DISPARAR SOLO 1 VEZ POR TURNO
	public void controlOneShootJ1(Integer keyPressedInNow) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException 
	{
		if(keyPressedInNow.equals(this.j1.getKeyAvatarProperties().getElectionKeyAvatar().getKeyShoot().getKeyValue()) && (cantDisparosJ1<1)){
			this.j1.controlAvatar(this.j1.getAvatar().getPosition(), keyPressedInNow, this.j2.getAvatar());
			cantDisparosJ1= cantDisparosJ1 +1;
		}
	}
	
	//EL JUGADOR PUEDE UTILZAR UN PODER DE DISPARO POR TURNO
	public void controlOnePowerJ1(Integer keyPressedInNow) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException 
	{
		if(keyPressedInNow.equals(this.j1.getKeyAvatarProperties().getElectionKeyAvatar().getKeyPower1().getKeyValue()) && (this.j1.getCantPower1()>0) && (cantDisparosJ1<1)){
			this.j1.controlAvatar(this.j1.getAvatar().getPosition(), keyPressedInNow, this.j2.getAvatar());
			this.j1.setCantPower1(this.j1.getCantPower1() - 1);
			cantDisparosJ1= cantDisparosJ1 +1;
		}
		if(keyPressedInNow.equals(this.j1.getKeyAvatarProperties().getElectionKeyAvatar().getKeyPower2().getKeyValue()) && (this.j1.getCantPower2() >0) && (cantDisparosJ1<1)){
			this.j1.controlAvatar(this.j1.getAvatar().getPosition(), keyPressedInNow, this.j2.getAvatar());
			this.j1.setCantPower1(this.j1.getCantPower2() - 1);
			cantDisparosJ1= cantDisparosJ1 +1;
		}
	}
	
//-------------------------------------------------------------------------------------//	
	
	//EL JUGADOR SOLAMENTE PUEDE MOVERSE 1 VEZ POR TURNO
	public void controlOneMovenementJ2(Integer keyPressedInNow) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException 
	{
		if(keyPressedInNow.equals(this.j2.getKeyAvatarProperties().getElectionKeyAvatar().getKeyUp().getKeyValue()) && (cantAvancesJ2<1)){
			this.j2.controlAvatar(this.j2.getAvatar().getPosition(), keyPressedInNow, this.j1.getAvatar());
			cantAvancesJ2= cantAvancesJ2 +1;
		}
		
		if(keyPressedInNow.equals(this.j2.getKeyAvatarProperties().getElectionKeyAvatar().getKeyDown().getKeyValue()) && (cantAvancesJ2<1)){
			this.j2.controlAvatar(this.j2.getAvatar().getPosition(), keyPressedInNow, this.j1.getAvatar());
			cantAvancesJ2= cantAvancesJ2 +1;
		}
	}
	
	//EL JUGADOR PUEDE GIRAR LAS VECES QUE DESEA POR TURNO
	public void controlGirarJ2(Integer keyPressedInNow) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException 
	{
		if(keyPressedInNow.equals(this.j2.getKeyAvatarProperties().getElectionKeyAvatar().getKeyLeft().getKeyValue())){
			this.j2.controlAvatar(this.j2.getAvatar().getPosition(), keyPressedInNow, this.j1.getAvatar());
		}
		
		if(keyPressedInNow.equals(this.j2.getKeyAvatarProperties().getElectionKeyAvatar().getKeyRight().getKeyValue())){
			this.j2.controlAvatar(this.j2.getAvatar().getPosition(), keyPressedInNow, this.j1.getAvatar());
		}
	}
	
	//EL JUGADOR PUEDE DISPARAR SOLO 1 VEZ POR TURNO
	public void controlOneShootJ2(Integer keyPressedInNow) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException 
	{
		if(keyPressedInNow.equals(this.j2.getKeyAvatarProperties().getElectionKeyAvatar().getKeyShoot().getKeyValue()) && (cantDisparosJ2<1)){
			this.j2.controlAvatar(this.j2.getAvatar().getPosition(), keyPressedInNow, this.j1.getAvatar());
			cantDisparosJ2= cantDisparosJ2 +1;
		}
	}
	
	//EL JUGADOR PUEDE UTILZAR UN PODER DE DISPARO POR TURNO
	public void controlOnePowerJ2(Integer keyPressedInNow) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException 
	{
		if(keyPressedInNow.equals(this.j2.getKeyAvatarProperties().getElectionKeyAvatar().getKeyPower1().getKeyValue()) && (this.j2.getCantPower1()>0) && (cantDisparosJ2<1)){
			this.j2.controlAvatar(this.j2.getAvatar().getPosition(), keyPressedInNow, this.j1.getAvatar());
			this.j2.setCantPower1(this.j2.getCantPower1() - 1);
			cantDisparosJ2= cantDisparosJ2 +1;
		}
		if(keyPressedInNow.equals(this.j2.getKeyAvatarProperties().getElectionKeyAvatar().getKeyPower2().getKeyValue()) && (this.j2.getCantPower2() >0) && (cantDisparosJ2<1)){
			this.j2.controlAvatar(this.j2.getAvatar().getPosition(), keyPressedInNow, this.j1.getAvatar());
			this.j2.setCantPower1(this.j2.getCantPower2() - 1);
			cantDisparosJ2= cantDisparosJ2 +1;
		}
	}
	
	
	
//-------------------------------------------------------------------------------------//		
	public void controlTurnos(Integer keyPressedInNow) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException 
	{
		controlPlayerTurno(this.t);
		while (!isGameOver()){
			
			while(!this.j1.isDisparoRealizado() && (this.j2.getAvatar().getVida() >0)){
				controlTeclasJ1(keyPressedInNow);
			}
			this.t.actualizarTurno();
			controlPlayerTurno(this.t);
			cantDisparosJ1=0;
			cantAvancesJ1= 0;
			
			
			while(!this.j2.isDisparoRealizado()){
				controlTeclasJ1(keyPressedInNow);
			}
			this.t.actualizarTurno();
			controlPlayerTurno(this.t);
			cantDisparosJ2=0;
			cantAvancesJ2= 0;
		}
	}

	private void controlTeclasJ1(Integer keyPressedInNow) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException 
	{
		AvatarController a= new AvatarController(this.j1.getAvatar(), this.j1.getMap(),this.j1.getArma());
		this.j1= a;
		controlOneMovenementJ1(keyPressedInNow);
		controlOneShootJ1(keyPressedInNow);
		controlGirarJ1(keyPressedInNow);
	}
	
	private void controlTeclasJ2(Integer keyPressedInNow) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException 
	{
		AvatarWithShieldController aws= new AvatarWithShieldController(this.j1.getAvatar(), this.j1.getMap(),this.j1.getArma());
		this.j2= aws;
		
	}
	
	public boolean isGameOver(){
		if((this.j1.getAvatar().getVida() >0) && (this.j2.getAvatar().getVida() >0)){
			return false;
		}
		else{
			return true;
		}
	}
}
