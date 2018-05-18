package tablero;

import java.awt.Point;

public class Board {
	private Box[][] board;

	public Board(Point sizeBoard) {
		board = new Box[sizeBoard.x][sizeBoard.y];
	}

	public Box[][] getBoard() {
		return board;
	}

	public void setBoard(Box[][] board) {
		this.board = board;
	}

	public void printBoard() {
		String file = "";
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				file = file + "[" +board[x][y] + "]";
			}
			System.out.println(file);
			file = "";
		}
	}

}
