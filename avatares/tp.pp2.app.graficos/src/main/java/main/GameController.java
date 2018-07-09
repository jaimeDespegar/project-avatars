package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classProperties.ElectionKeyAvatar;
import com.google.common.collect.Lists;
import draftmans.GameTick;
import enums.Orientation;
import listeners.FactoryListener;
import listeners.Listener;
import object.Avatar;
import object.KeyDto;
import tablero.Box;
import tablero.Map;
import turn.ManagerMove;

public class GameController implements Runnable {
	private static volatile Thread thread; 
	private Map map;
	private GameTick gameTick;
	private Game game;
	private Avatar avatar1;
	private Avatar avatar2;
	private FactoryListener factoryListener;
	private ManagerMove managerTurn;
	private List<KeyDto> listEnabledKeys;

	public GameController(Game game) {
		this.game = game;
		this.map = game.getMap();
		this.gameTick = new GameTick(this.map, game);
		this.factoryListener = FactoryListener.getInstancie();
		this.managerTurn = new ManagerMove(this.game);
		this.avatar1 = game.getAvatars().get(0);
		this.avatar2 = game.getAvatars().get(1);

		this.listEnabledKeys  = Lists.newArrayList();
		// agrego los listenres de cada avatar
		game.getAvatars().forEach(a -> factoryListener.loadListeners(a.getKeys()));
	}


	public void Initialize() {
		this.gameTick.run();
		map.addBox(new Point(0,1), avatar1);
		map.addBox(new Point(6,8), avatar2);
		List<Box> boxes = Lists.newArrayList();
		List<Point> coordinates = Lists.newArrayList();
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

		// inicia los turnos
		// esto tiene qe estar loopeando siempre
		managerTurn.manageMoves();
		if (managerTurn.isMyTurn(avatar1.getId().toString())){
			enabledKeys(avatar1.getKeys());
		}
		if (managerTurn.isMyTurn(avatar2.getId().toString())){
			enabledKeys(avatar2.getKeys());
		}

	}

	private void enabledKeys(ElectionKeyAvatar keys) { // habilita las teclas que se pasn como parametro- seria de un solo player
		this.listEnabledKeys.clear();
		this.listEnabledKeys.addAll(Arrays.asList(keys.getKeyDown(),  keys.getKeyUp(), 	keys.getKeyLeft(),
				keys.getKeyRight(), keys.getKeyPower1(), keys.getKeyPower2(),
				keys.getKeyShoot()));
	}



	// synchronized permite que no se puedan ejecutar al mismo tiempo
	public synchronized void start() {
		thread = new Thread(this, "Graphics");
		thread.start();
	}
	
	public synchronized void stop() {
		// porqe para pararlo se lanza otro thread ??
		thread = new Thread(this, "Graphics");
		thread.start();
	}

	// si se presiono una tecla de mov del avatar , ejecuto la accion de mov : up,down,right,left
	public void refreshPositionAvatar(Avatar avatar) {
		KeyDto key = game.getKeyboard().getKeyPressed();
		if(this.listEnabledKeys.contains(key)) {
			// solo si la tecla esta habilitada!  == es turno de un solo player

			Listener listener = factoryListener.getListenerByKey(key);
			Point newPoint = listener.actionMove(avatar, avatar.getPosition());

			// el aca el avatar ya giro o cambio de posicion
			// redibujarlo con este nuevo point

		}
	}

}