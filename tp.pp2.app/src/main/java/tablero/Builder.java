package tablero;

import java.awt.Point;

public class Builder {
	private Board board;
	
	public Builder(Point sizeBoard) {
		if (sizeBoard == null) {
	        throw new IllegalArgumentException("el tamaño no puede ser null");
		}
		board = new Board(sizeBoard);
	}
	
	public Builder withStructureRectangle(Object object) {
		addStructureByRectangle(object);
		return this;
	}
	
	public Builder withStructureLine(Object object) {
		addStructureByLine(object);
		return this;
	}
	
	public void addStructureByRectangle(Object object) {
		AddStructure.addStructureByRectangle(object);
	}
	
	public void addStructureByLine(Object object) {
		AddStructure.addStructureByLine(object);
		
	}
	
	public Map build() {
		return new Map(this);
	}

	public Board getBoard() {
		return board;
	}
}
