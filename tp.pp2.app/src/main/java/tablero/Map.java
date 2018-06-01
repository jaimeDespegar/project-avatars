package tablero;

import java.awt.Point;

public class Map {
	private Board board;
	
	public Map(Builder builder) {
		board = builder.getBoard();
	}
	
	public Board getBoard() {
		return board;
	}
	
	public Box getBox(Point pointBox) {
		return board.getBox(pointBox);
	}
	
	public void addBox(Point pointBox,Object object) {
		board.addBox(pointBox,object);
	}

	public void deleteBox(Point pointBox) {
		board.deleteBox(pointBox);
	}
	
	public void printMap() {
		this.board.printBoard();
	}
	
	public Point getLimitsBoard() {
		return board.getLimitsBoard();
	}
}
