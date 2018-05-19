package tablero;

import java.awt.Point;

//traer los datos o info de tamaño externos
//crear tablero
//validar posiciones
public class Map {
	private Board board;
	
	public Map(Builder builder) {
		board = builder.getBoard();
	}

	public boolean isOcupatePosition(Point box) {
		return board.getBoard()[box.x][box.y].getObjectGraphic() == null;
	}

	public Board getBoard() {
		return board;
	}
	
	public void printMap() {
		this.board.printBoard();
	}
}
