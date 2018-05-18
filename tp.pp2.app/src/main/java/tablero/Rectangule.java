package tablero;

import java.awt.Point;

public class Rectangule {
	private Point position;
	private Point size;
	private TypeOfEstructure typeOfStructure;
	
	public Rectangule(Point position, Point size, TypeOfEstructure typeOfStructure) {
		this.position = position;
		this.size = size;
		this.typeOfStructure = typeOfStructure;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Point getSize() {
		return size;
	}

	public void setSize(Point size) {
		this.size = size;
	}

	public TypeOfEstructure getTypeOfStructure() {
		return typeOfStructure;
	}

	public void setTypeOfStructure(TypeOfEstructure typeOfStructure) {
		this.typeOfStructure = typeOfStructure;
	}
}
