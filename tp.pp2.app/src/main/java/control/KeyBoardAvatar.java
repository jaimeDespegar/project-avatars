package control;

import java.awt.event.KeyEvent;

public class KeyBoardAvatar {
	private final static int numeroTeclas = 120;
	private final boolean[] teclas = new boolean[numeroTeclas];

	public boolean arriba;
	public boolean abajo;
	public boolean izquierda;
	public boolean derecha;
	public boolean space;
	public boolean salir;
	public int keyPressed = -1;
	public boolean disparo;
	public boolean poder1;
	public boolean poder2;
	
	public void actualizar() {
		arriba = teclas[KeyEvent.VK_W]; // la tecla arriba equivale a pulsar W
		abajo = teclas[KeyEvent.VK_S]; // la tecla arriba equivale a pulsar S
		izquierda = teclas[KeyEvent.VK_A]; // la tecla arriba equivale a pulsar A
		derecha = teclas[KeyEvent.VK_D]; // la tecla arriba equivale a pulsar D
		salir = teclas[KeyEvent.VK_ESCAPE];
		disparo = teclas[KeyEvent.VK_SPACE]; // la tecla disparo equivale a pulsar la barra espaciadora
		poder1 = teclas[KeyEvent.VK_C]; // la tecla arriba equivale a pulsar C
		poder2 = teclas[KeyEvent.VK_V]; // la tecla arriba equivale a pulsar V
		
	}

	// HAY QUE ARREGLAR ESTA PARTE, NO HACE LAS ACCIONES DE DEBAJO
	
	// teclas que se mantienen pulsada
	public void keyPressed(KeyEvent e) {
		System.out.println("tecla  qe se mantiene presionada " + e.getKeyCode());
		teclas[e.getKeyCode()] = true;
		this.keyPressed = e.getKeyCode();
	}// pone en true la tecla pulsada

	// teclas que se sueltan
	public void keyReleased(KeyEvent e) {
		System.out.println("tecla que se suelta " + e.getKeyCode());
		teclas[e.getKeyCode()] = false;
	}// pone en false tecla soltada

	// pulsar y soltar
	public void keyTyped(KeyEvent e) {

	}
	
	public Integer getKeyPressed() 
	{
		return keyPressed;
	}
}
