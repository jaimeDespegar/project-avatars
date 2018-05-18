package tablero;

import java.awt.Point;

public class Builder {
	private Board board;
	
	public Builder(Point sizeBoard) {
		if (sizeBoard == null) {
	        throw new IllegalArgumentException("profession and name can not be null");
		}
		board = new Board(sizeBoard);
	}
	
	//agregar estructura rectangulo - y linea
	public Builder withStructureRectangulo(Object object) {
		addStructure(object);
		return this;
	}
	
	public Builder withStructureLine(Object object) {
		addStructure(object);
		return this;
	}
	
	public void addStructure(Object object) {
		//case (object.getClass().getName().equals("Rectangule")){
			
		//}
	}
	
	public Map build() {
		return new Map(this);
	}

	public Board getBoard() {
		return board;
	}
}
