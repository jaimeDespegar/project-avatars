package object;

import java.awt.Point;
import java.util.List;

public class Line extends ObjectGraphic{
	private List<Point> positions;
	private Structure structure;
	
	public Line (List<Point> positions, Structure structure) {
		super();
		this.positions = positions;
		this.structure = structure;
	}

	public List<Point> getPositions() {
		return positions;
	}

	public Structure getStructure() {
		return structure;
	}

}
