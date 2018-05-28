package classProperties;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.TypeOfStructure;
import main.Constants;
import tablero.Line;
import tablero.Rectangle;
import tablero.Structure;

public class MapProperties {
	private Properties properties;
	private ElectionMap electionMap;

	public MapProperties() {
		this.properties = new Properties();
		loadProperties();
		loadDataProperties();
	}

	private void loadDataProperties() {
		Point mapSize = loadSizeMap();
		Rectangle rectangle1 = loadRectangle("rectangle1posX", "rectangle1posY", "rectangle1ancho", "rectangle1alto",
				"rectangle1typeOfStructure");
		Rectangle rectangle2 = loadRectangle("rectangle2posX", "rectangle2posY", "rectangle2ancho", "rectangle2alto",
				"rectangle2typeOfStructure");
		Line line1 = null;
		Line line2 = null;
		this.electionMap = new ElectionMap(mapSize, rectangle1, rectangle2, line1, line2);
	}

	private Rectangle loadRectangle(String rectangleposX, String rectangleposY, String rectangleAlto,
			String rectangleAncho, String rectangletypeOfStructure) {
		Integer rectangle1posX = Integer.parseInt(properties.getProperty(rectangleposX));
		Integer rectangle1posY = Integer.parseInt(properties.getProperty(rectangleposY));
		Integer rectangle1ancho = Integer.parseInt(properties.getProperty(rectangleAlto));
		Integer rectangle1alto = Integer.parseInt(properties.getProperty(rectangleAncho));
		String rectangle1typeOfStructure = properties.getProperty(rectangletypeOfStructure);
		Structure structureRectangle = loadStructureRectangle(rectangle1typeOfStructure);
		return new Rectangle(new Point(rectangle1posX, rectangle1posY), new Point(rectangle1ancho, rectangle1alto),
				structureRectangle);
	}

	private Structure loadStructureRectangle(String typeOfStructure) {
		Structure structure = new Structure(TypeOfStructure.ACERO);
		return structure;
	}

	private Point loadSizeMap() {
		return new Point(Integer.parseInt(properties.getProperty("heigthMap")),
				Integer.parseInt(properties.getProperty("widthMap")));
	}

	private void loadProperties() {
		try {
			this.properties.load(new FileReader(Constants.ROUTE_PROPERTIES));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ElectionMap getElectionMap() {
		return electionMap;
	}
}
