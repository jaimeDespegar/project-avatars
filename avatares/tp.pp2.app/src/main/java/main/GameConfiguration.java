package main;

import classProperties.MapProperties;

public class GameConfiguration {

	private Integer countPlayes;
	private MapProperties mapConfiguration;

	public GameConfiguration(Integer countPlayes, MapProperties mapConfiguration) {
		this.countPlayes = countPlayes;
		this.mapConfiguration = mapConfiguration;
	}

	public Integer getCountPlayes() {
		return countPlayes;
	}

	public void setCountPlayes(Integer countPlayes) {
		this.countPlayes = countPlayes;
	}

	public MapProperties getMapConfiguration() {
		return mapConfiguration;
	}

	public void setMapConfiguration(MapProperties mapConfiguration) {
		this.mapConfiguration = mapConfiguration;
	}

}
