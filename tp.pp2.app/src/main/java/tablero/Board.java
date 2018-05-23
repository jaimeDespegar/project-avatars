package tablero;

import java.awt.Point;

import object.Avatar;

public class Board {
	private Box[][] board;
	//private HashMap<Point>
	public Board(Point sizeBoard) {
		board = new Box[sizeBoard.x][sizeBoard.y];
	}

	public Box[][] getBoard() {
		return board;
	}

	public void setBoard(Box[][] board) {
		this.board = board;
	}

	public boolean isOcupatePosition(Point box) {
		return board[box.x][box.y] != null;
	}
	
	public void printBoard() {
		String file = "";
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if(board[x][y] != null) {
					file = file + "[" +board[x][y].getObjectGraphic().getClass().getName() + "]";
				}else {
					file = file + "[" +board[x][y] + "]";
				}
			}
			System.out.println(file);
			file = "";
		}
	}
	
	public ObjectGraphic getObjectGraphic(Point pointObject) {
		if(board[pointObject.x][pointObject.y] != null) {
			return board[pointObject.x][pointObject.y].getObjectGraphic();
		}
		return null;
	}
	
	public void addObjectGraphic(Point point, ObjectGraphic objectGraphic) {
		if(!isOcupatePosition(point)) {
			board[point.x][point.y].setObjectGraphic(objectGraphic);
		}
	}
	
	public void printBoardObjectName(Point pointObject) { //Quiero saber qué tipo de Objeto está dentro de un casillero
		if(board[pointObject.x][pointObject.y] != null) {
			System.out.println(board[pointObject.x][pointObject.y].getObjectGraphic().getClass().getName());
		}
	}
	
	public void addAvatar(Point point, Avatar a){
		if(!isOcupatePosition(point)) {
			//ObjectGraphic objectGraphic= new ObjectGraphic(a.getPosition());
	//		board[point.x][point.y].setObjectGraphic(a);
		}
	}
}
