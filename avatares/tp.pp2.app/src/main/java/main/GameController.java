package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import draftmans.GameTick;
import enums.Orientation;
import object.Avatar;
import tablero.Box;
import tablero.Map;

public class GameController implements Runnable {
	private static volatile Thread thread; 
	private Map map;
	private GameTick gameTick;
	private Avatar avatar1;
	private Avatar avatar2;
	
	public GameController(Map map) {
		this.map = map;
		this.gameTick = new GameTick(this.map.getBoard());
		this.avatar1 = new Avatar(100, Orientation.RIGHT,1);
		this.avatar2 = new Avatar(100, Orientation.UP,2);
	}

	public void Initialize() {
		this.gameTick.run();
		map.getBoard().addBox(new Point(0,1), avatar1);
		map.getBoard().addBox(new Point(6,8), avatar2);
		List<Box> boxes = new ArrayList<Box>();
		List<Point> coordinates = new ArrayList<Point>();
		boxes.add(new Box(avatar1));
		boxes.add(new Box(avatar2));
		coordinates.add(new Point(0,1));
		coordinates.add(new Point(6,8));
		this.gameTick.updateBoxes(boxes, coordinates);
		start();
	}

	@Override
	public void run() {
		int caso = 3;
		if(caso == 1) {//si el avatar gira
			this.avatar1.setOrientation(Orientation.DOWN);
			List<Box> boxes = new ArrayList<Box>();
			List<Point> coordinates = new ArrayList<Point>();
			boxes.add(new Box(avatar1));
			coordinates.add(new Point(0,1));
			this.gameTick.updateBoxes(boxes, coordinates);
		}
		else if(caso == 2) {//si el avatar avanza
			this.avatar1.setPosition(new Point(1,1));
			List<Box> boxes = new ArrayList<Box>();
			List<Point> coordinates = new ArrayList<Point>();
			boxes.add(new Box(avatar1));
			coordinates.add(new Point(1,1));
			boxes.add(null);
			coordinates.add(new Point(0,1));
			this.gameTick.updateBoxes(boxes, coordinates);
		}
		else if(caso == 3) {//si el avatar dispara
			this.avatar1.setPosition(new Point(1,1));
			List<Box> boxes = new ArrayList<Box>();
			List<Point> coordinates = new ArrayList<Point>();
			boxes.add(new Box(avatar1));
			coordinates.add(new Point(1,1));
			boxes.add(null);
			coordinates.add(new Point(0,1));
			this.gameTick.updateBoxes(boxes, coordinates);
		}
	}
	// synchronized permite que no se puedan ejecutar al mismo tiempo
	public synchronized void start() {
		thread = new Thread(this, "Graphics");
		thread.start();
	}
	
	public synchronized void stop() {
		thread = new Thread(this, "Graphics");
		thread.start();
	}
}
