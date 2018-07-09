package draftmans;

import java.awt.Point; 
import java.util.ArrayList;
import java.util.List;
import enums.TypeOfStructure;
import main.Game;
import object.KeyDto;
import listeners.FactoryListener;
import listeners.GameKeyListener;
import object.Structure;
import tablero.Box;
import tablero.Map;
import views.ViewGame;

public class GameTick implements Runnable {

	private static volatile Thread thread; // agregamos el volatile porque estamos usando 2 threads
	private static boolean working = false;
	private boolean drawOneTime = true;
	@SuppressWarnings("unused")
	private ViewGame viewGame;
	private Draw draw;
	private List<List<Box>> newChangesBoxes;
	private List<List<Point>> newChangesCoordinates;
	private GameKeyListener keyboard;
	private FactoryListener factoryListener;

	public GameTick(Map map, Game game) {
		draw = new Draw(map.getBoard());
		keyboard = new GameKeyListener();
		viewGame = new ViewGame(draw, keyboard);
		factoryListener = FactoryListener.getInstancie();
		newChangesBoxes = new ArrayList<List<Box>>();
		newChangesCoordinates = new ArrayList<List<Point>>();

		// agrego los listenrees de cada avatar
		game.getAvatars().forEach(a -> factoryListener.loadListeners(a.getKeys()));
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
				drawOneTime = false;
				referenciaContador = System.nanoTime();
			}
		}
		for(int i = 0; i < newChangesBoxes.size(); i ++) {
			updateBoxes(newChangesBoxes.get(i), newChangesCoordinates.get(i));
			while (working) {
				if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
					stop();
					referenciaContador = System.nanoTime();
				}
			}
			working = true;
		}		newChangesBoxes.clear();
		newChangesCoordinates.clear();

	}


	public void drawShoot(List<List<Box>> newChangesBoxes,List<List<Point>> newChangesCoordinates) {
		this.newChangesBoxes = newChangesBoxes;
		this.newChangesCoordinates = newChangesCoordinates;
		working = true;
		run();
	}
	
	public synchronized void stop() {
		working = false;
	}

}