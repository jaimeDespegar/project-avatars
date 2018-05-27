package tablero;

import java.awt.Point;

public class Board {
	private Box[][] boxes;

	public Board(Point sizeBoard) {
		//boxes = new Box[sizeBoard.x][sizeBoard.y];
		boxes = new Box[sizeBoard.y][sizeBoard.x];
	}

	public Box[][] getBoxes() {
		return boxes;
	}

	public void setBox(Box[][] boxes) {
		this.boxes = boxes;
	}

	public boolean isOcupatePosition(Point box) {
		//return boxes[box.x][box.y] != null;
		return boxes[box.y][box.x]!= null;
	}
	
	public Box getBox(Point pointBox) {
		//return boxes[pointBox.x][pointBox.y];
		return boxes[pointBox.y][pointBox.x];
	}

	public void deleteBox(Point pointBox) {
		//boxes[pointBox.x][pointBox.y] = null;
		boxes[pointBox.y][pointBox.x] = null;
	}
	
	public void addBox(Point pointBox, Object object) {
		boxes[pointBox.x][pointBox.y] = new Box((ObjectGraphic) object);
	}
	
	public void printBoard() {
		String file = "";
		for (int x = 0; x < boxes.length; x++) {
			for (int y = 0; y < boxes[0].length; y++) {
				if(boxes[x][y] != null) {
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
		return new Point(boxes.length, boxes[boxes.length].length);
	}
}
