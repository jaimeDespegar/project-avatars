package tablero;

import java.awt.Point;

public class Rectangle extends ObjectGraphic{
	private Point size;
	private TypeOfEstructure typeOfStructure;
	
	public Rectangle(Point position, Point size, TypeOfEstructure typeOfStructure) {
		super(position);
		this.size = size;
		this.typeOfStructure = typeOfStructure;
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
