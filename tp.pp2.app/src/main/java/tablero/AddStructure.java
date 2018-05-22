package tablero;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
			// throw new RuntimeException("No se puede añadir las estructuras, uno o mas
			// casilleros estan ocupados");
			JOptionPane.showMessageDialog(null,
					"No se puede añadir las estructuras, \nuno o mas casilleros estan ocupados", "Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void addStructureByLine(Board board, Line line) {
		List<Point> positionsOfLine = new ArrayList<Point>();
		Point punto1 = line.getPositions().get(0);
		Point punto2 = line.getPositions().get(1);
		Integer mayorDistancia = higherDistance(punto1, punto2);
		if (validatePositions(board, positionsOfLine)) {
			addStructures(board, positionsOfLine, line.getStructure());
		} else {
			// throw new IllegalArgumentException("No se puede añadir las estructuras, uno o
			// mas casilleros estan ocupados");
			JOptionPane.showMessageDialog(null,
					"No se puede añadir las estructuras, \nuno o mas casilleros estan ocupados", "Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private static Integer higherDistance(Point punto1, Point punto2) {
		int difX = (punto1.x - punto2.x);
		int difY = (punto1.y - punto2.y);
		return null;
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
			board.getBoard()[pos.x][pos.y] = new Box(structure);
		}
	}
}

// creamos arrays de las posiciones en las cuales se quiere agregar la
// estructura (esto por rectangulo y otro por linea)
// contramos si las posiciones de las estructuras estan ocupadas o no (esto para
// ambos)
// agregamos las estructuras al tablero, si es que no estan ocupadas las
// posiciones (esto para ambos)