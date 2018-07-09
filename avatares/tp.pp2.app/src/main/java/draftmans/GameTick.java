package draftmans;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import tablero.Board;
import tablero.Box;

public class GameTick{

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

	public void updateBoxes(List<Box> boxes, List<Point> coordinates) {
		draw.drawBoxes(boxes,coordinates);
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
		}
		newChangesBoxes.clear();
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
