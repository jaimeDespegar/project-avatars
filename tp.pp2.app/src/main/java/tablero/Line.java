package tablero;

import java.awt.Point;
import java.util.List;

public class Line extends ObjectGraphic{
	private List<Point> positions;
	private Structure structure;
	
	public Line (Point position, List<Point> positions, Structure structure) {
		super(position);
		this.positions = positions;
		this.structure = structure;
	}

	public List<Point> getPositions() {
		return positions;
	}

	public void setPositions(List<Point> positions) {
		this.positions = positions;
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}
}
