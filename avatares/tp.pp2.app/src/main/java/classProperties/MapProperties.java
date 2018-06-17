package classProperties;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import enums.TypeOfStructure;
import object.Line;
import object.Rectangle;
import object.Structure;

public class MapProperties {
	private Properties properties;
	private ElectionMap electionMap;

	public MapProperties(String route_properties) {
		this.properties = new Properties();
		loadProperties(route_properties);
		loadDataProperties();
	}
	
	private void loadDataProperties() {
		Point mapSize = loadSizeMap();
		Rectangle rectangle1 = null, rectangle2 = null;
		if(Integer.parseInt(properties.getProperty("cantRectangles"))>0) {
			rectangle1 = loadRectangle("rectangle1posX", "rectangle1posY", "rectangle1ancho", "rectangle1alto",
				"rectangle1typeOfStructure");
			rectangle2 = loadRectangle("rectangle2posX", "rectangle2posY", "rectangle2ancho", "rectangle2alto",
				"rectangle2typeOfStructure");
		}
		Line line1 = null, line2 = null;
		if(Integer.parseInt(properties.getProperty("cantLines"))>0) {
			line1 = loadLine("line1posX1", "line1posY1", "line1posX2", "line1posY2", "line1typeOfStructure");
			line2 = loadLine("line2posX1", "line2posY1", "line2posX2", "line2posY2", "line2typeOfStructure");
		}
		this.electionMap = new ElectionMap(mapSize, rectangle1, rectangle2, line1, line2);
	}

	private Line loadLine(String linePosX1, String linePosY1, String linePosX2, String linePosY2, String lineTypeOfStructure) {
		Point point1 = new Point(Integer.parseInt(properties.getProperty(linePosX1)), Integer.parseInt(properties.getProperty(linePosY1)));
		Point point2 = new Point(Integer.parseInt(properties.getProperty(linePosX2)), Integer.parseInt(properties.getProperty(linePosY2)));
		String typeOfStructureByLine = properties.getProperty(lineTypeOfStructure);
		Structure structure = loadStructure(typeOfStructureByLine);
		List<Point> list = new ArrayList<Point>();
		list.add(point1);
		list.add(point2);
		return new Line(list, structure);
	}

	private Rectangle loadRectangle(String rectangleposX, String rectangleposY, String rectangleAlto,
			String rectangleAncho, String rectangletypeOfStructure) {
		Integer rectangle1posX = Integer.parseInt(properties.getProperty(rectangleposX));
		Integer rectangle1posY = Integer.parseInt(properties.getProperty(rectangleposY));
		Integer rectangle1ancho = Integer.parseInt(properties.getProperty(rectangleAlto));
		Integer rectangle1alto = Integer.parseInt(properties.getProperty(rectangleAncho));
		String rectangle1typeOfStructure = properties.getProperty(rectangletypeOfStructure);
		Structure structureRectangle = loadStructure(rectangle1typeOfStructure);
		return new Rectangle(new Point(rectangle1posX, rectangle1posY), new Point(rectangle1ancho, rectangle1alto),
				structureRectangle);
	}

	private Structure loadStructure(String typeOfStructure) {
		Structure structure = null;
		structure = (typeOfStructure.equals("ACERO")) ? new Structure(TypeOfStructure.ACERO) : structure;
		structure = (typeOfStructure.equals("AGUA")) ? new Structure(TypeOfStructure.AGUA) : structure;
		structure = (typeOfStructure.equals("BOSQUE")) ? new Structure(TypeOfStructure.BOSQUE) : structure;
		structure = (typeOfStructure.equals("LADRILLO")) ? new Structure(TypeOfStructure.LADRILLO) : structure;
		return structure;
	}

	private Point loadSizeMap() {
		return new Point(Integer.parseInt(properties.getProperty("heightMap")),
				Integer.parseInt(properties.getProperty("widthMap")));
	}

	private void loadProperties(String route_properties) {
		try {
			this.properties.load(new FileReader(route_properties));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ElectionMap getElectionMap() {
		return electionMap;
	}
}
