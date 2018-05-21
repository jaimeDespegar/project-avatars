package control;


import java.awt.event.KeyEvent;

public class KeyBoardEnemyAvatar {
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
		arriba = teclas[KeyEvent.VK_UP]; // la tecla arriba equivale a pulsar la flecha de arriba
		abajo = teclas[KeyEvent.VK_DOWN]; // la tecla arriba equivale a pulsar la flecha de abajo
		izquierda = teclas[KeyEvent.VK_LEFT]; // la tecla arriba equivale a pulsar la flecha izquierda
		derecha = teclas[KeyEvent.VK_RIGHT]; // la tecla arriba equivale a pulsar la flacha derecha
		salir = teclas[KeyEvent.VK_ESCAPE];
		disparo = teclas[KeyEvent.VK_ENTER]; // la tecla disparo equivale a pulsar Enter
		poder1 = teclas[KeyEvent.VK_K]; // la tecla arriba equivale a pulsar K
		poder2 = teclas[KeyEvent.VK_L]; // la tecla arriba equivale a pulsar L
		
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
