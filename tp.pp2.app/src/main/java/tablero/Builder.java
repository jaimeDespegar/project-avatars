package tablero;

import java.awt.Point;

import main.Constants;
import object.Line;
import object.Rectangle;

public class Builder {
	private Board board;
	
	public Builder(Point sizeBoard) {
		if (sizeBoard == null) {
	        throw new IllegalArgumentException("el tamaño no puede ser null");
		}else if(sizeBoard.x <=1 || sizeBoard.y <= 1) {
			sizeBoard = takeSizeBoardByDefault();
	        //throw new IllegalArgumentException("el tamaño no puede ser menor a 1");
		}
		board = new Board(sizeBoard);
	}
	
	public Point takeSizeBoardByDefault() {
		return Constants.MAPA_DEFAULT;	
	}

	public Builder withStructureRectangle(Rectangle rectangle) {
		addStructureByRectangle(board,rectangle);
		return this;
	}
	
	public Builder withStructureLine(Line line) {
		addStructureByLine(board, line);
		return this;
	}
	
	public void addStructureByRectangle(Board board, Rectangle rectangle) {
		AddStructure.addStructureByRectangle(board, rectangle);
	}
	
	public void addStructureByLine(Board board, Line line) {
		AddStructure.addStructureByLine(board, line);
	}
	
	public Map build() {
		return new Map(this);
	}

	public Board getBoard() {
		return board;
	}
}
