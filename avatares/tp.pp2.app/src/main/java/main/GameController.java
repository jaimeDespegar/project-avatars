package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classProperties.ElectionKeyAvatar;
import com.google.common.collect.Lists;
import enums.Orientation;
import json.CreateJson;
import object.Avatar;
import object.KeyDto;
import tablero.Box;
import tablero.Map;
import turn.ManagerMove;

public class GameController implements Runnable {
	private static volatile Thread thread; 
	private Map map;
	private Game game;
	private Avatar avatar1;
	private Avatar avatar2;
	private ManagerMove managerTurn;
	private List<KeyDto> listEnabledKeys;

	public GameController(Game game) {
		this.game = game;
		this.map = game.getMap();
		this.managerTurn = new ManagerMove(this.game);
		this.avatar1 = game.getAvatars().get(0);
		this.avatar2 = game.getAvatars().get(1);

		this.listEnabledKeys  = Lists.newArrayList();
	}


	public void Initialize() {
		map.addBox(new Point(0,1), game.getAvatars().get(0));
		map.addBox(new Point(6,8), game.getAvatars().get(1));
		map.printMap();
		CreateJson createJson = new CreateJson(this.map.getBoard());
		createJson.createNewJson();
//		CREATE JSON (con mapa y avatares)
	}

	@Override
	public void run() {
		int turnoPlayer = 1;
		while(!this.game.getAvatars().contains(null)) {
			//turno player 1 or 2
			//obtener teclas que generan el movimiento del player
			//gira  -> crea json
			//mueve -> crea json
			//shoot -> crea un gran json -> cambia de turno
			//System.out.println(this.game.getAvatars().get(turnoPlayer).getKeys().getKeyShoot().getKeyValue());
			//if()
			
		/*	managerTurn.manageMoves();
			if (managerTurn.isMyTurn(avatar1.getId().toString())){
				enabledKeys(avatar1.getKeys());
			}
			if (managerTurn.isMyTurn(avatar2.getId().toString())){
				enabledKeys(avatar2.getKeys());
			}*/	
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
//	public void refreshPositionAvatar(Avatar avatar) {
//		KeyDto key = game.getKeyboard().getKeyPressed();
//		if(this.listEnabledKeys.contains(key)) {
//			// solo si la tecla esta habilitada!  == es turno de un solo player
//
//			Listener listener = factoryListener.getListenerByKey(key);
//			Point newPoint = listener.actionMove(avatar, avatar.getPosition());
//
//			// el aca el avatar ya giro o cambio de posicion
//			// redibujarlo con este nuevo point
//
//		}
//	}

}