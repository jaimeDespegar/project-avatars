package draftmans;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import enums.TypeOfStructure;
import object.Structure;
import tablero.Board;
import tablero.Box;
import views.ViewGame;

public class GameTick implements Runnable {

	private static volatile Thread thread; // agregamos el volatile porque estamos usando 2 threads
	private static boolean working = false;
	private boolean drawOneTime = true;
	@SuppressWarnings("unused")
	private static ViewGame viewGame;
	private Draw draw;
	private List<List<Box>> newChangesBoxes;
	private List<List<Point>> newChangesCoordinates;

	public GameTick(Board board) {
		draw = new Draw(board);
		viewGame = new ViewGame(draw);
		newChangesBoxes = new ArrayList<List<Box>>();
		newChangesCoordinates = new ArrayList<List<Point>>();
	}

	// synchronized permite que no se puedan ejecutar al mismo tiempo
	public synchronized void start() {
		working = false;
		thread = new Thread(this, "Graphics");
		thread.start();
	}

	public void update() {
		working = true;
	}


	public void updateBoxes(List<Box> boxes, List<Point> coordinates) {
		draw.drawBoxes(boxes,coordinates);
		//working = true;
	}
	
	public void testUpdateBoxes() {
		List<Box> boxes = new ArrayList<Box>();
		boxes.add(new Box(null));
		boxes.add(new Box(new Structure(TypeOfStructure.ACERO)));
		List<Point> coordinates =  new ArrayList<Point>();
		coordinates.add(new Point(0,0));
		coordinates.add(new Point(1,1));
		updateBoxes(boxes,coordinates);
	}
	
	public void show() {
		draw.DrawImages();
	}

	public void run() { 
		final int NS_POR_SEGUNDO = 1000000000; // cantidad de nanosegundos equivalentes a un segundo
		long referenciaContador = System.nanoTime(); // para contar los frames 
		//dibujamos una sola vez todos los elementos del juego
		while (drawOneTime) {
			show();
			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				testUpdateBoxes();
				drawOneTime = false;
				referenciaContador = System.nanoTime();
			}
		}
		
		/*while (working) {
			
			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				stop();
				referenciaContador = System.nanoTime();
			}
		}
		*/
		for(int i = 0; i < newChangesBoxes.size(); i ++) {
			updateBoxes(newChangesBoxes.get(i), newChangesCoordinates.get(i));
			while (working) {
				if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
					stop();
					referenciaContador = System.nanoTime();
				}
			}
			working = true;
		}
		newChangesBoxes.clear();
		newChangesCoordinates.clear();
	}
	//recibe una lista de los objetos cambiados (objetonuevo - punto)
	//es decir, cuando un avatar dispara se debe de guardar en esa lista, el disparo, y su posicion
	//en la siguiente escena, si el disparo avanzo una casilla, y tambien desaparecela casilla en la que estaba antes
	//por lo tanto, seria una lista de escenas, y cuando lo dibuja, pasa una escena por segundo, asi se puede observar los cambios
	public void drawShoot(List<List<Box>> newChangesBoxes,List<List<Point>> newChangesCoordinates) {
		this.newChangesBoxes = newChangesBoxes;
		this.newChangesCoordinates = newChangesCoordinates;
		working = true;
	//	boolean shoot = true;
	//	while(shoot) {
	//		for(int i = 0; i < newChangesBoxes.size(); i ++) {
	//			updateBoxes(newChangesBoxes.get(i), newChangesCoordinates.get(i));
	//		}
	//	}
		}
	
	public synchronized void stop() {
		working = false;
		thread = new Thread(this, "Graphics");
		thread.start();
	}
}
