package main;

import draftmans.Draw;
import tablero.Board;
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
	}

	public void show() {
		draw.DrawImages();
	}

	// utilizamos nanosegundos, para evitar conflictos si se ejecuta en otro sistema
	// operativo
	public void run() { // actualiza el avance y dibujos del juego
		final int NS_POR_SEGUNDO = 1000000000; // cantidad de nanosegundos equivalentes a un segundo
		final byte APS_OBJETIVO = 60; // cuantas actualizaciones queremos por segundo (60)
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO; // cuantos nanosegundos transcurren por
																			// actualizacion
		long referenciaActualizacion = System.nanoTime(); // se almacena una cantidad exacta de nanosegundos, justo en
															// el momento que se ejecuta
		long referenciaContador = System.nanoTime(); // para contar los frames (EXTRA)
		double tiempoTranscurrido;
		double delta = 0;

		while (working) {
			final long inicioBucle = System.nanoTime(); // tomamos la cantidad exacta de nanosegundos cuando comienza el
														// bucle
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;// tomamos el tiempo transcurrido de cada ciclo
			referenciaActualizacion = inicioBucle;
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION; // sumamos a delta el tiempo trascurrido del ciclo
																// dividido por los nanosegundos
			while (delta >= 1) { // una vez que delta ya cumplio en llegar a uno de los bytes de APS_OBJETIVO, el
									// juego se actualizara
				update();
				delta--;
			}
			show();

			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				
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
