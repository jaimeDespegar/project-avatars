package main;

import org.junit.Test;

import classProperties.MapProperties;

public class GameConfigurationTest {
	@Test
	public void gcTest(){
		MapProperties mp= new MapProperties(Constants.ROUTE_PROPERTIES);
		GameConfiguration gc= new GameConfiguration(2, mp);
		
		gc.getCountPlayes();
		gc.setCountPlayes(gc.getCountPlayes());
		gc.getMapConfiguration();
		gc.setMapConfiguration(gc.getMapConfiguration());
		
	}
}
