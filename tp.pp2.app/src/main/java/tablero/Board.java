package tablero;

import java.awt.Point;
import object.ObjectGraphic;
import object.Structure;

public class Board {
	private Box[][] boxes;

	public Board(Point sizeBoard) {
		boxes = new Box[sizeBoard.x][sizeBoard.y];
	}

	public Box[][] getBoxes() {
		return boxes;
	}
	
	public boolean isOcupatePosition(Point box) {
		if((boxes.length <= box.x) || (0 > box.x) || (boxes[0].length <= box.y) || (0 > box.y)) {
	        throw new IllegalArgumentException("No se puede acceder a la casilla, excede el límite del mapa");
		}
		return boxes[box.x][box.y] != null;
	}

	public Box getBox(Point pointBox) {
		return boxes[pointBox.x][pointBox.y];
	}

	public void deleteBox(Point pointBox) {
		boxes[pointBox.x][pointBox.y] = null;
	}
	
	public void addBox(Point pointBox, Object object) {
		boxes[pointBox.x][pointBox.y] = new Box((ObjectGraphic) object);
	}
	
	public boolean isOcupatePositionMAP(Point boxOriginal) {
		Point box= new Point(boxOriginal.y, boxOriginal.x);
		if((boxes.length <= box.x) || (0 > box.x) || (boxes[0].length <= box.y) || (0 > box.y)) {
			throw new IllegalArgumentException("No se puede acceder a la casilla, excede el límite del mapa");
		}
		return boxes[box.x][box.y] != null;
	}
	
	public void addBoxGameObject(Point pointBox, Object object) {
		boxes[pointBox.y][pointBox.x] = new Box((ObjectGraphic) object);
	}
	public Box getBoxGameObject(Point pointBox) {
		return boxes[pointBox.y][pointBox.x];
	}

	public void deleteBoxGameObject(Point pointBox) {
		boxes[pointBox.x][pointBox.y] = null;
	}
	
	public void printBoard() {
		String file = "";
		for (int x = 0; x < boxes.length; x++) {
			for (int y = 0; y < boxes[0].length; y++) {
				if(boxes[x][y] != null) {
					if(boxes[x][y].getObjectGraphic().getClass().equals(Structure.class))
						file = file + "[" +((Structure) boxes[x][y].getObjectGraphic()).getTypeOfStructure().name() + "]";
					else
						file = file + "[" +boxes[x][y].getObjectGraphic().getClass().getName() + "]";
				}else {
					file = file + "[" +boxes[x][y] + "]";
				}
			}
			System.out.println(file);
			file = "";
		}
	}

	public Point getLimitsBoard() {
		return new Point(boxes.length, boxes[0].length);
	}
}
