package tablero;

import java.awt.Point;

import object.Avatar;

public class Board {
	private Box[][] boxes;

	public Board(Point sizeBoard) {
		boxes = new Box[sizeBoard.x][sizeBoard.y];
	}

	public Box[][] getBoxes() {
		return boxes;
	}

	public void setBox(Box[][] boxes) {
		this.boxes = boxes;
	}

	public boolean isOcupatePosition(Point box) {
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
	
	
	///DE ACA PARA ABAJO SE VA
	public ObjectGraphic getObjectGraphic(Point pointObject) {
		if(boxes[pointObject.x][pointObject.y] != null) {
			return boxes[pointObject.x][pointObject.y].getObjectGraphic();
		}
		return null;
	}
	
	public void addObjectGraphic(Point point, ObjectGraphic objectGraphic) {
		if(!isOcupatePosition(point)) {
			boxes[point.x][point.y].setObjectGraphic(objectGraphic);
		}
	}
	
	public void printBoardObjectName(Point pointObject) { //Quiero saber qué tipo de Objeto está dentro de un casillero
		if(boxes[pointObject.x][pointObject.y] != null) {
			System.out.println(boxes[pointObject.x][pointObject.y].getObjectGraphic().getClass().getName());
		}
	}
	
	public void addAvatar(Point point, Avatar a){
		if(!isOcupatePosition(point)) {
			//ObjectGraphic objectGraphic= new ObjectGraphic(a.getPosition());
	//		board[point.x][point.y].setObjectGraphic(a);
		}
	}
}
