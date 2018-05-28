package classProperties;

import java.awt.Point;

import tablero.Line;
import tablero.Rectangle;

public class ElectionMap {
	private Point mapSize;
	private Rectangle rectangle1;
	private Rectangle rectangle2;
	private Line line1;
	private Line line2;
	
	public ElectionMap(Point mapSize, Rectangle rectangle1, Rectangle rectangle2, Line line1, Line line2) {
		this.mapSize = mapSize;
		this.rectangle1 = rectangle1;
		this.rectangle2 = rectangle2;
		this.line1 = line1;
		this.line2 = line2;
	}
	
	public Point getMapSize() {
		return mapSize;
	}
	public Rectangle getRectangle1() {
		return rectangle1;
	}
	public Rectangle getRectangle2() {
		return rectangle2;
	}
	public Line getLine1() {
		return line1;
	}
	public Line getLine2() {
		return line2;
	}
}
