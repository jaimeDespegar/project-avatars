package object;

public class Turns {
	Integer turno;
	
	public Turns(){
		turno=0;
	}
	
	public void actualizarTurno(){
		this.turno= this.turno + 1;
	}
	public Integer getTurno() {
		return turno;
	}
	public void setTurno(Integer turno) {
		this.turno = turno;
	}
	
	
}

