package tablero;

import java.awt.Point;

import enums.TypeOfStructure;

public class Structure extends ObjectGraphic{
	private TypeOfStructure typeOfStructure;
	
	public Structure(Point position, TypeOfStructure typeOfStructure) {
		super(position);
		this.typeOfStructure = typeOfStructure;
	}

	public TypeOfStructure getTypeOfStructure() {
		return typeOfStructure;
	}

	public void setTypeOfStructure(TypeOfStructure typeOfStructure) {
		this.typeOfStructure = typeOfStructure;
	}
}
