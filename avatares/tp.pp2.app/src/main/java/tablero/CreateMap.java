package tablero;

import classProperties.MapProperties;

public class CreateMap {
	private Map map;
	private MapProperties mapProperties;
	
	public CreateMap (String route_properties) {
		mapProperties = new MapProperties(route_properties);
		createMap();
	}
	
	private void createMap() {
		map = new Builder(mapProperties.getElectionMap().getMapSize())
				.withStructureRectangle(mapProperties.getElectionMap().getRectangle1())
				.withStructureRectangle(mapProperties.getElectionMap().getRectangle2())
				.withStructureLine(mapProperties.getElectionMap().getLine1())
				.withStructureLine(mapProperties.getElectionMap().getLine2())
				.build();
	}

	public Map getMap() {
		return map;
	}

	public MapProperties getMapProperties() {
		return mapProperties;
	}
}
