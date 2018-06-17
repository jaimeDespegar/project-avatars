package tablero;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import object.Line;
import object.Rectangle;
import object.Structure;

public class AddStructure {

	public static void addStructureByRectangle(Board board, Rectangle rectangle) {
		List<Point> positionsOfRectangle = new ArrayList<Point>();
		for (int x = rectangle.getPosition().x; x < rectangle.getPosition().x + rectangle.getSize().getX(); x++) {
			for (int y = rectangle.getPosition().y; y < rectangle.getPosition().y + rectangle.getSize().getY(); y++) {
				//positionsOfRectangle.add(new Point(y, x));
				positionsOfRectangle.add(new Point(x, y));
			}
		}
		if (validatePositions(board, positionsOfRectangle) && !rectangle.getStructure().equals(null)) {
			addStructures(board, positionsOfRectangle, rectangle.getStructure());
		} else {
			throw new RuntimeException("No se puede a�adir las estructuras, uno o mas casilleros estan ocupados");
		}
	}

	public static void addStructureByLine(Board board, Line line) {
		Point punto1 = line.getPositions().get(0);
		Point punto2 = line.getPositions().get(1);
		List<Point> positionsOfLine = CreateListOfPointsLine.createListOfPositionsLine(punto1, punto2);
		if (validatePositions(board, positionsOfLine)) {
			addStructures(board, positionsOfLine, line.getStructure());
		} else {
			throw new RuntimeException("No se puede a�adir las estructuras, uno o mas casilleros estan ocupados");
		}
	}

	public static boolean validatePositions(Board board, List<Point> positionsOfStructure) {
		for (Point pos : positionsOfStructure) {
			if (board.isOcupatePosition(pos)) {
				return false;
			}
		}
		return true;
	}

	public static void addStructures(Board board, List<Point> positions, Structure structure) {
		for (Point pos : positions) {
			board.getBoxes()[pos.y][pos.x] = new Box(structure);
		}
	}
}