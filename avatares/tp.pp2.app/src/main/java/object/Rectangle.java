package object;

import java.awt.Point;

public class Rectangle extends ObjectGraphic{
	private Point position;
	private Point size;
	private Structure structure;
	
	public Rectangle(Point position, Point size, Structure structure) {
		this.position = position;
		this.size = size;
		this.structure = structure;
	}

	public Point getPosition() {
		return position;
	}

	public Point getSize() {
		return size;
	}

	public Structure getStructure() {
		return structure;
	}
}
