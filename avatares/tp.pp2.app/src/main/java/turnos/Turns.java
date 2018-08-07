package turnos;

public class Turns {
	Integer turno=0;
	
	public Turns(){
		this.turno=1;
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
