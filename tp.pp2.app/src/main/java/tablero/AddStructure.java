package tablero;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import object.Line;
import object.Rectangle;
import object.Structure;

public class AddStructure {

	public static void addStructureByRectangle(Board board, Rectangle rectangle) {
		List<Point> positionsOfRectangle = new ArrayList<Point>();
		for (int x = rectangle.getPosition().x; x < rectangle.getPosition().x + rectangle.getSize().getX(); x++) {
			for (int y = rectangle.getPosition().y; y < rectangle.getPosition().y + rectangle.getSize().getY(); y++) {
				positionsOfRectangle.add(new Point(y, x));
			}
		}
		if (validatePositions(board, positionsOfRectangle)) {
			addStructures(board, positionsOfRectangle, rectangle.getStructure());
		} else {
			JOptionPane.showMessageDialog(null,
					"No se puede añadir las estructuras, \nuno o mas casilleros estan ocupados", "Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void addStructureByLine(Board board, Line line) {
		Point punto1 = line.getPositions().get(0);
		Point punto2 = line.getPositions().get(1);
		List<Point> positionsOfLine = createListOfPositionsLine(punto1, punto2);
		if (validatePositions(board, positionsOfLine)) {
			addStructures(board, positionsOfLine, line.getStructure());
		} else {
			JOptionPane.showMessageDialog(null,
					"No se puede añadir las estructuras, \nuno o mas casilleros estan ocupados", "Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private static List<Point> createListOfPositionsLine(Point point1, Point point2) {
		List<Point> positionsOfLine = new ArrayList<Point>();
		// si el x=1 se que es vertical la linea.
		if (point1.x - point2.x == 0) {
			if (point1.y <= point2.y) {
				for (int i = point1.y; i <= point2.y; i++) {
					positionsOfLine.add(new Point(point1.x, i));
				}
			} else {
				for (int i = point2.y; i <= point1.y; i++) {
					positionsOfLine.add(new Point(point1.x, i));
				}
			}
		} else if (point1.y - point2.y == 0) {
			// si el y=1 se que es horizontal la linea
			if (point1.x <= point2.x) {
				for (int i = point1.x; i <= point2.x; i++) {
					positionsOfLine.add(new Point(point1.y, i));
				}
			} else {
				for (int i = point2.x; i <= point1.x; i++) {
					positionsOfLine.add(new Point(point1.y, i));
				}
			}
		} // cruzada
		else if (point1.x - point2.x == point1.y - point2.y || point1.x - point2.x == point2.y - point1.y) {
			positionsOfLine.add(new Point(point1.x, point1.y));
			if (point1.x < point2.x) { // va hacia la derecha
				if (point1.y < point2.y) { // va hacia abajo
					for (int i = 0; i <= point2.x - point1.x; i++) {
						positionsOfLine.add(new Point(point1.x + i, point1.y + i));
					}
				} else { // va hacia arriba
					for (int i = 0; i <= point1.x - point2.x; i++) {
						positionsOfLine.add(new Point(point1.x + i, point1.y - i));
					}
				}
			} else { // va hacia la izquierda
				if (point2.y < point1.y) { // va hacia abajo
					for (int i = 0; i <= point1.x - point2.x; i++) {
						positionsOfLine.add(new Point(point2.x + i, point2.y + i));
					}
				} else { // va hacia arriba
					for (int i = 0; i <= point2.x - point1.x; i++) {
						positionsOfLine.add(new Point(point2.x + i, point2.y - i));
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se puede añadir las estructuras, \nno es una línea válida",
					"Error!", JOptionPane.ERROR_MESSAGE);
		}
		return positionsOfLine;
	}

	private static boolean validatePositions(Board board, List<Point> positionsOfStructure) {
		for (Point pos : positionsOfStructure) {
			if (board.isOcupatePosition(pos)) {
				return false;
			}
		}
		return true;
	}

	private static void addStructures(Board board, List<Point> positionsOfRectangle, Structure structure) {
		for (Point pos : positionsOfRectangle) {
			board.getBoxes()[pos.x][pos.y] = new Box(structure);
		}
	}
}