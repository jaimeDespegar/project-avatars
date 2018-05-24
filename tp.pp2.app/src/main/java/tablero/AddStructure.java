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
		if(punto1.x > punto2.x) {
			for(int X = punto1.x; X < (punto2.x); X++) {
				Integer Y = createFunctionByLine(punto1, punto2, X);
				positionsOfLine.add(new Point (X,Y));
			}
		}else {
			for(int X = punto2.x; X < (punto1.x); X++) {
				Integer Y = createFunctionByLine(punto1, punto2, X);
				positionsOfLine.add(new Point (X,Y));
			}
		}
		if (validatePositions(board, positionsOfLine)) {
			System.out.println(positionsOfLine.size());
			addStructures(board, positionsOfLine, line.getStructure());
		} else {
			// throw new IllegalArgumentException("No se puede añadir las estructuras, uno o
			// mas casilleros estan ocupados");
			JOptionPane.showMessageDialog(null,
					"No se puede añadir las estructuras, \nuno o mas casilleros estan ocupados", "Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}
//con esto creo la funcion de la recta de los dos puntos, si le paso un X y un Y, calulo por que punto pasa, osea pones un x 7 te da un y.
	private static Integer createFunctionByLine(Point punto1, Point punto2, Integer X) {
		Integer function = ((punto2.y - punto1.y)/(punto2.x - punto1.x))* (X - punto1.x) + punto1.y;
		//dom [(x1,y1) -> (x2,y2)]
		return function;//seria la Y
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

// creamos arrays de las posiciones en las cuales se quiere agregar la
// estructura (esto por rectangulo y otro por linea)
// contramos si las posiciones de las estructuras estan ocupadas o no (esto para
// ambos)
// agregamos las estructuras al tablero, si es que no estan ocupadas las
// posiciones (esto para ambos)