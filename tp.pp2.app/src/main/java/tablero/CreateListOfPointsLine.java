package tablero;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class CreateListOfPointsLine {
	
	public static List<Point> createListOfPositionsLine(Point point1, Point point2) {
		List<Point> positionsOfLine = new ArrayList<Point>();
		if (point1.x - point2.x == 0) {			// si el x=1 se que es vertical la linea.
			addLineVertical(point1,point2,positionsOfLine);
		} else if (point1.y - point2.y == 0) {	// si el y=1 se que es horizontal la linea
			addLineHorizontal(point1,point2,positionsOfLine);
		} else {								// diagonal
			addLineDiagonal(point1,point2,positionsOfLine);
		}
		if(!positionsOfLine.contains(point2))
			throw new RuntimeException("No se puede añadir las estructuras, no es una linea valida");
		return positionsOfLine;
	}
	
	private static void addLineHorizontal(Point point1, Point point2, List<Point> positionsOfLine) {
		if (point1.x <= point2.x) {
			for (int i = point1.x; i <= point2.x; i++) {
				positionsOfLine.add(new Point(i,point1.y));
			}
		} else {
			for (int i = point2.x; i <= point1.x; i++) {
				positionsOfLine.add(new Point(i , point1.y));
			}
		}
	}
	
	private static void addLineVertical(Point point1, Point point2, List<Point> positionsOfLine) {
		if (point1.y <= point2.y) {
			for (int i = point1.y; i <= point2.y; i++) {
				positionsOfLine.add(new Point(point1.x, i));
			}
		} else {
			for (int i = point2.y; i <= point1.y; i++) {
				positionsOfLine.add(new Point(point1.x, i));
			}
		}
	}
	
	private static void addLineDiagonal(Point point1, Point point2, List<Point> positionsOfLine) {
		positionsOfLine.add(new Point(point1.x, point1.y));
		if (point1.x < point2.x) { // va hacia la derecha
			if (point1.y < point2.y) { // va hacia abajo
				for (int i = 0; i <= point2.x - point1.x; i++) {
					positionsOfLine.add(new Point(point1.x + i, point1.y + i));
				}
			} else { // va hacia arriba
				for (int i = 0; i <= point2.x - point1.x; i++) {
					positionsOfLine.add(new Point(point1.x + i, point1.y - i));
				}
			}
		} else { // va hacia la izquierda
			if (point1.y < point2.y) { // va hacia abajo
				System.out.println("si");
				for (int i = 0; i <= point1.x - point2.x; i++) {
					positionsOfLine.add(new Point(point1.x - i, point1.y + i));
				}
			} else { // va hacia arriba
				for (int i = 0; i <= point1.x - point2.x; i++) {
					positionsOfLine.add(new Point(point1.x - i, point1.y - i));
				}
			}
		}
	}
	
}
