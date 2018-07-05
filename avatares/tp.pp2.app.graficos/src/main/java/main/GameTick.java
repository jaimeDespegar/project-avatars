package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import draftmans.Draw;
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

	public GameTick(Board board) {
		draw = new Draw(board);
		viewGame = new ViewGame(draw);
	}

	// synchronized permite que no se puedan ejecutar al mismo tiempo
	public synchronized void start() {
		working = true;
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
		
		while (working) {
			
			//show();
			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				testUpdateBoxes();
				stop();
				referenciaContador = System.nanoTime();
			}
		}
	}

	public synchronized void stop() {
		working = false;
		thread = new Thread(this, "Graphics");
		thread.start();
	}
}
