package tablero;

import java.awt.Point;

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
	
	public void printBoardObjectName(Point pointObject) { //Quiero saber qué tipo de Objeto está dentro de un casillero
		if(board[pointObject.x][pointObject.y] != null) {
			System.out.println(board[pointObject.x][pointObject.y].getObjectGraphic().getClass().getName());
		}
	}
}
