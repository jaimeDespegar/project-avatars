package main;

import java.awt.Point;
import java.util.List;

import draftmans.Draw;
import tablero.Board;
import tablero.Box;
import views.ViewGame;

public class GameTick implements Runnable {

	private static volatile Thread thread; // agregamos el volatile porque estamos usando 2 threads
	private static boolean working = false;
	@SuppressWarnings("unused")
	private static ViewGame viewGame;
	//private UpdateGame updateGame;
	private Draw draw;

	public GameTick(Board board) {
	//	updateGame = new UpdateGame();
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
	//	updateGame.actualizar();
	//	draw.getData().addAll(updateGame.getObjects());
		
		working = true;
	}


	public void updateBoxes(List<Box> boxes, List<Point> coordinates) {
	//	updateGame.actualizar();
	//	draw.getData().addAll(updateGame.getObjects());
		draw.drawBoxes(boxes,coordinates);
		working = true;
	}
	
	public void show() {
		draw.DrawImages();
	}

	public void run() { 
		final int NS_POR_SEGUNDO = 1000000000; // cantidad de nanosegundos equivalentes a un segundo
		long referenciaContador = System.nanoTime(); // para contar los frames 

		show();
		while (working) {
			
			//show();
			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
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
