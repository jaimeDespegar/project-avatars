package tablero;

import java.awt.Point;

public class ObjectGraphic {
	private Point position;
	
	public ObjectGraphic(Point position) {
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
}
