package tablero;

import java.awt.Point;
import java.util.List;

public class Line extends ObjectGraphic{
	private List<Point> positions;
	private TypeOfEstructure typeOfStructure;
	
	public Line (Point position, List<Point> positions, TypeOfEstructure typeOfStructure) {
		super(position);
		this.positions = positions;
		this.typeOfStructure = typeOfStructure;
	}

	public List<Point> getPositions() {
		return positions;
	}

	public void setPositions(List<Point> positions) {
		this.positions = positions;
	}

	public TypeOfEstructure getTypeOfStructure() {
		return typeOfStructure;
	}

	public void setTypeOfStructure(TypeOfEstructure typeOfStructure) {
		this.typeOfStructure = typeOfStructure;
	}
}
