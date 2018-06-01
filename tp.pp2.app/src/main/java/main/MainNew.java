package main;

import tablero.CreateMap;

public class MainNew {

	public static void main(String[] args) {
		CreateMap createMap = new CreateMap(Constants.ROUTE_PROPERTIES);
		createMap.createMap();
		GameController gameController = new GameController(createMap.getMap());
		gameController.Initialize();
	}
}
